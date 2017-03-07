package com.nt.tags;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;

public class ExampleTag extends TagSupport
{
	public int doStartTag()   //executes when open <start:example> tag encounters
	{
		System.out.println("Inside doStartTag() ExampleTag");
		try
		{
			JspWriter out=pageContext.getOut();
			out.print("Prime numbers"+"<br>");
		}
		catch(IOException e)
		{
			System.out.println("Error in ExampleTag: "+ e);
		}
		return (SKIP_BODY);
	}//doStartTag()
	public int doEndTag()   //Executes when closing </example> tag encounters
	{
		System.out.println("Inside doEndTag() of ExampleTag");
		return EVAL_PAGE;
	}//doEngTag()
}//class