package com.csrf.action.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.csrf.action.property.FacultyNameId;
import com.csrf.action.property.FacultyStudent;
import com.csrf.action.property.StudentDetails;
import com.csrf.action.property.SubjectNameId;

public class CSVFileReader
{
	//Delimiter used in CSV file
	private static final String COMMA_DELIMITER = ",";
		
	//Student attributes index	
	private static final int STUDENT_ID_IDX = 0;
	private static final int STUDENT_NAME_IDX = 1;
	private static final int STUDENT_SUBJECT_IDX = 2;
	private static final int STUDENT_GRADE_IDX = 3;
	
	//Faculty Student Association  attributes index	
	private static final int ASSOCIATION_FACULTY_ID_IDX = 0;
	private static final int ASSOCIATION_STUDENT_ID_IDX = 1;
	
	//Faculty attributes index
	private static final int FACULTY_ID_IDX = 0;
	private static final int FACULTY_NAME_IDX = 1;
	private static final int FACULTY_DOB_IDX = 2;
	private static final int FACULTY_PASSWORD_IDX = 3;	
	
	//Subject attributes index
	private static final int SUBJECT_ID_IDX = 0;
	private static final int SUBJECT_NAME_IDX = 1;
	
	public ArrayList<FacultyStudent> readFacultyStudentCsvFile(String fileName)
	{
	
		BufferedReader fileReader = null;
		ArrayList<FacultyStudent> facultyStudentList = new ArrayList<FacultyStudent>();
		
		try
		{
			File file = new File(fileName);
			if(file.exists())
			{	
				String line = "";
				FacultyStudent facultyStudent = new FacultyStudent();
				
				fileReader = new BufferedReader(new FileReader(fileName));
				
				if(fileReader != null)
				{
					fileReader.readLine();
					
					while ((line = fileReader.readLine()) != null)
					{						
						String[] tokens = line.split(COMMA_DELIMITER);
										
						facultyStudent = new FacultyStudent();
							
						facultyStudent.setFacultyId(tokens[ASSOCIATION_FACULTY_ID_IDX]);
						facultyStudent.setStudentId(tokens[ASSOCIATION_STUDENT_ID_IDX]);	
							
						facultyStudentList.add(facultyStudent);
					}
					
					fileReader.close();
				}
			}
			
		}
		catch (Exception e) 
		{
			System.out.println("Error in FacultyStudent CsvFileReader !!!");
	        e.printStackTrace();
	    } 
		finally
		{
			try 
			{
				fileReader.close();
			} 
			catch (IOException e)
			{
				System.out.println("Error while closing FacultyStudent CsvFileReader !!!");
				e.printStackTrace();
			}
	    }
		return facultyStudentList;
	}
	
	public HashMap<String, FacultyNameId> readFacultyCsvFile(String fileName)
	{
		BufferedReader fileReader = null;
		HashMap<String, FacultyNameId> hmFacultyNameId = new HashMap<String, FacultyNameId>();
		
		try
		{
			File file = new File(fileName);
			if(file.exists())
			{
			
				//Create a new list of student to be filled by CSV file data
				String line = "";
				
				//Create the file reader
				fileReader = new BufferedReader(new FileReader(fileName));
				
				if(fileReader != null)
				{
					//Read the CSV file header to skip it
					fileReader.readLine();
					
					//Read the file line by line starting from the second line
					while ((line = fileReader.readLine()) != null)
					{
						String[] tokens = line.split(COMMA_DELIMITER);
						
						if (tokens.length > 0) 
						{
							//Create a new student object and fill his  data
							FacultyNameId faculty = new FacultyNameId();
							faculty.setFacultyId(tokens[FACULTY_ID_IDX]);	
							faculty.setFacultyName(tokens[FACULTY_NAME_IDX]);
							faculty.setFacultyDOB(tokens[FACULTY_DOB_IDX]);
							faculty.setFacultyPassword(tokens[FACULTY_PASSWORD_IDX]);
							
							hmFacultyNameId.put(faculty.getFacultyName(), faculty);					
						}
					}
				}
				fileReader.close();
			}
		}
		catch (Exception e) 
		{
			System.out.println("Error in Faculty CsvFileReader !!!");
	        e.printStackTrace();
	    } 
		finally
		{
			try 
			{
				fileReader.close();
			} 
			catch (IOException e)
			{
				System.out.println("Error while closing Faculty fileReader !!!");
				e.printStackTrace();
			}
	    }
		return hmFacultyNameId;
	}
		
	public HashMap<String, StudentDetails> readStudentCsvFile(String fileName)
	{
		BufferedReader fileReader = null;
		HashMap<String, StudentDetails> hmStudentList = new HashMap<String, StudentDetails>();
		
		try
		{
			File file = new File(fileName);
			if(file.exists())
			{
					
				//Create a new list of student to be filled by CSV file data
				String line = "";
			
				//Create the file reader
				fileReader = new BufferedReader(new FileReader(fileName));
			
				if(fileReader != null)
				{
					//Read the CSV file header to skip it
					fileReader.readLine();
				
					//Read the file line by line starting from the second line
					while ((line = fileReader.readLine()) != null)
					{
						//Get all tokens available in line
						String[] tokens = line.split(COMMA_DELIMITER);
					
						if (tokens.length > 0) 
						{
							//Create a new student object and fill his  data
							StudentDetails student = new StudentDetails();
							student.setStudentId(tokens[STUDENT_ID_IDX]);
							student.setStudentName(tokens[STUDENT_NAME_IDX]);
							student.setSubjectId(tokens[STUDENT_SUBJECT_IDX]);
							student.setGrade(tokens[STUDENT_GRADE_IDX]);
							
							hmStudentList.put(student.getStudentId(), student);					
						}
					}	
					fileReader.close();
				}
			}	
		}
		catch (Exception e) 
		{
			System.out.println("Error in Student CsvFileReader !!!");
	        e.printStackTrace();
	    } 
		finally
		{
			try 
			{
				fileReader.close();
			} 
			catch (IOException e)
			{
				System.out.println("Error while closing Student fileReader !!!");
				e.printStackTrace();
			}
	    }
		return hmStudentList;
	}

	public ArrayList<SubjectNameId> readSubjectDetailsCsvFile(String fileName)
	{

		
		BufferedReader fileReader = null;
		ArrayList<SubjectNameId> subjectList = new ArrayList<SubjectNameId>();
		
		try
		{
			File file = new File(fileName);
			if(file.exists())
			{	
				String line = "";
				SubjectNameId subject = new SubjectNameId();
				
				fileReader = new BufferedReader(new FileReader(fileName));
				
				if(fileReader != null)
				{
					fileReader.readLine();
					
					while ((line = fileReader.readLine()) != null)
					{						
						String[] tokens = line.split(COMMA_DELIMITER);
										
						subject = new SubjectNameId();
							
						subject.setSubjectId(tokens[SUBJECT_ID_IDX]);
						subject.setSubjectName(tokens[SUBJECT_NAME_IDX]);	
							
						subjectList.add(subject);
					}
					
					fileReader.close();
				}
			}
			
		}
		catch (Exception e) 
		{
			System.out.println("Error in SubjectDetails CsvFileReader !!!");
	        e.printStackTrace();
	    } 
		finally
		{
			try 
			{
				fileReader.close();
			} 
			catch (IOException e)
			{
				System.out.println("Error while closing SubjectDetails CsvFileReader !!!");
				e.printStackTrace();
			}
	    }
		return subjectList;
	}
}
