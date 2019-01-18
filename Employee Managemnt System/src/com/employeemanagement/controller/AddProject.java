package com.employeemanagement.controller;
import java.io.IOException;
import com.employeemanagement.model.*;
import com.employeemanagement.employee_dao_impl.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
public class AddProject extends HttpServlet {
	protected void service(HttpServletRequest req , HttpServletResponse res) 
			throws ServletException,IOException{
		
		int id =Integer.parseInt(req.getParameter("id"));
		String description = req.getParameter("description");
		Pojo p = new Pojo();
		p.setProjectId(id);
		p.setProjectDesciption(description);
		EmployeeDAOImpl e = new EmployeeDAOImpl();
		int x =e.addProject(p);
		if(x==0) {
			
			res.sendRedirect("Error.html");
		}else {
			
			res.sendRedirect("AddProject.jsp");
		}
	}
}
