package com.csrf.action.property;

public class StudentSubject
{
	String studentId;
	String subjectId;
	String subjectName;
	String grade;
	
	public String getStudentId()
	{
		return this.studentId;
	}
	
	public void setStudentId(String strStudentId)
	{
		this.studentId = strStudentId;		
	}
	
	public String getSubjectId()
	{
		return this.subjectId;
	}
	
	public void setSubjectId(String strSubjectId)
	{
		this.subjectId = strSubjectId;		
	}
	
	public String getSubjectName()
	{
		return this.subjectName;
	}
	
	public void setSubjectName(String strSubjectName)
	{
		this.subjectName = strSubjectName;		
	}
	
	public String getGrade()
	{
		return this.grade;
	}
	
	public void setGrade(String strGrade)
	{
		this.grade = strGrade;		
	}
}
