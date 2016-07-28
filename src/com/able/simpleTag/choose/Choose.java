package com.able.simpleTag.choose;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Choose extends SimpleTagSupport {
	private boolean isDo;

	public boolean isDo() {//get
		return isDo;
	}

	public void setDo(boolean isDo) {//set
		this.isDo = isDo;
	}

	@Override
	public void doTag() throws JspException, IOException {
		this.getJspBody().invoke(null);
	}
}
