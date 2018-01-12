<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage = "true" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>CSE Institute - Error Page</title>
	</head>
	<body>
		<div align="center">
			<br/>
			<font face="Arial" size="4">
				An Error occurred on page <b>${ServletName}</b>.
				<br/><br/>
				The exception was : <br/>
				<b> Error code : ${ErrorStatusCode}</b>
				<br/>
				<b> Exception : ${Exception}</b>
				<br/>
				on <br/>
				<b>${RequestUri}</b>
		   </font>
		</div>		
	</body>
</html>