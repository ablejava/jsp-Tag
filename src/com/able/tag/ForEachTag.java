package com.able.tag;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class ForEachTag extends TagSupport {
	
	private String var;
	
	private Iterator<?> iterator;

	public void setItem(Object item) {
		if (item instanceof Map) {
			Map items = (Map) item;
			this.iterator = items.entrySet().iterator();
		} else {
			Collection<?> c = (Collection) item;
			this.iterator = c.iterator();
		}
	}
	
	@Override
	public int doStartTag() throws JspException {
		if (this.process())
			return EVAL_BODY_INCLUDE;
		else
			return EVAL_PAGE;
		
	}

	@Override
	public int doAfterBody() throws JspException {
		if (this.process()) {
			return EVAL_BODY_AGAIN;
		} else {
			return EVAL_PAGE;
		}
	}


	private boolean process() {

		if (null != iterator && iterator.hasNext()) {
			Object item = iterator.next();
			pageContext.setAttribute(var, item);
			return true;
		} else {
			return false;
		}
	}
	
	public String getVar() {
		return var;
	}
	
	public void setVar(String var) {
		this.var = var;
	}
}
