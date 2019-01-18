package com.employeemanagement.controller;
import java.io.IOException;
import com.employeemanagement.model.*;
import com.employeemanagement.employee_dao_impl.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
public class DeleteEmployee extends HttpServlet {
	protected void service(HttpServletRequest req , HttpServletResponse res) 
			throws ServletException,IOException{
		
		int id =Integer.parseInt(req.getParameter("deleteid"));
		Pojo p = new Pojo();
		p.setEmployeeId(id);
		EmployeeDAOImpl e = new EmployeeDAOImpl();
		int x =e.deleteEmployee(p);
		if(x==0) {
			
			res.sendRedirect("Error.html");
		}else {
			
		res.sendRedirect("DeleteEmployee.jsp");
		}
	}
}