package com.able.simpleTag;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
//�������ӵ�
public class RefererTag extends SimpleTagSupport {
	private String site;
	private String page;
	public void setSite(String site) {
		this.site = site;
	}
	public void setPage(String page) {
		this.page = page;
	}
	@Override
	public void doTag() throws JspException, IOException {
		PageContext pageContext =(PageContext) this.getJspContext();
		HttpServletRequest httpServletRequest=(HttpServletRequest) pageContext.getRequest();
		HttpServletResponse httpServletResponse=(HttpServletResponse) pageContext.getResponse();
		//1.referer
		String referer=httpServletRequest.getHeader("referer");
		if (referer==null || !referer.startsWith(site)) {
			if (page.startsWith(httpServletRequest.getContextPath())) {
				httpServletResponse.sendRedirect(page);
				return;
			}else if (page.startsWith("/")) {
				httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+page);
			}else{
				httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/"+page);
			}
			throw new SkipPageException();
		}
	}
	

}
