package com.csrf.action.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import com.csrf.action.property.FacultyNameId;
import com.csrf.action.property.FacultyStudent;
import com.csrf.action.property.StudentDetails;
import com.csrf.action.property.SubjectNameId;

import java.io.File;

public class GradesDataAccessObject 
{
	String strFacultyId;
	String strStudentId;
	String strSubjectId;
	String strGrade;
		
	public static HashMap<String, StudentDetails> hmStudentDetails = new HashMap<String, StudentDetails>();
		
	private static final String FILE_PATH  = "C:/Users/Jaya/workspace/CSRF_DEMO/src/com/csrf/action/file";
	private static final String STUDENT_FILE_NAME  = "/StudentDetails.csv";
	private static final String FACULTY_FILE_NAME  = "/Faculty.csv";
	private static final String FACULTY_STUDENT_FILE_NAME  = "/FacultyStudentAssociation.csv";
	private static final String SUBJECT_FILE_NAME  = "/SubjectDetails.csv";
	private static final String STATUS_SUCCESS  = "Success";
	private static final String STATUS_FALIURE  = "Faliure";
	private static final String CSE_IT_CS  = "CSEITCS";
	
	
	public String generateStudentId()
	{
		int x = (int)(Math.random() * 9);
		x = x + 1;
		String randomPIN = (x + "") + ( ((int)(Math.random()*1000)) + "" );
		String studentId = CSE_IT_CS.concat(randomPIN);
		return studentId;
		
	}
	
	public ArrayList<StudentDetails> getFacultyStudentList(String facultyId) 
	{
		try
		{
			ArrayList<StudentDetails> listFacultyStudent = new ArrayList<StudentDetails>();
			CSVFileReader csvFileReader = new CSVFileReader();
			
			StringBuilder fileName = new StringBuilder();
			fileName.append(FILE_PATH).append(FACULTY_STUDENT_FILE_NAME);
			
			ArrayList<FacultyStudent> facultyStudentList = new ArrayList<FacultyStudent>();
			HashMap<String, StudentDetails> studentList = new HashMap<String, StudentDetails>();
			StudentDetails student = new StudentDetails();
			
			studentList = getHmStudentDetails();
	
			facultyStudentList = csvFileReader.readFacultyStudentCsvFile(fileName.toString());
			
			if(facultyStudentList != null)
			{
				int listSize = facultyStudentList.size();
				
				for(int i=0; i<listSize;i++)
				{
					String facId = (String) facultyStudentList.get(i).getFacultyId();
					if(facId.equals(facultyId))
					{	
						student = new StudentDetails();
						if(studentList!= null)
						{
							student = (StudentDetails) studentList.get(facultyStudentList.get(i).getStudentId());
							if(student != null)
							{	
								listFacultyStudent.add(student);
							}
							
						}						
					}					
				}				
			}			
				return listFacultyStudent;
		}
		catch(Exception ex)
		{
			throw ex;
		}
	}
	
	public HashMap<String, FacultyNameId> getFacultyNameId() 
	{
		try
		{
			HashMap<String, FacultyNameId> hmFacultyNameId = new HashMap<String, FacultyNameId>();
			CSVFileReader csvFileReader = new CSVFileReader();
			
			StringBuilder file = new StringBuilder();
			String fileName = file.append(FILE_PATH).append(FACULTY_FILE_NAME).toString();
			
			hmFacultyNameId = csvFileReader.readFacultyCsvFile(fileName);
			
			return hmFacultyNameId;
		}
		catch(Exception ex)
		{
			throw ex;
		}
	}

	public HashMap<String, StudentDetails> getHmStudentDetails()
	{
		try
		{
			CSVFileReader csvFileReader = new CSVFileReader();
			StringBuilder fileName = new StringBuilder();
			fileName.append(FILE_PATH).append(STUDENT_FILE_NAME);
			HashMap<String, StudentDetails> studentsList = new HashMap<String, StudentDetails>();
			
			studentsList = csvFileReader.readStudentCsvFile(fileName.toString());
			
			return studentsList;
		}
		catch(Exception ex)
		{
			throw ex;
		}
	}
	
	public HashMap<String, HashMap<String, StudentDetails>> getHmFacultyStudent(String facultyId) 
	{
		try
		{
			HashMap<String, HashMap<String, StudentDetails>> hmFacultyStudent = new HashMap<String, HashMap<String, StudentDetails>>();
			CSVFileReader csvFileReader = new CSVFileReader();
			
			StringBuilder fileName = new StringBuilder();
			fileName.append(FILE_PATH).append(FACULTY_STUDENT_FILE_NAME);
			
			ArrayList<FacultyStudent> facultyStudentList = new ArrayList<FacultyStudent>();
			HashMap<String, StudentDetails> studentList = new HashMap<String, StudentDetails>();
			StudentDetails student = new StudentDetails();
			
			HashMap<String, StudentDetails> individualFacultyStudentList = new HashMap<String, StudentDetails>();
			
			studentList = getHmStudentDetails();
	
			facultyStudentList = csvFileReader.readFacultyStudentCsvFile(fileName.toString());
			
			if(facultyStudentList != null)
			{
				int listSize = facultyStudentList.size();
				
				for(int i=0; i<listSize;i++)
				{
					String facId = (String) facultyStudentList.get(i).getFacultyId();
					if(facultyId.equals(facId))
					{	
						student = new StudentDetails();
						student = studentList.get(facultyStudentList.get(i).getStudentId());
							if(student != null)
							{
								individualFacultyStudentList.put(facultyStudentList.get(i).getStudentId(),student);
							}						
						}										
					}
					
				}
				
				hmFacultyStudent.put(facultyId, individualFacultyStudentList);
				return hmFacultyStudent;
		}
		catch(Exception ex)
		{
			throw ex;
		}
	}

	public String insertFaculty(FacultyNameId faculty)
	{
		try
		{
			CSVFileWriter csvfileWriter = new CSVFileWriter();
			
			StringBuilder fileName = new StringBuilder();
			String FacultyFileName = fileName.append(FILE_PATH).append(FACULTY_FILE_NAME).toString();
			
			csvfileWriter.writeFacultyCsvFile(FacultyFileName, faculty);
			
			return STATUS_SUCCESS;
		}
		catch(Exception ex)
		{
			return STATUS_FALIURE;
		}
	}

	public String insertStudentDetails(String _facultyId,StudentDetails _studentdetails)
	{
		try
		{
			CSVFileWriter csvfileWriter = new CSVFileWriter();
					
			StringBuilder fileName = new StringBuilder();
			String studentFileName = (fileName.append(FILE_PATH).append(STUDENT_FILE_NAME)).toString();
			fileName = new StringBuilder();
			String facultyStudentFileName = (fileName.append(FILE_PATH).append(FACULTY_STUDENT_FILE_NAME)).toString();
			
			if (_studentdetails != null)
			{
				FacultyStudent facultyStudent = new FacultyStudent();
				facultyStudent.setStudentId(_studentdetails.getStudentId());
				facultyStudent.setFacultyId(_facultyId);
							
				csvfileWriter.writeStudentCsvFile(studentFileName, _studentdetails);
				csvfileWriter.writeFacultyStudentCsvFile(facultyStudentFileName, facultyStudent);								
			}
			
			return STATUS_SUCCESS;
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
			CSVFileWriter csvfileWriter = new CSVFileWriter();
			CSVFileReader csvfileReader = new CSVFileReader();
			HashMap<String, StudentDetails> hmStudentList = new HashMap<String, StudentDetails>();
			
			StringBuilder fileName = new StringBuilder();
			String studentFileName = (fileName.append(FILE_PATH).append(STUDENT_FILE_NAME)).toString();
			
			hmStudentList = csvfileReader.readStudentCsvFile(studentFileName);
			
			File file = new File(studentFileName);
			file.delete();
			
			if(hmStudentList != null)
			{
				hmStudentList.remove(_studentdetails.getStudentId());
								
				hmStudentList.put(_studentdetails.getStudentId(), _studentdetails);
			
				@SuppressWarnings("rawtypes")
				Set keys = hmStudentList.keySet();
				
				for(@SuppressWarnings("rawtypes")
				Iterator i= keys.iterator(); i.hasNext();)
				{
					String key = (String) i.next();
					csvfileWriter.writeStudentCsvFile(studentFileName, hmStudentList.get(key));				
				}
			}
			return STATUS_SUCCESS;
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
			CSVFileWriter csvfileWriter = new CSVFileWriter();
			CSVFileReader csvfileReader = new CSVFileReader();
			HashMap<String, StudentDetails> hmStudentList = new HashMap<String, StudentDetails>();
			StudentDetails student ;
			StringBuilder fileName = new StringBuilder();
			String studentFileName = (fileName.append(FILE_PATH).append(STUDENT_FILE_NAME)).toString();
			
			hmStudentList = csvfileReader.readStudentCsvFile(studentFileName);
			
			File file = new File(studentFileName);
			file.delete();
			
			if(hmStudentList != null)
			{
				student = new StudentDetails();
				student = hmStudentList.get(_studentId);
				
				if(student != null)
				{
					hmStudentList.remove(_studentId);
				}			
			
			
				Set<String> keys = hmStudentList.keySet();
				
				for(@SuppressWarnings("rawtypes")
				Iterator i= keys.iterator(); i.hasNext();)
				{
					String key = (String) i.next();
					csvfileWriter.writeStudentCsvFile(studentFileName, hmStudentList.get(key));				
				}
			}
			
			String deleteAssociation = deleteFacultyStudentAssociation(_strFacultyId, _studentId);
			
			if(deleteAssociation.equals(STATUS_SUCCESS))
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
	
	public String deleteFacultyStudentAssociation(String _strFacultyId, String _studentId)
	{
		try
		{
			CSVFileWriter csvfileWriter = new CSVFileWriter();
			CSVFileReader csvfileReader = new CSVFileReader();
			ArrayList<FacultyStudent> facultyStudentList;
			StringBuilder fileName = new StringBuilder();
			String facultystudentFileName = (fileName.append(FILE_PATH).append(FACULTY_STUDENT_FILE_NAME)).toString();
			
			facultyStudentList = csvfileReader.readFacultyStudentCsvFile(facultystudentFileName);			
			
			if(facultyStudentList != null)
			{

				File file = new File(facultystudentFileName);
				file.delete();
				
				int listSize = facultyStudentList.size();
				for(int i=0; i<listSize;i++)
				{
					if(_studentId.equals(facultyStudentList.get(i).getStudentId()))
					{
						facultyStudentList.remove(i);
						break;
					}
				}
				
				int remainListSize = facultyStudentList.size();
			
				for(int j=0; j<remainListSize;j++)
				{
					csvfileWriter.writeFacultyStudentCsvFile(facultystudentFileName, facultyStudentList.get(j));
				}
			}		
			
			return STATUS_SUCCESS;
		}
		catch(Exception ex)
		{
			return STATUS_FALIURE;
		}
	}
	
	public  String insertSubjectDetails(SubjectNameId subjectDetails)
	{
		try
		{
			CSVFileWriter csvfileWriter = new CSVFileWriter();
			
			StringBuilder fileName = new StringBuilder();
			String SubjectFileName = fileName.append(FILE_PATH).append(SUBJECT_FILE_NAME).toString();
			
			csvfileWriter.writeSubjectDetailsCsvFile(SubjectFileName, subjectDetails);
			
			return STATUS_SUCCESS;
		}
		catch(Exception ex)
		{
			return STATUS_FALIURE;
		}
		
	}
	
	public ArrayList<SubjectNameId> getSubjectDetails()
	{
		try
		{
			CSVFileReader csvFileReader = new CSVFileReader();
			StringBuilder fileName = new StringBuilder();
			fileName.append(FILE_PATH).append(SUBJECT_FILE_NAME);
			ArrayList<SubjectNameId> subjectList = new ArrayList<SubjectNameId>();
			
			subjectList = csvFileReader.readSubjectDetailsCsvFile(fileName.toString());
			
			return subjectList;
		}
		catch(Exception ex)
		{
			throw ex;
		}
	}

}