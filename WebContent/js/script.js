function callDelete()
{
	var flag = false;
	var selectedStudent;
	for (var i = 0; i < document.frmViewAllStudents.studentSelected.length ; i++)
	{
		if(document.frmViewAllStudents.studentSelected[i].checked == true)
		{
			alert("student selected");
			flag = true;
		}
	}

	if(flag)
	{
		confirm("Are you sure want to delete the record ?");
		document.frmViewAllStudents.ctrlAction.value = "delete";
		document.frmViewAllStudents.submit();
	}
	else
	{
		alert("Please select Student record!!");
	}
}


function callUpdate()
{	
	var flag = false;
	var selectedStudent;
	for (var i = 0; i < document.frmViewAllStudents.studentSelected.length; i++)
	{
		if(document.frmViewAllStudents.studentSelected[i].checked == true)
		{
			alert("i m don");
			flag = true;
		}
	}
	
	if(flag)
	{ 
		var stuid = document.querySelector('input[name = "studentSelected"]:checked').id;
		var v = stuid.split("_");
		var studentid = document.getElementById("studentid"+ v[1]).value;
		var studentname = document.getElementById("studentname"+ v[1]).value;
		var subjectId = document.getElementById("subjectid"+ v[1]).value;
		var grade = document.getElementById("grade"+ v[1]).value;
		
		var queryString = "?ctrlAction=update&strStudentId="+ studentid + "&strStudentName=" + studentname + "&strSubjectId=" + subjectId + "&strGrade=" + grade;
		
		//window.open("StudentDetails.jsp"+queryString , "MsgWindow", "width=500, height=500,resizable = no,location = no");
		window.open("StudentInformation.jsp"+queryString , "MsgWindow", "width=500, height=500,resizable = no,location = no");
		//window.open("StudentRecord.jsp"+queryString , "MsgWindow", "width=500, height=500,resizable = no,location = no");
	}
	else
	{
		alert("Please select Student record!!");
	}
	
}


function callAdd()
{
	var queryString = "?ctrlAction=create";
	//var myWindow = window.open("StudentDetails.jsp"+queryString, "MsgWindow", "width=500, height=500,resizable= no,location= no");
	//var myWindow = window.open("StudentInformation.jsp"+queryString, "MsgWindow", "width=500, height=500,resizable= no,location= no");
	var myWindow = window.open("StudentRecord.jsp"+queryString, "MsgWindow", "width=500, height=500,resizable= no,location= no");
}

function setField() 
{
	var qString = location.search;	// get the query string
	var v = qString.split("?");
	var fields = v[1];
	var indivfield = fields.split("&");
	if(indivfield.length >1)
	{
		var qsctrlAction = indivfield[0];
    	var qsstuId = indivfield[1];
    	var qsstuName = indivfield[2];
    	var qssubId = indivfield[3];
    	var qsgrade = indivfield[4];
    	
    	var ctrlAction = qsctrlAction.split("=");
    	var stuId = qsstuId.split("=");
    	var stuName = qsstuName.split("=");
    	var subId =  qssubId.split("=") ;
    	var grade = qsgrade.split("=");
    	
    	document.frmStudentDetails.ctrlAction.value = ctrlAction[1] ;
    	document.frmStudentDetails.strStudentId.value = stuId[1] ;
    	document.frmStudentDetails.strStudentName.value =  stuName[1] ;
    	document.frmStudentDetails.strStudentName.readOnly = true;
    	//document.getElementById("strSubjectId").value = "\"" + subId[1] + "\"";
    	setSelectedIndex(document.frmStudentDetails.strSubjectId,subId[1]);
    	document.frmStudentDetails.strSubjectId.disabled = "true";
    	//document.getElementById("strGrade").value = "\"" +  grade[1] + "\"";
    	setSelectedIndex(document.frmStudentDetails.strGrade, grade[1]);		        			       
	}
	else
	{
		var qsctrlAction = indivfield[0];
		var ctrlAction = qsctrlAction.split("=");
		document.frmStudentDetails.ctrlAction.value = ctrlAction[1] ;		        	
	}
		
}

function doSubmit()
{
	validateForm();	    	
	document.frmStudentDetails.submit();
	opener.location.reload();
	window.close();	    	
}

function setSelectedIndex(s, v) 
{
	for (var i = 0; i < s.options.length; i++) 
	{
	    if (s.options[i].value == v)
	    {
	    	s.options[i].selected = "true";
	      	break;
	    }	    	   
	 }
} 

function validateForm()
{
	if(document.frmStudentDetails.strStudentName.value == "")
	{
		alert("Please enter Student Name.");
		document.getElementById("strStudentName").innerHTML = inpObj.validationMessage;
		return false;	
	}
	
	if(document.getElementById("strSubjectId").value == "")
	{
		alert("Please select Subject.");
		return false;
	}
	
	if(document.getElementById("strGrade").value == "")
	{
		alert("Please select Grade.");
		return false;
	}
}

