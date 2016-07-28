package com.able.tag;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class SkipPageOrEvalPageTag extends TagSupport {

	@Override
	public int doEndTag() throws JspException {
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		String referer = request.getHeader("referer");
		String url = "http://"+request.getServerName();
		if (referer != null && referer.startsWith(url)) {
			return EVAL_PAGE;
		} else {
			try {
				pageContext.getOut().print("盗链");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return SKIP_PAGE;
	}
	
	

}
