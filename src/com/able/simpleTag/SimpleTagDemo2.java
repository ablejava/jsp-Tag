package com.able.simpleTag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
//循环输出
public class SimpleTagDemo2 extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		JspFragment jf= this.getJspBody();
		for(int i=0;i<5;i++){
			jf.invoke(null);
			//jf.invoke(this.getJspContext().getOut());  //这个和上面的写法一样
		}
	
	}

	
}
