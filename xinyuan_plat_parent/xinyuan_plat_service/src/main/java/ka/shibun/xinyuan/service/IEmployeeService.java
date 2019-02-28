package ka.shibun.xinyuan.service;

import com.baomidou.mybatisplus.service.IService;
import ka.shibun.xinyuan.domain.Employee;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author shibun
 * @since 2019-02-26
 */
public interface IEmployeeService extends IService<Employee> {
    //登陆
    Employee login(Employee employee);
}
