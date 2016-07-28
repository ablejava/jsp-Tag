package com.able.simpleTag.choose;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;


public class OtherWise extends SimpleTagSupport{
	
	@Override
	public void doTag() throws JspException, IOException {
		Choose parChooseTag=(Choose) this.getParent();
		if (!parChooseTag.isDo()) {
			this.getJspBody().invoke(null);
			parChooseTag.setDo(true);
		}
	}

}
