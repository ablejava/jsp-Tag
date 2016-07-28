package com.able.simpleTag;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class foreach extends SimpleTagSupport {

	private Object item;
	
	private String var;
	
	
	@Override
	public void doTag() throws JspException, IOException {
		
		List list=(List) item;
		Iterator it=list.iterator();
		while (it.hasNext()) {
			Object value=it.next();
			this.getJspContext().setAttribute(var, value);
			this.getJspBody().invoke(null);
		}
	}
	
	public void setItem(Object item) {
		this.item = item;
	}
	public void setVar(String var) {
		this.var = var;
	}
}
