package ka.shibun.xinyuan.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import ka.shibun.xinyuan.domain.Employee;
import ka.shibun.xinyuan.mapper.EmployeeMapper;
import ka.shibun.xinyuan.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author shibun
 * @since 2019-02-26
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public Employee login(Employee employee) {

        return employeeMapper.login(employee);
    }
}
