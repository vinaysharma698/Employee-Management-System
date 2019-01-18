package com.employeemanagement.controller;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.employeemanagement.model.*;
import com.employeemanagement.employee_dao_impl.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
public class ViewEmployee extends HttpServlet {
	protected void service(HttpServletRequest req , HttpServletResponse res) 
			throws ServletException,IOException{
		
		int id =Integer.parseInt(req.getParameter("viewId"));
		Pojo p = new Pojo();
		p.setEmployeeId(id);
		EmployeeDAOImpl e = new EmployeeDAOImpl();
		ArrayList<Pojo> viewEmployee= e.viewEmployee(p);
		if(viewEmployee.equals(null)) {
			
			res.sendRedirect("Error.html");
		}else {
			
			req.setAttribute("viewEmployee", viewEmployee);
			req.getRequestDispatcher("ViewEmployee.jsp").forward(req, res);	
		}	
	}
}