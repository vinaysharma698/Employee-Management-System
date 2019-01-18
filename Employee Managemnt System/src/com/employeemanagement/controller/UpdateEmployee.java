package com.employeemanagement.controller;
import java.io.IOException;
import com.employeemanagement.model.*;
import com.employeemanagement.employee_dao_impl.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
public class UpdateEmployee extends HttpServlet {
	protected void service(HttpServletRequest req , HttpServletResponse res) 
			throws ServletException,IOException{
		
		int id =Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String phoneNo =req.getParameter("phoneNo");
		String address = req.getParameter("address");
		Pojo p = new Pojo();
		p.setEmployeeId(id);
		p.setEmployeeName(name);
		p.setPhoneNo(phoneNo);
		p.setAddress(address);
		EmployeeDAOImpl e = new EmployeeDAOImpl();
		int x =e.updateEmployee(p);
		if(x==0) {
			
			res.sendRedirect("Error.html");
		}else {
			
			res.sendRedirect("UpdateEmployee.jsp");
		}
	}
}
