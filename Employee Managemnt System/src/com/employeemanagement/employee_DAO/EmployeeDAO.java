package com.employeemanagement.employee_DAO;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.employeemanagement.model.*;
public interface EmployeeDAO {
	
	public int addEmployee(Pojo p);
	public int deleteEmployee(Pojo p);
	public int updateEmployee(Pojo p);
	public ArrayList<Pojo> viewEmployee(Pojo p);
	public ArrayList<Pojo> sortEmployeeBySalary();
	public ArrayList<Pojo> employeeOnProject(Pojo p);
	public int assignProject(Pojo p);
	public int unassignProject(Pojo p);
	public int addProject(Pojo p);
	public int updateProject(Pojo p);
	public int assignSalary(Pojo p);
	public int updateSalary(Pojo p);
}
