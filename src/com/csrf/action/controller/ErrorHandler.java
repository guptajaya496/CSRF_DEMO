package com.csrf.action.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ErrorHandler extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ErrorHandler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
       
	      Throwable throwable = (Throwable)request.getAttribute("javax.servlet.error.exception");
	      Integer statusCode = (Integer)request.getAttribute("javax.servlet.error.status_code");
	      String servletName = (String)request.getAttribute("javax.servlet.error.servlet_name");
	      if (servletName == null)
	      {
	         servletName = "Unknown";
	      }
	      String requestUri = (String) request.getAttribute("javax.servlet.error.request_uri");
	      if (requestUri == null)
	      {
	         requestUri = "Unknown";
	      }

	      // Set response content type
	      response.setContentType("text/html");
	      request.setAttribute("ErrorStatusCode", statusCode);
	      request.setAttribute("ServletName", servletName);
	      request.setAttribute("RequestUri", requestUri);
	      request.setAttribute("Exception", throwable);
	      request.getRequestDispatcher("/ErrorPage.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
