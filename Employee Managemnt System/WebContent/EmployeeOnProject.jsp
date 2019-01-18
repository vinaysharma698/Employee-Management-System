<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="java.sql.ResultSet" %>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="com.employeemanagement.model.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
<th>S.NO</th>
<th>Employee Id</th>
<th>Employee Name</th>
<%
	int sNo=1;
ArrayList<Pojo> employeeOnProject = (ArrayList<Pojo>)request.getAttribute("employeeOnProject");

Pojo p=null;
for(int i=0;i<employeeOnProject.size();i++){
	p=employeeOnProject.get(i);
 %>
<tr>
	<td><% out.println(sNo);%></td>
	<td><% out.println(p.getEmployeeId());%></td>
	<td><% out.println(p.getEmployeeName()); 
			sNo++; 
	}%></td>
</tr>	
</table>
<a href ="EmployeeOnProject.html">Back</a>
<a href ="index.html">Home</a>
</body>
</html>