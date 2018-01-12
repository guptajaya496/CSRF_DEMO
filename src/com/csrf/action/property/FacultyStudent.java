package com.csrf.action.property;

public class FacultyStudent 
{
	String strStudentId;
	String strFacultyId;
	
	public String getFacultyId()
	{
		return strFacultyId;
	}
	
	public void setFacultyId(String _facultyId)
	{
		this.strFacultyId = _facultyId;
	}
	
	public String getStudentId()
	{
		return strStudentId;
	}
	
	public void setStudentId(String _studentId)
	{
		this.strStudentId = _studentId;
	}	
	
}