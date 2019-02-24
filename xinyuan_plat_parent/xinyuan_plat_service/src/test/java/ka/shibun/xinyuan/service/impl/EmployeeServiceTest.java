package ka.shibun.xinyuan.service.impl;

import ka.shibun.xinyuan.PlatServiceApplication;
import ka.shibun.xinyuan.domain.Employee;
import ka.shibun.xinyuan.query.EmployeeQuery;
import ka.shibun.xinyuan.service.IEmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PlatServiceApplication.class)
public class EmployeeServiceTest {

    @Autowired
    private IEmployeeService employeeService;

    @Test
    public void getById() {
        Employee byId = employeeService.getById(1L);
    }

    @Test
    public void loadByQuery() {
        List<Employee> employees = employeeService.loadByQuery(new EmployeeQuery());
    }

    @Test
    public void save() {
        Employee employee = new Employee();
        employee.setPassword("test1");
        employee.setUsername("test1");
        employeeService.save(employee);
    }

    @Test
    public void del() {
        employeeService.del(5L);
    }
}