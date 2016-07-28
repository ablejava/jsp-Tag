package com.able.simpleTag.choose;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;


public class When extends SimpleTagSupport {
	private boolean test;

	public void setTest(boolean test) {
		this.test = test;
	}

	@Override
	public void doTag() throws JspException, IOException {
		Choose chooseTag= (Choose) this.getParent();
		if (test && !chooseTag.isDo()) {
			this.getJspBody().invoke(null);
			chooseTag.setDo(true);
		}
	}
}
