package com.able.simpleTag;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
//控制标签余下的jsp内容不输出
public class SimpleTagDemo4 extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		throw new SkipPageException();
		
	}

	
}
