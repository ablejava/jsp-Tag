package com.able.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class TagSupportDemo extends TagSupport {

	@Override
	public int doStartTag() throws JspException {
		try {
			pageContext.getOut().write("Hello World !");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return super.doStartTag();
	}
	

}
