package com.employeemanagement.testing;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.employeemanagement.employee_dao_impl.EmployeeDAOImpl;
import com.employeemanagement.model.Pojo;
import java.util.ArrayList;
class ViewEmployeeTest {
	

	
	@Test
	void test() {
		Pojo input = new Pojo();
		input.setEmployeeId(101);
		ArrayList<Pojo> expectedOutput =new ArrayList<Pojo>();
		EmployeeDAOImpl e= new EmployeeDAOImpl();
		Pojo expOutput = new Pojo();
		expOutput.setEmployeeId(101);
		expOutput.setEmployeeName("Vinay Kumar Sharma");
		expOutput.setAddress("D 58, Panchsheel Colony ,Lal Kuan");
		expOutput.setPhoneNo("8178577699");
		expectedOutput.add(expOutput);
		assertEquals(expectedOutput.get(0).getEmployeeName(),
				e.viewEmployee(input).get(0).getEmployeeName());
		assertEquals(expectedOutput.get(0).getEmployeeId(),
				e.viewEmployee(input).get(0).getEmployeeId());
		assertEquals(expectedOutput.get(0).getAddress(),
				e.viewEmployee(input).get(0).getAddress());
		assertEquals(expectedOutput.get(0).getPhoneNo(),
				e.viewEmployee(input).get(0).getPhoneNo());
	}

}
