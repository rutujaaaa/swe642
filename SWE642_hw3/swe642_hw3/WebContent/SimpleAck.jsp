<!--If the mean was less than 90, the servlet forwards request to
SimpleAcknowledgement JSP using the RequestDipatcher object. The
SimpleAcknowdedgementJSP simply thanks the user for filling out the form and
prints mean and standard deviation on the page accessing the data from DataBean
-->
<%@page import="managedBean.dataBean"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Simple Acknowledgment Page</title>
</head>
<body>
	<h1>Thank You for filling out the form!</h1>
	<h2>Your data was saved successfully.</h2>
	<%  dataBean dtBean = new dataBean();
            dtBean = (dataBean) request.getAttribute("data_bean1");
        %>

	<h4>
		Mean:
		<%=request.getAttribute("mean")%></h4>
	<h4>
		Standard Deviation:
		<%=request.getAttribute("stdDev")%></h4>
	<h1>Displaying Student List</h1>
	<form id="SimpAckForm" method="get" action="TestServelet">
		<table border="1" width="500" align="center">
			<tr bgcolor="00FF7F">
				<th><b>Student IDs</b></th>
			</tr>
			<%-- Fetching the attributes of the request object 
			which was previously set by the servlet 
			"TestServelet.java" 
		--%>
			<%ArrayList<String> std = (ArrayList<String>)request.getAttribute("id_jsp"); 
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

