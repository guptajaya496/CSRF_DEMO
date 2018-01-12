package com.csrf.action.controller;

import java.io.IOException;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.csrf.action.property.FacultyNameId;
import com.csrf.action.model.GradesBusinessObject;


/**
 * Servlet implementation class BaseAction
 * @param <FacultyNameId>
 */

public class BaseAction extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		GradesBusinessObject clsGBO = new GradesBusinessObject();
		HashMap<String, FacultyNameId> hmFacultyList = new HashMap<String, FacultyNameId>();
		String facultyName = "";
		String facultyPassword = "";
		
		try
		{
			String isCreateFaculty = request.getParameter("createFaculty");
			
			if(isCreateFaculty != null && isCreateFaculty.equals("true"))
			{
				System.out.println("create faculty is true!!");
				request.getRequestDispatcher("InsertFaculty.jsp").forward(request, response);
			}	
			else
			{
			
				String us = request.getParameter("txtUname");
				String pwd = request.getParameter("txtPwd");
					
				hmFacultyList = clsGBO.getFacultyList();
				if(hmFacultyList != null)
				{
					FacultyNameId loginFaculty = new FacultyNameId();
					loginFaculty = hmFacultyList.get(us);
						
					if(loginFaculty != null)
					{
						facultyName = loginFaculty.getFacultyName();
						facultyPassword = loginFaculty.getFacultyPassword();
						
					}				
				}			
					
				if ((us != null && pwd != null && us.equals(facultyName) && pwd.equals(facultyPassword)))
				{
					request.setAttribute("Uname", us);
					request.getSession().setAttribute("Uname", facultyName);
						
					System.out.println("view all students is true!!");
					request.setAttribute("ctrlAction", "list");
					request.getRequestDispatcher("cRUDController").forward(request, response);
				}	
				else
				{	
					request.setAttribute("customMessage", "The login User Id or Password didn't match. Please try again!!");
					request.getRequestDispatcher("WelcomePage.jsp").forward(request, response);
					
				}
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			request.setAttribute("customMessage", "An Error occurred. Please try again!!");
		}
	}		
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		doGet(request, response);		
	}
}
