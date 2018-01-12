package com.csrf.action.model;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import com.csrf.action.property.FacultyNameId;
import com.csrf.action.property.StudentDetails;
import com.csrf.action.property.SubjectNameId;

public class GradesBusinessObject 
{
	String strStudentFound;
	private static final String STATUS_SUCCESS  = "Success";
	private static final String STATUS_FALIURE  = "Faliure";
	//private static final String STATUS_EXIST  = "Exist";
	
	GradesDataAccessObject clsGDAO = new GradesDataAccessObject();
	
	
	
	public String generateStudentId()
	{
		String studentId = null;
		
		try
		{
			studentId = clsGDAO.generateStudentId();
		}
		catch(Exception ex)
		{
			throw ex;
		}
		
		return studentId;
	}
	
	public String getFacultyId(String facultyName)
	{
		try
		{
			HashMap<String, FacultyNameId> facultyNameIdList = clsGDAO.getFacultyNameId();
			String strfacultyId = null;
			
			if(facultyNameIdList != null)
			{
			
				FacultyNameId faculty = (FacultyNameId) facultyNameIdList.get(facultyName);		
				strfacultyId = faculty.getFacultyId();							
			}
			else
			{
				strfacultyId = "Faculty Id no found. Please again later!!!";
				
			}
			return strfacultyId;
		}
		catch(Exception ex)
		{
			throw ex;
		}
	}
		
	public HashMap<String, FacultyNameId> getFacultyList()
	{
		try
		{
			return clsGDAO.getFacultyNameId();
		}
		catch(Exception ex)
		{
			throw ex;
		}
	}
	
	public String getNewFacultyId(String facultyName, String facultyDOB)
	{
		try
		{
			String tempName = facultyName.substring(0, 1).toUpperCase();
			
			int x = (int)(Math.random() * 9);
			x = x + 1;
			String randomPIN = (x + "") + ( ((int)(Math.random()*1000)) + "" );
			String strFacultyId = tempName.concat(randomPIN);
			//return studentId;
			
			//String[] tempdob = facultyDOB.split("/");
			//String strFacultyId = tempName.concat(tempdob[0]).concat(tempdob[1]);
			
			return strFacultyId;
		}
		catch(Exception ex)
		{
			throw ex;
		}
	}
	
	@SuppressWarnings("rawtypes")
	public boolean ValidateStudentId(String _strFacultyId ,String _strStudentId)
	{
		try
		{
			boolean isStudentExist = false;
		
			HashMap<String, HashMap<String, StudentDetails>> hmFacultyStudent = new HashMap<String, HashMap<String, StudentDetails>>();
			hmFacultyStudent = clsGDAO.getHmFacultyStudent(_strFacultyId);
			
			HashMap<String, StudentDetails> hmExistingStudents = new HashMap<String, StudentDetails>();
			hmExistingStudents = hmFacultyStudent.get(_strFacultyId);
			  
			if(hmExistingStudents != null)
			{					
				Set keys = hmExistingStudents.keySet();
				Iterator it = keys.iterator();
				while(it.hasNext())
				{
					String stuId = (String) it.next();
					if(_strStudentId.equals(stuId))
					{
						isStudentExist = true;
					}
				}				
			} 			
			return isStudentExist;
		}
		catch(Exception ex)
		{
			throw ex;
		}
	}	
	
	public StudentDetails getStudentDetails(String _strStudentId)
	{
		try
		{
			HashMap<String, StudentDetails> hmIndividualStudentDetails = new HashMap<String, StudentDetails>();
			hmIndividualStudentDetails = clsGDAO.getHmStudentDetails();
			StudentDetails studentDetails = new StudentDetails();
			
			if(hmIndividualStudentDetails != null)
			{
				studentDetails = hmIndividualStudentDetails.get(_strStudentId);			 
			}
			return studentDetails;
		}
		catch(Exception ex)
		{
			throw ex;
		}
		
	}

	public String insertStudentDetails(String _strFacultyId, StudentDetails _studentdetails)
	{
		try
		{
			//if(!ValidateStudentId(_strFacultyId, _studentdetails.getStudentId()))
			//{
				String insertStatus = clsGDAO.insertStudentDetails(_strFacultyId, _studentdetails);
				if(insertStatus.equals(STATUS_SUCCESS))
				{
					return STATUS_SUCCESS;
				}
				else
				{
					return STATUS_FALIURE;
				}
			//}
			//else
			//{
				//return STUDENT_ALREADY_EXIST;
			//}
		}
		catch(Exception ex)
		{
			return STATUS_FALIURE;
		}		
	}
	
	public String updateStudentDetails(String _strFacultyId, StudentDetails _studentdetails)
	{
		try
		{
			String updateStatus = clsGDAO.updateStudentDetails(_strFacultyId, _studentdetails);
			
			if(updateStatus.equals(STATUS_SUCCESS))
			{
				return STATUS_SUCCESS;
			}
			else
			{
				return STATUS_FALIURE;
			}
		}
		catch(Exception ex)
		{
			return STATUS_FALIURE;
		}
	}
	
	public String deleteStudentDetails(String _strFacultyId, String _studentId)
	{
		try
		{
			String deleteStudent = clsGDAO.deleteStudentDetails(_strFacultyId, _studentId);
			
			if(deleteStudent.equals(STATUS_SUCCESS))
			{
				return STATUS_SUCCESS;
			}
			else
			{
				return STATUS_FALIURE;
			}			
		}
		catch(Exception ex)
		{
			return STATUS_FALIURE;
		}
	}
	
	public String insertFaculty(FacultyNameId faculty)
	{
		try
		{
			String insertStatus = clsGDAO.insertFaculty(faculty);
			if (insertStatus.equals(STATUS_SUCCESS))
			{
				return STATUS_SUCCESS;
			}
			else
			{
				return STATUS_FALIURE;
			}
			
		}
		catch(Exception ex)
		{
			return STATUS_FALIURE;			
		}
	}	

	@SuppressWarnings("unused")
	public void insertSubjectDetails()
	{
		try
		{
			SubjectNameId subjectDetails = new SubjectNameId();
			subjectDetails.setSubjectId("IT33");
			subjectDetails.setSubjectName("Method Engineering");			
			String insertStatus = clsGDAO.insertSubjectDetails(subjectDetails);			
		}
		catch(Exception ex)
		{
			throw ex;			
		}
	}
	
	public ArrayList<SubjectNameId> getSubjectDetails()
	{
		try
		{
			ArrayList<SubjectNameId> subjectList = new ArrayList<SubjectNameId>();
			
			subjectList = clsGDAO.getSubjectDetails();
			
			return subjectList;
		}
		catch(Exception ex)
		{
			throw ex;
		}
	}

}
