package com.employeemanagement.controller;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.employeemanagement.model.*;
import com.employeemanagement.employee_dao_impl.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
public class SortEmployeeBySalary extends HttpServlet {
	protected void service(HttpServletRequest req , HttpServletResponse res) 
			throws ServletException,IOException{
	
		EmployeeDAOImpl e = new EmployeeDAOImpl();
		ArrayList<Pojo> sortEmployee=e.sortEmployeeBySalary();
		if(sortEmployee==null) {
			
			res.sendRedirect("Error.html");
		}else {
			req.setAttribute("sortEmployeeBySalary", sortEmployee);
			req.getRequestDispatcher("SortEmployeeBySalary.jsp").forward(req, res);	
		}
	}
}
