package com.csrf.action.controller;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.io.*;

public class CSRFTokenValue extends SimpleTagSupport
{
	public void doTag() throws JspException, IOException
	{		
		String token;
			
			token = (String) getJspContext().findAttribute("CSRF_Token");
			
			if(token !=null )
			{
				JspWriter out1 = getJspContext().getOut();
				out1.println(token);
			}				
	}	
}
