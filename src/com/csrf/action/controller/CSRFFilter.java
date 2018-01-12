package com.csrf.action.controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.Date;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import com.csrf.action.model.GenerateCSRFToken;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.*;
import java.lang.String;

public class CSRFFilter implements Filter 
{
	/**
     * @see HttpServlet#HttpServlet()
     */
    public CSRFFilter() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init(FilterConfig filterConfig) throws ServletException 
    {
		// TODO Auto-generated method stub		
	}

    public void destroy()
    {
		// TODO Auto-generated method stub		
	}

	@SuppressWarnings("deprecation")
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)  throws IOException, ServletException 
	{
	 	String ipAddress = request.getRemoteAddr();
	    
	 	System.out.println("start===============================================================");
	    System.out.println("IP "+ ipAddress + ", Time " + new Date().toString());
	    System.out.println("Again I am here in Intercepter !!!" );
	    System.out.println("token >> "+((((HttpServletRequest) request).getRequestURL()).toString()));
	    
	    if(
	    		(((((HttpServletRequest) request).getRequestURL()).toString()).indexOf("welcome")) > 0 ||
	    		(((((HttpServletRequest) request).getRequestURL()).toString()).indexOf("CSRF_POC/css/")) > 0 ||
	    		(((((HttpServletRequest) request).getRequestURL()).toString()).indexOf("CSRF_POC/Images")) > 0 ||
	    		(((((HttpServletRequest) request).getRequestURL()).toString()).indexOf("CSRF_POC/js")) > 0 ||
	    		(((((HttpServletRequest) request).getRequestURL()).toString()).indexOf("CSRF_POC")) > 0	    		
	      )
	    {
	    	try
			{
					GenerateCSRFToken.setToken(((HttpServletRequest) request).getSession());					
			}
			catch (NoSuchAlgorithmException | NoSuchProviderException e)
			{
					// TODO Auto-generated catch block
					e.printStackTrace();
			}
	    
	    	chain.doFilter(request, response);
	    }
	    else
	    {
	    	System.out.println("in else >>> ");
	    	
	    	String token = (String) ((HttpServletRequest) request).getSession().getAttribute("CSRF_Token");
	    	String guard = (String) request.getParameter("CSRFToken");
	    	
	    	System.out.println("token	>>"+ token );
		    System.out.println("guard	>>"+ guard );
		    
		    if(token != null && guard != null && token.equals(guard))
		    {	
		    	System.out.println("got the match");
		    	
		    	((HttpServletRequest) request).getSession().removeValue("CSRF_Token");
			    try
				{
						GenerateCSRFToken.setToken(((HttpServletRequest) request).getSession());					
				}
				catch (NoSuchAlgorithmException | NoSuchProviderException e)
				{
						// TODO Auto-generated catch block
						e.printStackTrace();
				}			
			    chain.doFilter(request,response);	
		    	
			}
		    else
			{
				System.out.println("mujhe nahi mila");
		    }
		    
	    }
	    System.out.println("End===============================================================");
	}	
}

	

