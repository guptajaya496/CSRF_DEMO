package com.csrf.action.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.csrf.action.property.FacultyNameId;
import com.csrf.action.property.FacultyStudent;
import com.csrf.action.property.StudentDetails;
import com.csrf.action.property.SubjectNameId;


public class CSVFileWriter 
{
	//Delimiter used in CSV file
	private static final String COMMA_DELIMITER = ",";
	private static final String NEW_LINE_SEPARATOR = "\n";
	//CSV file header
	private static final String STUDENT_FILE_HEADER = "StudentId,StudentName,SubjectId, Grade";
	private static final String FACULTY_FILE_HEADER = "FacultyId,FacultyName,FacultyDOB,FacultyPassword";
	private static final String FACULTY_STUDENT_FILE_HEADER = "FacultyId,StudentId";
	private static final String SUBJECT_FILE_HEADER = "SubjectId,SubjectName";
	
	public void writeStudentCsvFile(String fileName, StudentDetails student )
	{
		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;
		
		try 
		{
			if(student != null)
			{
				File file = new File(fileName);
				
				if(file.exists())
				{
					StringBuilder fileString = new StringBuilder();
					fileWriter = new FileWriter(file, true);
					bufferedWriter = new BufferedWriter(fileWriter);
					
					fileString.append(String.valueOf(student.getStudentId()));
					fileString.append(String.valueOf(COMMA_DELIMITER));
					
					fileString.append(String.valueOf(student.getStudentName()));
					fileString.append(String.valueOf(COMMA_DELIMITER));
					
					fileString.append(String.valueOf(student.getSubjectId()));
					fileString.append(String.valueOf(COMMA_DELIMITER));
					
					fileString.append(String.valueOf(student.getGrade()));
					fileString.append(String.valueOf(NEW_LINE_SEPARATOR));
					
					bufferedWriter.write(fileString.toString());
					bufferedWriter.flush();
					bufferedWriter.close();
										
				}
				else
				{
					StringBuilder fileString = new StringBuilder();
					fileWriter = new FileWriter(fileName, true);
					bufferedWriter = new BufferedWriter(fileWriter);
					
									
					fileString.append(STUDENT_FILE_HEADER.toString());
					fileString.append(NEW_LINE_SEPARATOR);
					
					fileString.append(String.valueOf(student.getStudentId()));
					fileString.append(String.valueOf(COMMA_DELIMITER));
					
					fileString.append(String.valueOf(student.getStudentName()));
					fileString.append(String.valueOf(COMMA_DELIMITER));
					
					fileString.append(String.valueOf(student.getSubjectId()));
					fileString.append(String.valueOf(COMMA_DELIMITER));
					
					fileString.append(String.valueOf(student.getGrade()));
					fileString.append(String.valueOf(NEW_LINE_SEPARATOR));

					bufferedWriter.write(fileString.toString());
					bufferedWriter.flush();
					bufferedWriter.close();
					
				}
				
			}
		}
		catch (Exception e)
		{	
			System.out.println("Error in Student CsvFileWriter !!!");
		    e.printStackTrace();
		}
		finally
		{
			try
			{
				fileWriter.close();
		    } 
			catch (IOException e)
			{
				System.out.println("Error while flushing/closing Student fileWriter !!!");
				e.printStackTrace();
		    }
		}
	}
	
	public void writeFacultyCsvFile(String fileName, FacultyNameId faculty )
	{
		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;
		System.out.println(fileName);
		
		try 
		{
			File file = new File(fileName);
			if(file.exists())
			{
				StringBuilder fileString = new StringBuilder();
				fileWriter = new FileWriter(file,true);
				bufferedWriter = new BufferedWriter(fileWriter);
				
				fileString.append(faculty.getFacultyId());
				fileString.append(COMMA_DELIMITER);
	
				fileString.append(faculty.getFacultyName());
				fileString.append(COMMA_DELIMITER);
				
				fileString.append(faculty.getFacultyDOB());
				fileString.append(COMMA_DELIMITER);
				
				fileString.append(faculty.getFacultyPassword());
				
				fileString.append(NEW_LINE_SEPARATOR);
							
				bufferedWriter.write(fileString.toString());
				bufferedWriter.flush();
				bufferedWriter.close();
				
			}
			else
			{
				StringBuilder fileString = new StringBuilder();
				fileWriter = new FileWriter(fileName,true);
				bufferedWriter = new BufferedWriter(fileWriter);
				
				fileString.append(FACULTY_FILE_HEADER.toString());
				fileString.append(NEW_LINE_SEPARATOR);
				
				fileString.append(faculty.getFacultyId());
				fileString.append(COMMA_DELIMITER);
				
				fileString.append(faculty.getFacultyName());
				fileString.append(COMMA_DELIMITER);
				
				fileString.append(faculty.getFacultyDOB());
				fileString.append(COMMA_DELIMITER);
				
				fileString.append(faculty.getFacultyPassword());
				
				fileString.append(NEW_LINE_SEPARATOR);
							
				bufferedWriter.write(fileString.toString());
				bufferedWriter.flush();
				bufferedWriter.close();
								
			}			
		}
		catch (Exception e)
		{	
			System.out.println("Error in Faculty CsvFileWriter !!!");
		    e.printStackTrace();
		}
		finally
		{
			try
			{				
				fileWriter.close();				
								
		    } 
			catch (IOException e)
			{
				System.out.println("Error while flushing/closing Faculty fileWriter !!!");
				e.printStackTrace();
		    }
		}
	}
	
	public void writeFacultyStudentCsvFile(String fileName, FacultyStudent facultystudentAssociation )
	{
		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;
		
		try 
		{
			File file = new File(fileName);
			if(file.exists())
			{
				StringBuilder fileString = new StringBuilder();
				fileWriter = new FileWriter(file,true);
				bufferedWriter = new BufferedWriter(fileWriter);
				
				fileString.append(facultystudentAssociation.getFacultyId());
				fileString.append(COMMA_DELIMITER);
				
				fileString.append(facultystudentAssociation.getStudentId());
				
				fileString.append(NEW_LINE_SEPARATOR);
			
				bufferedWriter.write(fileString.toString());
				bufferedWriter.flush();
				bufferedWriter.close();
				
			}
			else
			{
				
				StringBuilder fileString = new StringBuilder();
				fileWriter = new FileWriter(fileName,true);
				bufferedWriter = new BufferedWriter(fileWriter);
				
				fileString.append(FACULTY_STUDENT_FILE_HEADER.toString());
				fileString.append(NEW_LINE_SEPARATOR);
				
				fileString.append(facultystudentAssociation.getFacultyId());
				fileString.append(COMMA_DELIMITER);
				
				fileString.append(facultystudentAssociation.getStudentId());
				fileString.append(NEW_LINE_SEPARATOR);
							
				bufferedWriter.write(fileString.toString());
				bufferedWriter.flush();
				bufferedWriter.close();
								
			}			
		}
		catch (Exception e)
		{	
			System.out.println("Error in FacultyStudent CsvFileWriter !!!");
		    e.printStackTrace();
		}
		finally
		{
			try
			{
				fileWriter.close();
								
		    } 
			catch (IOException e)
			{
				System.out.println("Error while flushing/closing FacultyStudent fileWriter !!!");
				e.printStackTrace();
		    }
		}
	}
	
	public void writeSubjectDetailsCsvFile(String fileName, SubjectNameId subject)
	{

		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;
		
		try 
		{
			File file = new File(fileName);
			if(file.exists())
			{
				StringBuilder fileString = new StringBuilder();
				fileWriter = new FileWriter(file,true);
				bufferedWriter = new BufferedWriter(fileWriter);
				
				fileString.append(subject.getSubjectId());
				fileString.append(COMMA_DELIMITER);
				
				fileString.append(subject.getSubjectName());
				
				fileString.append(NEW_LINE_SEPARATOR);
							
				bufferedWriter.write(fileString.toString());
				bufferedWriter.flush();
				bufferedWriter.close();
				
			}
			else
			{
				StringBuilder fileString = new StringBuilder();
				fileWriter = new FileWriter(fileName,true);
				bufferedWriter = new BufferedWriter(fileWriter);
				
				fileString.append(SUBJECT_FILE_HEADER.toString());
				fileString.append(NEW_LINE_SEPARATOR);
				
				fileString.append(subject.getSubjectId());
				fileString.append(COMMA_DELIMITER);
				
				fileString.append(subject.getSubjectName());
				fileString.append(NEW_LINE_SEPARATOR);
							
				bufferedWriter.write(fileString.toString());
				bufferedWriter.flush();
				bufferedWriter.close();
								
			}			
		}
		catch (Exception e)
		{	
			System.out.println("Error in FacultyStudent CsvFileWriter !!!");
		    e.printStackTrace();
		}
		finally
		{
			try
			{
				fileWriter.close();
								
		    } 
			catch (IOException e)
			{
				System.out.println("Error while flushing/closing FacultyStudent fileWriter !!!");
				e.printStackTrace();
		    }
		}
	
	}
}

