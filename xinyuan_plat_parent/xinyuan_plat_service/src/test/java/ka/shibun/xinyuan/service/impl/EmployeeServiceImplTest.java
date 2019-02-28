package ka.shibun.xinyuan.service.impl;

import ka.shibun.xinyuan.domain.Employee;
import ka.shibun.xinyuan.service.IEmployeeService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.ws.Action;

import static org.junit.Assert.*;

public class EmployeeServiceImplTest extends BaseServiceImplTest{

    @Autowired
    private IEmployeeService employeeService;

    @Test
    public void login() {
        Employee employee = new Employee();
        employee.setUsername("admin");
        employee.setPassword("admin");
        Employee login = employeeService.login(employee);
    }
}