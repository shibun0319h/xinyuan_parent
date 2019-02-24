/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: EmployeeService
 * Author:   shibun
 * Date:     2019/2/23 20:22
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package ka.shibun.xinyuan.service.impl;

import ka.shibun.xinyuan.domain.Employee;
import ka.shibun.xinyuan.mapper.EmployeeMapper;
import ka.shibun.xinyuan.query.EmployeeQuery;
import ka.shibun.xinyuan.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 *
 *
 * @author shibun
 * @create 2019/2/23
 * @since 1.0.0
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class EmployeeService implements IEmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public Employee getById(Long id) {
        return employeeMapper.getById(id);
    }

    @Override
    public List<Employee> loadByQuery(EmployeeQuery employeequery) {
        return employeeMapper.loadByQuery(employeequery);
    }

    @Override
    public void save(Employee employee) {
        employeeMapper.save(employee);
    }

    @Override
    public void del(Long id) {
        employeeMapper.del(id);
    }
}