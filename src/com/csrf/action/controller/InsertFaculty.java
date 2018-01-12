package com.csrf.action.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.csrf.action.model.GradesBusinessObject;
import com.csrf.action.property.FacultyNameId;

public class InsertFaculty extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
      
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{		
			
		GradesBusinessObject clsGBO = new GradesBusinessObject();
		FacultyNameId clsFacultyNameId = new FacultyNameId();
		
		String strFacultyName = request.getParameter("txtFacultyName");
		clsFacultyNameId.setFacultyName(strFacultyName);
		
		String strFacultyDoB = request.getParameter("txtFacultyDOB");
		clsFacultyNameId.setFacultyDOB(strFacultyDoB);
		
		clsFacultyNameId.setFacultyPassword(request.getParameter("txtFacultyPassword"));
		
		String strFacultyId = clsGBO.getNewFacultyId(strFacultyName, strFacultyDoB);
		clsFacultyNameId.setFacultyId(strFacultyId);
		
		String strGetStatus = clsGBO.insertFaculty(clsFacultyNameId);
		
		if(strGetStatus.equals("Success"))
		{	
			System.out.println("Check insert faculty >> " + strFacultyName);
			request.setAttribute("customMessage", "Faculty Signup is successfully done!!  Please Login again to access your account.");
			request.getRequestDispatcher("WelcomePage.jsp").forward(request, response);
		}			
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
