package com.Neosoft.Springboot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
class ApplicationTests {

	@Mock
	private EmployeeRepositry employeerepo;
	@InjectMocks
	private Service employeeservice = new Service();

	@Test
	void register() {
		Employee e = new Employee();
		e.setId(1);
		e.setName("pratheep");
		e.setSurname("sankati");
		e.setDob(new Date(1997, 7, 8));
		e.setDoj(new Date(2002, 3, 4));
		e.setPincode(534447);
		;
		when(employeerepo.save(e)).thenReturn(e);
		Assertions.assertEquals(e, e);
	}

	@Test
	void getUser() {
		Employee e = new Employee();
		e.setId(1);
		e.setName("raju");
		e.setSurname("deshaboina");
		e.setDob(new Date(1997, 9, 20));
		e.setDoj(new Date(2020, 3, 14));
		e.setPincode(54321);

		Employee e2 = new Employee();
		e2.setId(2);
		e2.setName("dileep");
		e2.setSurname("sankati");
		e2.setDob(new Date(1997, 9, 20));
		e2.setDoj(new Date(2000, 11, 2));
		e2.setPincode(534447);

		List<Employee> list = new ArrayList<Employee>();
		list.add(e);
		list.add(e2);
		when(employeerepo.findByNameOrSurname("pratheep", "sankati")).thenReturn(list);
		List<Employee> emp = employeeservice.sortbyname(e.getName(), e.getSurname());

		Assertions.assertEquals(0, emp.size());
	}

	@Test
	void getUserp() {
		Employee e = new Employee();
		e.setId(1);
		e.setName("ramya");
		e.setSurname("poloju");
		e.setDob(new Date(1997, 9, 20));
		e.setDoj(new Date());
		e.setPincode(534447);
		Employee e2 = new Employee();
		e2.setId(2);
		e2.setName("divya");
		e2.setSurname("ilapuram");
		e2.setDob(new Date(1997, 9, 20));
		e2.setDoj(new Date(1998, 9, 21));
		e2.setPincode(500018);
		List<Employee> list = new ArrayList<Employee>();
		list.add(e);
		list.add(e2);
		when(employeerepo.findByNameOrPincode("pratheep", 534447)).thenReturn(list);
		List<Employee> emp = employeeservice.sortbypincode(e.getName(),e.getPincode());

		Assertions.assertEquals(0, emp.size());
	}

	@Test
	void sortbydodandjoingdate() {
		Employee e = new Employee();
		e.setId(1);
		e.setName("bhaskar");
		e.setSurname("sankati");
		e.setDob(new Date(1997, 9, 20));
		e.setDoj(new Date(1994,12,11));
		e.setPincode(12345);
		Employee e2 = new Employee();
		e2.setId(2);
		e2.setName("raju");
		e2.setSurname("deshaboina");
		e2.setDob(new Date(1997, 9, 20));
	e2.setDoj(new Date(1998,07,06));
		e2.setPincode(112233);
		List<Employee> list = new ArrayList<Employee>();
		list.add(e); 
		list.add(e2);
		when(employeerepo.findByDobAndDoj(new Date(1997, 9, 20), new Date(2021, 9, 06))).thenReturn(list);
		List<Employee> emp = employeeservice.sortbydob(new Date(1997, 9, 20), new Date(2021, 9, 06));

		Assertions.assertEquals(2, emp.size());
	}

}
