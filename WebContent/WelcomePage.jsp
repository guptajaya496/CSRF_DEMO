<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page errorPage="/ErrorPage.jsp?from=WelcomePage.jsp" %>
<%@ taglib prefix="csrf" uri="WEB-INF/custom.tld"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>CSE Institute</title>
		<script src="http://code.jquery.com/jquery-2.1.1.min.js"></script>
		<link rel="stylesheet" href="css/8LoginForm.css">
	</head>
	<body>
		<script>
			$("#frmWelcome").validate();
		</script>
		<form name="frmWelcome" method="post" action="baseAction" class="body">
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
							<tr  align="center">
								<td>
									<p class=heading>
										${customMessage}
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
									<input type = "hidden" name = "CSRFToken" value="<csrf:token-value/>">									
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
							<tr align="center">
								<td>
									<p>
										User Name :
										<input type="Text" required name="txtUname" placeholder="Enter User Name" >										
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
										Password :
										<input type="password" required name="txtPwd" placeholder="Enter Password" >
									</p>
								</td>
							</tr>
							<tr>
								<td>
									<br/>
								</td>
							</tr>
							<tr class="submit" align="center">
								<td >
									<input type="submit" value="Login"/>
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
				<tr  class="login-help">
					<td>
						<font face="Arial" size="3">
							<a href="/CSRF_DEMO/baseAction?createFaculty=true"> Click here to Sign Up as New Faculty. </a>
						</font>			
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