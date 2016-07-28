package com.able.bodyTag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class BodyTagSupportTag extends BodyTagSupport {
	private BodyContent bodyContent;
	

	@Override
	public int doEndTag() throws JspException {
		String content = bodyContent.getString();
		System.out.println(content);
		
		String newStr = "www.cnblogs.com/izhongwei";
		JspWriter jspWriter= bodyContent.getEnclosingWriter();
		try {
			jspWriter.write(newStr);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}

	public BodyContent getBodyContent() {
		return bodyContent;
	}

	public void setBodyContent(BodyContent bodyContent) {
		this.bodyContent = bodyContent;
	}
	
	

}
