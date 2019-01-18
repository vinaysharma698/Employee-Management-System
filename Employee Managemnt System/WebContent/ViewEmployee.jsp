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
<%
ArrayList<Pojo> viewEmployee = (ArrayList<Pojo>)request.getAttribute("viewEmployee");

Pojo p=null;
for(int i=0;i<viewEmployee.size();i++){
	p=viewEmployee.get(i);
	out.println("Employee Id:"+p.getEmployeeId());
	out.println("Employee Name:"+p.getEmployeeName());
	out.println("Phone No:"+p.getPhoneNo());
	out.println("Address: "+p.getAddress());
}
%>
<br>
<a href ="ViewEmployee.html">Back</a>
<a href ="index.html">Home</a>
</body>
</html>