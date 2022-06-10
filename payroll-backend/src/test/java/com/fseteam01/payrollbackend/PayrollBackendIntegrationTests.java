/*
  FSE Cohort - Team Project3
  HR Payroll System -Team1
  Class: PayrollBackendIntegrationTests - integration testing covering controller to dao layers
 */
package com.fseteam01.payrollbackend;

import com.fseteam01.payrollbackend.entity.Employee;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PayrollBackendIntegrationTests {
	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	@Order(1)
	@DisplayName("get a employee by id")
	@Sql("/insert.sql")
	public void getAEmployeeByIdTest() {
		ResponseEntity<Employee> response = testRestTemplate.getForEntity("/hrpayroll/api/v1/retrieveAEmployee/200", Employee.class);
		Assertions.assertEquals(200, response.getBody().getEmployeeId());
		Assertions.assertEquals("JOHN", response.getBody().getEmployeeFirstName());
		Assertions.assertEquals("DOE", response.getBody().getEmployeeLastName());
		Assertions.assertEquals("SENIOR ASSOCIATE", response.getBody().getEmployeeJobTitle());
		Assertions.assertEquals("100000.00", response.getBody().getEmployeeSalary());
	}

	@Test
	@Order(2)
	@DisplayName("update a employee")
	public void updateAEmployeeTest() {
		Employee employee = new Employee();
		employee.setEmployeeId(200);
		employee.setEmployeeFirstName("JOHN");
		employee.setEmployeeLastName("DOE");
		employee.setEmployeeJobTitle("SENIOR ASSOCIATE");
		employee.setEmployeeSSN("12345678");
		employee.setEmployeeHomeAddress("1103 Spring Ave");
		employee.setEmployeeSalary("110000.00");
		HttpEntity<Employee> request = new HttpEntity<>(employee);
		testRestTemplate.put("/hrpayroll/api/v1/updateAEmployee", request);
		ResponseEntity<Employee> response = testRestTemplate.getForEntity("/hrpayroll/api/v1/retrieveAEmployee/200", Employee.class);
		Assertions.assertEquals("110000.00", response.getBody().getEmployeeSalary());
	}

	@Test
	@Order(3)
	@DisplayName("add a employee")
	public void addAEmployeeTest() {
		Employee employee = new Employee();
		employee.setEmployeeFirstName("JAMES");
		employee.setEmployeeLastName("LEE");
		employee.setEmployeeJobTitle("ASSOCIATE");
		employee.setEmployeeSSN("11112222");
		employee.setEmployeeHomeAddress("780 Grand Street");
		employee.setEmployeeSalary("80000.00");
		HttpEntity<Employee> request = new HttpEntity<>(employee);
		ResponseEntity<Employee> response = testRestTemplate.postForEntity("/hrpayroll/api/v1/addAEmployee", request, Employee.class);
		Assertions.assertNotNull(response.getBody().getEmployeeId());
		Assertions.assertEquals("JAMES", response.getBody().getEmployeeFirstName());
		Assertions.assertEquals("LEE", response.getBody().getEmployeeLastName());
		Assertions.assertEquals("ASSOCIATE", response.getBody().getEmployeeJobTitle());
		Assertions.assertEquals("80000.00", response.getBody().getEmployeeSalary());
	}

	@Test
	@Order(4)
	@DisplayName("delete a employee by id")
	public void deleteAEmployeeTest() {
		testRestTemplate.delete("/hrpayroll/api/v1/deleteAEmployee/200");
		ResponseEntity<Employee> response = testRestTemplate.getForEntity("/hrpayroll/api/v1/getAPlumbingPart/200", Employee.class);
		Assertions.assertEquals(0, response.getBody().getEmployeeId());
	}

	//@Disabled
	@Test
	@Order(5)
	@DisplayName("cleanup test data")
	@Sql("/delete.sql")
	public void cleanUp() {
		System.out.println("Cleanup test data");
	}
}
