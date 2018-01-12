package com.csrf.action.controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.csrf.action.model.GradesBusinessObject;
import com.csrf.action.model.GradesDataAccessObject;
import com.csrf.action.property.StudentDetails;
import com.csrf.action.property.SubjectNameId;

/**
 * Servlet implementation class CRUDController
 */

public class CRUDController extends HttpServlet
{
	private static final long serialVersionUID = 1L;
    
	GradesDataAccessObject clsGDAO = new GradesDataAccessObject();
	GradesBusinessObject clsGBO = new GradesBusinessObject();
	
	private static final String STATUS_SUCCESS  = "Success";
	private static final String STATUS_EXIST  = "Exist";
	private static final String ACTION_LIST  = "list";
	private static final String ACTION_CREATE  = "create";
	private static final String ACTION_UPDATE  = "update";
	private static final String ACTION_DELETE  = "delete";
	private static final String CUSTOM_MESSAGE  = "customMessage";
	private static final String MESSAGE_ERROR  = "Error occured!!";
	private static final String MESSAGE_INSERT_SUCCESS  = "Student Details Inserted Successfully!!";
	private static final String MESSAGE_DELETE_SUCCESS  = "Student Details Deleted Successfully!!";
	private static final String MESSAGE_UPDATE_SUCCESS  = "Student Details Updated Successfully!!";	
	private static final String MESSAGE_INSERT_FALIURE  = "Student Details Not Inserted!!";
	private static final String MESSAGE_DELETE_FALIURE  = "Student Details Not Deleted!!";
	private static final String MESSAGE_UPDATE_FALIURE  = "Student Details Not Updated!!";
	private static final String MESSAGE_EXIST  = "Student with this Id already exist. Please choose another Id!!";
	
    public CRUDController()
    {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		try
		{
			String facultyId = null;
			String strAction = null;
			
			String facultyName =(String) request.getSession().getAttribute("Uname");			
			
			facultyId = clsGBO.getFacultyId(facultyName);
			
			if(request.getParameter("ctrlAction")!= null)
			{
				strAction = request.getParameter("ctrlAction") ;				
			}
			else if(request.getAttribute("ctrlAction")!= null)
			{
				strAction = (String)request.getAttribute("ctrlAction");				
			}
			
			if(strAction != null && strAction.equals(ACTION_LIST))
			{
				System.out.println("i am in CRUD controller and action is list!!!");
				ArrayList<StudentDetails> listStudent = new ArrayList<StudentDetails>();
				ArrayList<SubjectNameId> subjectList = new ArrayList<SubjectNameId>();
				
				listStudent = clsGDAO.getFacultyStudentList(facultyId);
				subjectList = clsGBO.getSubjectDetails();
				
				if(listStudent != null && subjectList != null)
				{
					
					request.setAttribute("listStudent", listStudent);
					request.setAttribute("subjectList", subjectList);
				}
				else
				{
					request.setAttribute(CUSTOM_MESSAGE, MESSAGE_ERROR);
				}				
			}				
			else if (strAction != null && strAction.equals(ACTION_DELETE))
			{
				System.out.println("action is delete >>>" );
				
				if(request.getParameter("strStudentId") != null)
				{
					String strStudentId = request.getParameter("strStudentId");
				
					String deleteStatus = clsGBO.deleteStudentDetails(facultyId, strStudentId);
					
					if(deleteStatus.equals(STATUS_SUCCESS))
					{
						request.setAttribute(CUSTOM_MESSAGE, MESSAGE_DELETE_SUCCESS);
					}
					else
					{
						request.setAttribute(CUSTOM_MESSAGE, MESSAGE_DELETE_FALIURE);
					}
				}
			}
			else if (strAction!=null && (strAction.equals(ACTION_CREATE)))
			{
				
				StudentDetails student = new StudentDetails();
				String studentId = clsGBO.generateStudentId();
				
				if(studentId != null)
				{
					student.setStudentId(studentId);
				}
				
				if (request.getParameter("strStudentName") != null) 
				{
					student.setStudentName(request.getParameter("strStudentName"));
				}
				
				if (request.getParameter("strSubjectId") != null) 
				{
					student.setSubjectId(request.getParameter("strSubjectId"));
				}
	
				if (request.getParameter("strGrade") != null)
				{
					student.setGrade( request.getParameter("strGrade"));
				}
				
				System.out.println("action is create!!!");
				
				String insertStatus = clsGBO.insertStudentDetails(facultyId, student);
				if(insertStatus.equals(STATUS_SUCCESS))
				{
					request.setAttribute(CUSTOM_MESSAGE, MESSAGE_INSERT_SUCCESS);
					
				}
				else if(insertStatus.equals(STATUS_EXIST))
				{
					request.setAttribute(CUSTOM_MESSAGE, MESSAGE_EXIST);
				}
				else
				{
					request.setAttribute(CUSTOM_MESSAGE, MESSAGE_INSERT_FALIURE);
				}
				
				
			}
			else if(strAction!=null && strAction.equals(ACTION_UPDATE))
			{
				StudentDetails student = new StudentDetails();
				
				if(request.getParameter("strStudentId") != null)
				{
					student.setStudentId(request.getParameter("strStudentId"));
				}
				
				if (request.getParameter("strStudentName") != null) 
				{
					student.setStudentName(request.getParameter("strStudentName"));
				}
				
				if (request.getParameter("strSubjectId") != null) 
				{
					student.setSubjectId(request.getParameter("strSubjectId"));
				}
	
				if (request.getParameter("strGrade") != null)
				{
					student.setGrade( request.getParameter("strGrade"));
				}
				
				System.out.println("action is update >>>");
				String updateStatus = clsGBO.updateStudentDetails(facultyId,student);
				
				if(updateStatus.equals(STATUS_SUCCESS))
				{
					request.setAttribute(CUSTOM_MESSAGE, MESSAGE_UPDATE_SUCCESS);
				}
				else
				{
					request.setAttribute(CUSTOM_MESSAGE, MESSAGE_UPDATE_FALIURE);
				}
	
			}						
			
			ArrayList<StudentDetails> listStudent = new ArrayList<StudentDetails>();
			ArrayList<SubjectNameId> subjectList = new ArrayList<SubjectNameId>();
			
			listStudent = clsGDAO.getFacultyStudentList(facultyId);
			subjectList = clsGBO.getSubjectDetails();
			
			if(listStudent != null && subjectList != null)
			{
				
				request.setAttribute("listStudent", listStudent);
				request.setAttribute("subjectList", subjectList);
			}
			else
			{
				request.setAttribute(CUSTOM_MESSAGE, MESSAGE_ERROR);
			}	
			request.getRequestDispatcher("ViewAllStudents.jsp").forward(request, response);
		}
		catch(Exception ex)
		{
			throw ex;
		}
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

}
