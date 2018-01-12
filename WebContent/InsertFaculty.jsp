<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="csrf" uri="WEB-INF/custom.tld"%>
<%@ page errorPage="/ErrorPage.jsp?from=InsertFaculty.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="html">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>CSE Grading System - Insert Faculty</title>		
		<link rel="stylesheet" href="css/8LoginForm.css">		
		<script src="http://code.jquery.com/jquery-2.1.1.min.js"></script>				
	</head>
	<body>
		<form name="frmInsertFaculty" method="post" action="insertFaculty" >
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
								<td>
									<br/>
								</td>
							</tr>
							<tr>
								<td>
									<input type = "hidden" name = "CSRFToken" value="<csrf:token-value/>">
								</td>
							</tr>
							<tr>
								<td>
									<br/>
								</td>
							</tr>
							<tr align="center" class="heading">
								<td>
									Please fill the below fields to create a Faculty Record!!
								</td>
							</tr>
							<tr>
								<td>
									<br/>
								</td>
							</tr>
							<tr>
								<td>
									<p class="remember_me">
										${customMessage}
									</p>
								</td>
							</tr>
							<tr>
								<td>
									<br/>
								</td>
							</tr>
							<tr align="center">
								<td>
									<p>
										Faculty Name : 
										<input type="text" title="Must be at least 2 characters." required pattern="[a-zA-Z ]*$" name="txtFacultyName" placeholder="Enter User Name" value= ${FacultyName} > 	
									</p>		
								</td>
							</tr>
							<tr align="center">
								<td>
									<br/>
								</td>
							</tr>
							<tr align="center">
								<td>
									<p>
										Date of Birth : 
										<input type="text" title="Date should be in dd/mm/yyyy format." required  pattern="(0[123456789]|1[0123456789]|2[0123456789]|3[01])([/])(0[123456789]|10|11|12)([/])([1-2][0-9][0-9][0-9])"   name="txtFacultyDOB" placeholder="Date of Birth in dd/mm/yyyy format." value= ${FacultyDOB} >
									</p> 			
								</td>
							</tr>
							<tr align="center">
								<td>
									<br/>
								</td>
							</tr>
							<tr align="center">   
								<td>
									<p>
										Password : 
										<input type="password" title="Password should have at least 6 alphanumeric characters." required pattern="[a-zA-Z0-9 ]*$"  name="txtFacultyPassword" placeholder="Password at least 6 characters." value= ${FacultyPassword}  >
									</p> 			
								</td>
							</tr>
							<tr align="center">
								<td>
									<br/>
								</td>
							</tr>
							<tr class="submit"  align="center">
								<td>
									<p>
										<input type="submit" value="Submit" class="submit"/>				
									</p>			
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
				<tr class="login-help">
					<td>
						<font face="Arial" size="3">
							<a href="/CSRF_DEMO/logoutAction"> Logout </a>				
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
	</body>
</html>