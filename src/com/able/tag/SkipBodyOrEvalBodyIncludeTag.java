package com.able.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class SkipBodyOrEvalBodyIncludeTag extends TagSupport {

	@Override
	public int doStartTag() throws JspException {
		String name = pageContext.getRequest().getParameter("name");
		if (name != null && name.equals("xiazhongwei")) {
			return EVAL_BODY_INCLUDE;
		} else {
			return SKIP_BODY;
		}
	}
	

}
