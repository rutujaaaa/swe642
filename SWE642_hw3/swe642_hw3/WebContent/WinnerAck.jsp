<%@page import="managedBean.dataBean"%>
<!--If the mean is greater than or equal to 90, the servlet forwards the request to the
WinnerAcknlowledgement JSP using RequestDispatcher object. The
WinnerAcknowledgement JSP thanks the user for completing the survey,
announces that the user is a raffle winner of two movie tickets, and prints mean
and standard deviation on the page accessing the data from DataBean. 
--><%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Winner Acknowledgment Page</title>
</head>
<body>
	<h1>Congratulations! You have won 2 free movie tickets!</h1>
	<h2>Thank you for filling out the form. Your data was saved
		successfully.</h2>
	<%  dataBean dtBean = new dataBean();
                dtBean = (dataBean)request.getAttribute("data_bean1");
                    %>

	<h4>
		Mean:
		<%=request.getAttribute("mean")%></h4>
	<h4>
		Standard Deviation:
		<%=request.getAttribute("stdDev")%></h4>


	<h1>Displaying Student List</h1>
	<form id="WinnAckForm" method="get" action="TestServelet">
		<table border="1" width="500" align="center">
			<tr bgcolor="00FF7F">
				<th><b>Student IDs</b></th>
			</tr>
			<%-- Fetching the attributes of the request object 
			which was previously set by the servlet 
			"TestServelet.java" 
		--%>
			<%ArrayList<String>  std = (ArrayList<String>) request.getAttribute("id_jsp"); 
		for(String s:std){%>
			<%-- Arranging data in tabular form 
		--%>
			<tr>
				<td><a name="ID1" href="TestServelet?param1=<%=s%>"><%=s%></a></td>

			</tr>
			<%}%>
		</table>
	</form>
</body>
</html>