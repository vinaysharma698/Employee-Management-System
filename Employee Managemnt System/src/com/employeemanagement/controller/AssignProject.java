package com.employeemanagement.controller;
import java.io.IOException;
import com.employeemanagement.model.*;
import com.employeemanagement.employee_dao_impl.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
public class AssignProject extends HttpServlet {
	protected void service(HttpServletRequest req , HttpServletResponse res) 
			throws ServletException,IOException{
		
		int idEmployee =Integer.parseInt(req.getParameter("idEmployee"));
		int idProject = Integer.parseInt(req.getParameter("idProject"));
		Pojo p = new Pojo();
		p.setEmployeeId(idEmployee);
		p.setProjectId(idProject);
		EmployeeDAOImpl e = new EmployeeDAOImpl();
		int x =e.assignProject(p);
		if(x==0) {
			
			res.sendRedirect("Error.html");
		}else {
			
		res.sendRedirect("AssignProject.jsp");
		}
	}
}
