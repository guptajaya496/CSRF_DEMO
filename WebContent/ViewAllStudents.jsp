<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page errorPage="/ErrorPage.jsp?from=ViewAllStudents.jsp" %>   
<%@ taglib prefix="csrf" uri="WEB-INF/custom.tld"%>
<%@ page import="java.util.*,com.csrf.action.property.*;" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>CSE Grading System - View All Students</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<!-- <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"> -->
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<link rel="stylesheet" href="css/8LoginForm.css">
		
		<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script> -->
		<script type="text/javascript" src="js/jquery.min.js"></script>
		<!-- <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script> -->
		<script type="text/javascript" src="js/angular.min.4.8.js"></script>
		
		<!-- <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.3.15/angular.min.js"></script> -->
		<script type="text/javascript" src="js/angular.min.3.15.js"></script>
		
		<!-- <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script> -->
		<script type="text/javascript" src="js/bootstrap.min.js"></script>
		
		<script type="text/javascript" src="js/script.js"></script>
		<script type="text/javascript" src="js/angular.js"></script>	
		
		<script>
			
			window.location.hash="no-back-button";
			window.location.hash="Again-No-back-button";//again because google chrome don't insert first hash into history
			window.onhashchange=function()
			{
				window.location.hash="no-back-button";
			}
		</script>
	</head>
	<body ng-app="mainModule">
		<div ng-controller="cRUDController">
		<form name="frmViewAllStudents" method="post" action="cRUDController" class="body" ng-submit="submitForm()">			
			<table class="container">
				<tr>
					<td>
						<table class="login" >
							<tr>
								<td>
									<%@ include file="/Header.html" %> 
								</td>
							</tr>
							<tr>
								<td>
									<br/>
								</td>
							</tr>
							<tr>
								<td>
									<br/>
								</td>
							</tr>
							<tr>
								<td>
									<h1>
										Welcome to the CSE Institute Student Grading System 
									</h1>
								</td>
							</tr>			
							<tr>
								<td align="right">
									<p class="heading">
										You are logged in as :  ${Uname}
									</p>
								</td>								
							</tr>
							<tr>
								<td align="right">
									<p class="heading">
										<a href="/CSRF_POC/logoutAction"> Logout </a>	
									</p>			
								</td>
							</tr>	
							<tr>
								<td>
									<br/>
								</td>
							</tr>
							<tr  align="center">
								<td>
									<p class="heading" ng-show="ShowMessage">
										${customMessage}									
									</p>
									
								</td>
							</tr>
							<tr>
								<td>
									<div  ng-show="IsVisible" >
										<table class="container">
			<tr>
				<td>
					<table class="login">
						<tr>
							<td><br /></td>
						</tr>
						<tr>
							<td>
								<h1>Enter Record</h1>
							</td>
						</tr>
						<tr>
							<td>
								<br />
							</td>
						</tr>
						<tr>
							<td><input type="hidden" name="CSRFToken"  value="<csrf:token-value/>" ng-model="CSRFToken"></td>
						</tr>
						<tr>
							<td><input type="hidden" name="ctrlAction" ng-model="ctrlAction" value={{ctrlAction}}></td>
						</tr>
						<tr>
							<td><input type="hidden" name="strStudentId" ng-model="strStudentId" value={{strStudentId}}></td>
						</tr>
						<tr>
							<td></td>
						</tr>
						<tr align="center">
							<td>
								<p>Student Name:</p>
							</td>
						</tr>
						<tr align="center">
							<td>
								<p>
									<input type="text" title="Must be at least 2 characters." required pattern="[a-zA-Z ]*$" name="strStudentName" ng-model="strStudentName" placeholder="Student Name" ng-disabled="isReadOnly" >
									<input type="hidden" name="strStudentName" ng-model="strStudentName" value={{strStudentName}}></td>
								</p>
							</td>
						</tr>
						<tr>
							<td><br /></td>
						</tr>
						<tr align="center">
							<td>
								<p>Subject:</p>
							</td>
						</tr>
						<tr align="center">
							<td>
								<p>
									<select id="strSubjectId" name="strSubjectId" required class="select" ng-model="strSubjectId" ng-disabled="isReadOnly" > 
										<option value="">Please Select Subject</option>
										<option value="CS11">Distributed Computing</option>
										<option value="CS12">Mobile Computing</option>
										<option value="CS13">Analysis and Design of Real Time System</option>
										<option value="CS14">Dedicated System Design</option>
										<option value="CS15">VLSI Design</option>
										<option value="IT21">Engineering and Testing Structured Systems</option>
										<option value="IT22">Object-Oriented Programming</option>
										<option value="IT23">Engineering Object Oriented System</option>
										<option value="IT24">Multimedia System</option>
										<option value="IT25">Internet Programming and Web Service Engineering</option>
										<option value="IT31">Conceptual modeling</option>
										<option value="IT32">Requirements Engineering</option>
										<option value="IT33">Method Engineering</option>
									</select>
									<input type="hidden" name="strSubjectId" ng-model="strSubjectId" value={{strSubjectId}}></td>
									
								</p>
							</td>
						</tr>
						<tr>
							<td><br /></td>
						</tr>
						<tr align="center">
							<td>
								<p>Grade:</p>
							</td>
						</tr>
						<tr align="center">
							<td>
								<p>
									<select id="strGrade" name="strGrade" required ng-model="strGrade">
										<option value="">Please Select Grade</option>
										<option value="A+">A+</option>
										<option value="A">A</option>
										<option value="B">B</option>
										<option value="C">C</option>
										<option value="D">D</option>
										<option value="E">E</option>
										<option value="F">F</option>
									</select>
									<span ng-show="errorName">{{errorName}}</span>
								</p>
							</td>
						</tr>
						<tr>
							<td><br /></td>
						</tr>
						<tr class="submit" align="center">
							<td><input type="submit" value="Submit"></td>
						</tr>
						<tr>
							<td><br /></td>
						</tr>
						<tr align="center">
							<td>
								<input class="submitLink" type = "button" value = "ViewAllStudents" ng-click="ShowViewAll()" >
							<td>								
						<tr>
							<td><br /></td>
						</tr>
						<tr>
							<td><br /></td>
						</tr>
					</table>
				</td>
			</tr>

		</table>								
									</div>
								</td>
							</tr>
							
							
							<tr>
								<td>
									<br/>
								</td>
							</tr>
							<tr>
								<td>
									<div class="container" ng-show="TableShow">
										<table class="table table-hover">
									    	<thead>
									      		<tr>
									        		<th>Select</th>
									        		<th>Student ID</th>
									        		<th>Name</th>
									        		<th>Subject</th>
									        		<th>Grade</th>
									      		</tr>
									    	</thead>
										    <tbody>
										    	<%
										    	List <StudentDetails> listStudent = (List<StudentDetails>)request.getAttribute("listStudent");
									    		ArrayList<SubjectNameId> subjectList = (ArrayList<SubjectNameId>) request.getAttribute("subjectList"); 
									    		String subjectName = null;
									    		
									    		for(int i=0; i<listStudent.size(); i++ )
												{
									    			for(int j=0; j<subjectList.size(); j++)
									    			{
									    				if((listStudent.get(i).getSubjectId()).equals(subjectList.get(j).getSubjectId()))
									    				{
									    					//System.out.println(arg0)
									    					subjectName = subjectList.get(j).getSubjectName().toString();
									    				}
									    			}
												%>
												 <tr >
												 	<td><input ng-click="setUpdateValues('<%= listStudent.get(i).getStudentId() %>','<%= listStudent.get(i).getStudentName() %>','<%= listStudent.get(i).getGrade() %>','<%= listStudent.get(i).getSubjectId() %>')" type="radio" id="studentSelected_<%=i%>" name="studentSelected" value="<%=  listStudent.get(i).getStudentId() %>" ng-model="studentSelected" ng-value="checked"></td>       
												 	<td><input type="hidden" id="studentid<%=i%>" value="<%= listStudent.get(i).getStudentId() %>" > <%= listStudent.get(i).getStudentId() %></td>
												    <td><input type="hidden" id="studentname<%=i%>" value="<%= listStudent.get(i).getStudentName() %>"><%= listStudent.get(i).getStudentName() %></td>
												    <td><input type="hidden" id="subjectid<%=i%>" value="<%= listStudent.get(i).getSubjectId() %>"><%= subjectName.toString() %></td>
												    <td><input type="hidden" id="grade<%=i%>" value="<%= listStudent.get(i).getGrade() %>"><%= listStudent.get(i).getGrade() %></td>
												 </tr>         
												<%												
													}
												%>
											</tbody>
									  	</table>
									  	</div>
									  </td>
									</tr>	
									<tr align="center">
										<td>
											<input type = "button" value = "Add" ng-click="ShowAdd()" ng-show="VisibleAdd" >
											<input type = "button" value= "Update" ng-click="showUpdate()" ng-show="VisibleUpdate">
											<input type = "submit" value = "Delete" ng-click="showDelete()" ng-show="VisibleDelete">
											
										</td>
									</tr>	
																	
							<tr>
								<td>
									<br/>	
								</td>
							</tr>	
							<tr>
								<td>
									<br/>	
								</td>
							</tr>	
						</table>
					</td>
				</tr>
				<tr>
					<td>
						<br/>	
					</td>
				</tr>
				<tr>
					<td>
						<br/>	
					</td>
				</tr>
				<tr class="login-help" align="right">
					<td>
						<font face="Arial" size="3">
							<a href="/CSRF_POC/logoutAction"> Logout </a>				
						</font>			
					</td>
				</tr>	
				<tr>
					<td>
						<br/>
					</td>
				</tr>	
				<tr >
					<td>
						<%@ include file="/Footer.html" %>
					</td>
				</tr>	
			</table>
		</form>
		</div>
	</body>
</html>