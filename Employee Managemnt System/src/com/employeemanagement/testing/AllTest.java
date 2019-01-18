package com.employeemanagement.testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.employeemanagement.employee_dao_impl.EmployeeDAOImpl;
import com.employeemanagement.model.Pojo;

class AllTest {
	EmployeeDAOImpl e= new EmployeeDAOImpl();
	@Test
	void testAddEmployee() {
		Pojo input = new Pojo();
		
		//Test to create Employee
		input.setEmployeeId(109);
		input.setEmployeeName("Vinay kumar Sharma");
		input.setAddress("Gzb");
		input.setPhoneNo("1234567890");
		int create =e.addEmployee(input);
		assertEquals(1,create);
		
		//here the phone no exceeds 10 digits
		//So it will fail
		
		/*input.setEmployeeId(109);
		input.setEmployeeName("Vinay kumar Sharma");
		input.setAddress("Gzb");
		input.setPhoneNo("12345678900000");
		int create1 =e.addEmployee(input);
		assertEquals(1,create1);*/
		
		//Test to view employee
		input.setEmployeeId(109);
		ArrayList<Pojo> expectedOutput =new ArrayList<Pojo>();
		EmployeeDAOImpl e= new EmployeeDAOImpl();
		Pojo expOutput = new Pojo();
		expOutput.setEmployeeId(109);
		expOutput.setEmployeeName("Vinay kumar Sharma");
		expOutput.setAddress("Gzb");
		expOutput.setPhoneNo("1234567890");
		expectedOutput.add(expOutput);
		assertEquals(expectedOutput.get(0).getEmployeeId(),
				e.viewEmployee(input).get(0).getEmployeeId());
		
		//Test to update employee
		input.setEmployeeId(109);
		input.setEmployeeName("vinay");
		input.setAddress("Gzb");
		input.setPhoneNo("1234567890");
		int update =e.updateEmployee(input);
		assertEquals(1,update);
		
		//Test to update Project
		input.setProjectId(101);
		input.setProjectDesciption("updated");
		int updateProject = e.updateProject(input);
		assertEquals(1,updateProject);
	
		//Test to Assign Project
		input.setEmployeeId(109);
		input.setProjectId(101);
		int assignProject= e.assignProject(input);
		assertEquals(1,assignProject);
		
		//Test to Unassign Project
		input.setEmployeeId(109);
		input.setProjectId(101);
		int unassignProject= e.unassignProject(input);
		assertEquals(1,unassignProject);
		
		//Test to assign Salary
		input.setEmployeeId(109);
		input.setSalary("1000");
		System.out.println(input.getSalary());
		System.out.println(input.getEmployeeId());
		int salaryAssigned = e.assignSalary(input);
		assertEquals(1,salaryAssigned);
		
		//Test to update Salary
		input.setEmployeeId(109);
		input.setSalary("10000");
		int salaryUpdated= e.updateSalary(input);
		assertEquals(1,salaryUpdated);
		
		//Test to delete Employee
		input.setEmployeeId(109);
		int delete =e.deleteEmployee(input);
		assertEquals(1,delete);
	}
	
}
