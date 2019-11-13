<!-- The servlet stores this bean to the session object and forwards
request to a StudentJSP using RequestDispatcher object to display the student
data to the user. The structure of the StudentJSP page for the retrieved data could
be similar to the Survey Form in a read only format.  -->
<%@page import="managedBean.studentBean"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student Details</title>
</head>
<body>
	<h1>Displaying Student Details</h1>

	<%-- Fetching the attributes of the request object 
                    which was previously set by the servlet 
                    "TestServelet.java" 
            --%>
	<%
		studentBean std = new studentBean();
		std = (studentBean) request.getAttribute("std");
	%>

	<h4>
		Student ID:
		<%=std.getStudID()%></h4>
	<h4>
		Name:
		<%=std.getFullname()%></h4>
	<h4>
		Email:
		<%=std.getEmail()%></h4>
	<h4>
		Phone:
		<%=std.getPhone()%></h4>
	<h4>
		URL:
		<%=std.getUrl()%></h4>
	<h4>
		Address:
		<%=std.getAddress()%></h4>
	<h4>
		Zip Code:
		<%=std.getZipCode()%></h4>
	<h4>
		City:
		<%=std.getCity()%></h4>
	<h4>
		State:
		<%=std.getState()%></h4>
	<h4>
		Comments:
		<%=std.getComments()%></h4>


</body>
</html>

