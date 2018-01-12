package com.csrf.action.property;

public class StudentDetails 
{
	String strStudentId;
	String strStudentName;
	String strSubjectId;
	String strGrade;
	String strCSRF;
	
	public String getStudentId()
	{
		return this.strStudentId;
	}
	
	public void setStudentId(String _strStudentId)
	{
		this.strStudentId = _strStudentId;		
	}
	
	public String getStudentName()
	{
		return this.strStudentName;
	}
	
	public void setStudentName(String _strStudentName)
	{
		this.strStudentName = _strStudentName;		
	}
	
	
	public String getSubjectId()
	{
		return this.strSubjectId;
	}
	
	public void setSubjectId(String _strSubjectId)
	{
		this.strSubjectId = _strSubjectId;		
	}
	
	
	public String getGrade()
	{
		return this.strGrade;
	}
	
	public void setGrade(String _strGrade)
	{
		this.strGrade = _strGrade;		
	}
	
	public String getCSRF()
	{
		return this.strCSRF;
	}
	
	public void setCSRF(String _strCSRF)
	{
		this.strCSRF = _strCSRF;		
	}
	
}
