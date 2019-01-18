package com.employeemanagement.employee_dao_impl;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.*;
import com.employeemanagement.model.*;
import com.employeemanagement.util.*;
import com.employeemanagement.employee_DAO.*;
public class EmployeeDAOImpl implements EmployeeDAO{
	
	public static ResultSet rs;
	private static Connection con=DBConnection.createConnection();
	private static Statement st=null;
	private static PreparedStatement pst=null;
	
	
	@Override
	public int addEmployee(Pojo p ) {
				
		int employeeAdded=0;
		int employeeId = p.getEmployeeId();
		String employeeName= p.getEmployeeName();
		String phoneNo = p.getPhoneNo();
		String address = p.getAddress();
			
		try {
			
			pst=con.prepareStatement("insert into Employee values (?,?,?,?)");
			pst.setInt(1, employeeId);
			pst.setString(2, employeeName);
			pst.setString(3, phoneNo);
			pst.setString(4, address);
			employeeAdded =pst.executeUpdate();
			
		}catch(SQLException e) {
			
			return 0;
		}
		return employeeAdded;
	}

	@Override
	public int deleteEmployee(Pojo p) {
		int employeeDeleted=0;
		int employeeId = p.getEmployeeId();
		try {
			
			pst=con.prepareStatement("delete from Salary where Id_Employee=?");
			pst.setInt(1, employeeId);
			employeeDeleted =pst.executeUpdate();
			pst=con.prepareStatement("delete from Employee_Project "
					+ "where Id_Employee=?");
			pst.setInt(1, employeeId);
			employeeDeleted =pst.executeUpdate();
			pst=con.prepareStatement("delete from Employee where id=?");
			pst.setInt(1, employeeId);
			employeeDeleted =pst.executeUpdate();
		}catch(SQLException e) {
			
			return 0;
		}
		return employeeDeleted;
	}

	@Override
	public int updateEmployee(Pojo p ) {
		
		int employeeUpdated=0;
		int employeeId = p.getEmployeeId();
		String phoneNo = p.getPhoneNo();
		String address = p.getAddress();
		String employeeName= p.getEmployeeName();
		try {
			
			pst=con.prepareStatement("update Employee set name=?,"
					+ "phone_no=?,address=? where id=?");
			pst.setInt(4, employeeId);
			pst.setString(1, employeeName);
			pst.setString(2, phoneNo);
			pst.setString(3, address);
			employeeUpdated =pst.executeUpdate();
		}catch(SQLException e) {
			
			return 0;
		}
		return employeeUpdated;
	}

	@Override
	public ArrayList<Pojo> viewEmployee(Pojo p) {
		int employeeId = p.getEmployeeId();
		ArrayList<Pojo> viewEmployee= new ArrayList<Pojo>();
		try {
			st=con.createStatement();
			rs =st.executeQuery("select * from Employee where id="+employeeId+"");
			Pojo view= new Pojo();
			while(rs.next()) {
				
				view.setEmployeeId(rs.getInt(1));
				view.setEmployeeName(rs.getString(2));
				view.setPhoneNo(rs.getString(3));
				view.setAddress(rs.getString(4));
				viewEmployee.add(view);
			}
		}catch(SQLException e) {
			
			return null;
		}
		return viewEmployee;
	}

	@Override
	public ArrayList<Pojo> sortEmployeeBySalary() {
		ArrayList<Pojo> sortEmployeeBySalary= new ArrayList<Pojo>();
		try {
			st=con.createStatement();
			rs =st.executeQuery("select name , salary from Employee ,Salary"
					+ " where id=ID_Employee order by salary desc");
			while(rs.next()) {
				
				Pojo sortEmployee= new Pojo();
				sortEmployee.setEmployeeName(rs.getString(1));
				sortEmployee.setSalary(rs.getString(2));
				sortEmployeeBySalary.add(sortEmployee);
			}
		
		}catch(SQLException e) {
				
				return null;
			}
			return sortEmployeeBySalary;
	}

	@Override
	public ArrayList<Pojo> employeeOnProject(Pojo p) {
		int idProject= p.getProjectId();
		ArrayList<Pojo> employeeOnProject= new ArrayList<Pojo>();
		try {
			
			st=con.createStatement();
			rs =st.executeQuery("select Id, Name from Employee where Id in "
					+ "(select Id_Employee from Employee_Project "
					+ "where Id_Project="+idProject+")");
			while(rs.next()) {
				
				Pojo employeeProject= new Pojo();
				employeeProject.setEmployeeId(rs.getInt(1));
				employeeProject.setEmployeeName(rs.getString(2));;
				employeeOnProject.add(employeeProject);
			}
		}catch(SQLException e) {
			
			return null;
		}
		return employeeOnProject;
	}

	@Override
	public int assignProject(Pojo p) {
		int idEmployee=p.getEmployeeId();
		int idProject= p.getProjectId();
		int projectAssigned = 0;
		try {
			
			pst=con.prepareStatement("insert into Employee_Project values (?,?)");
			pst.setInt(1, idEmployee);
			pst.setInt(2, idProject);
			projectAssigned =pst.executeUpdate();
		}catch(SQLException e) {
			
			return 0;
		}
		return projectAssigned;
	}

	@Override
	public int addProject(Pojo p) {

		int id=p.getProjectId();
		String description= p.getProjectDesciption();
		int projectAdded = 0;
		try {
			
			pst=con.prepareStatement("insert into Project values (?,?)");
			pst.setInt(1, id);
			pst.setString(2, description);
			projectAdded =pst.executeUpdate();
		}catch(SQLException e) {
			
			return 0;
		}
		return projectAdded;
	}

	@Override
	public int unassignProject(Pojo p) {
		int idEmployee=p.getEmployeeId();
		int idProject= p.getProjectId();
		int projectUnassigned = 0;
		try {
				
			pst=con.prepareStatement("delete from Employee_Project "
					+ "where id_employee=? and id_project=?");
			pst.setInt(1, idEmployee);
			pst.setInt(2, idProject);
			projectUnassigned =pst.executeUpdate();
		}catch(SQLException e) {
			
			return 0;
		}
		return projectUnassigned;
	
	}

	@Override
	public int updateProject(Pojo p) {
		int id=p.getProjectId();
		String description= p.getProjectDesciption();
		int projectUpdated = 0;
		try {
			
			pst=con.prepareStatement("update Project set description=? "
					+ "where id=?");
			pst.setInt(2, id);
			pst.setString(1, description);
			projectUpdated =pst.executeUpdate();
		}catch(SQLException e) {
			
			return 0;
		}
		return projectUpdated;
	}

	@Override
	public int assignSalary(Pojo p) {
		int id=p.getEmployeeId();
		String salary= p.getSalary();
		int salaryAssigned = 0;
		try {
			
			pst=con.prepareStatement("insert into Salary values (?,?)");
			pst.setInt(1, id);
			pst.setString(2, salary);
			salaryAssigned =pst.executeUpdate();
		}catch(SQLException e) {
			
			return 0;
		}
		return salaryAssigned;
	}

	@Override
	public int updateSalary(Pojo p) {
		int id=p.getEmployeeId();
		String salary= p.getSalary();
		int salaryAssigned = 0;
		try {
			
			pst=con.prepareStatement("update Salary set salary=? where Id_Employee=?");
			pst.setInt(2, id);
			pst.setString(1, salary);
			salaryAssigned =pst.executeUpdate();
		}catch(SQLException e) {
			
			return 0;
		}
		return salaryAssigned;
	}

}
