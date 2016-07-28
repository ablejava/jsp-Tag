package com.able.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class IteratorTagDemo extends TagSupport {
	private String var;
	private String[] items;

	private int i =1;
	@Override
	public int doStartTag() throws JspException {
		if (items != null && items.length>0) {
			pageContext.setAttribute("name", items[0]);
			return EVAL_BODY_INCLUDE;
		} else {
			return SKIP_BODY;
		}
	}
	
	
	@Override
	public int doAfterBody() throws JspException {
		if (i<items.length) {
			pageContext.setAttribute("name", items[i]);
			i++;
			return EVAL_BODY_AGAIN;
		} else {
			return SKIP_BODY;
		}
	}

	@Override
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		return super.doEndTag();
	}




	public String getVar() {
		return var;
	}

	public void setVar(String var) {
		this.var = var;
	}

	public String[] getItems() {
		return items;
	}

	public void setItems(String[] items) {
		this.items = items;
	}
}
