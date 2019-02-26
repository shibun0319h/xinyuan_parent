package ka.shibun.xinyuan.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import ka.shibun.xinyuan.domain.Employee;
import ka.shibun.xinyuan.service.IEmployeeService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

import static org.junit.Assert.*;


public class EmployeeServiceImplTest extends BaseServiceImpl{

    @Autowired
    private IEmployeeService employeeService;

    //测试数据库连接以及分页
    @Test
    public void testFind() throws Exception{
        //查询单个
        Employee employee = employeeService.selectById(1L);
        //模糊查询
        Wrapper<Employee> wrapper = new EntityWrapper<>();
        wrapper.like("username","demo");
        List<Employee> employees = employeeService.selectList(wrapper);
        //分页查询
        Page<Employee> page = new Page<>();
        //每页数据以及开始数据
        page.setSize(2);
        page.setCurrent(1);
        Page<Employee> employeePage = employeeService.selectPage(page);
    }
    //测试登陆
    @Test
    public void testLogin() throws Exception{
        Employee employee = new Employee();
        employee.setPassword("admin");
        employee.setUsername("admin");
        Employee login = employeeService.login(employee);
    }
}