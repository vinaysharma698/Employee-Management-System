package com.employeemanagement.controller;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.employeemanagement.model.*;
import com.employeemanagement.employee_dao_impl.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
public class EmployeeOnProject extends HttpServlet {
	protected void service(HttpServletRequest req , HttpServletResponse res) 
			throws ServletException,IOException{
		
		int id= Integer.parseInt(req.getParameter("id"));
		Pojo p = new Pojo();
		p.setProjectId(id);
		EmployeeDAOImpl e = new EmployeeDAOImpl();
		ArrayList<Pojo> employeeOnProject=  e.employeeOnProject(p);
		if(employeeOnProject==null) {
			
			res.sendRedirect("Error.html");
		}else {
			
			req.setAttribute("employeeOnProject",employeeOnProject);
			req.getRequestDispatcher("EmployeeOnProject.jsp").forward(req, res);	
		}
	}
}
