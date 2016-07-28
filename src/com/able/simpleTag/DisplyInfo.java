package com.able.simpleTag;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class DisplyInfo extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = simpleDateFormat.format(new Date());
		getJspContext().getOut().write(date);
	}
	
}
