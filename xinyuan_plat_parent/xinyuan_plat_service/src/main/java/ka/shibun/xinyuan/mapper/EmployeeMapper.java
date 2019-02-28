package ka.shibun.xinyuan.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import ka.shibun.xinyuan.domain.Employee;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author shibun
 * @since 2019-02-26
 */
public interface EmployeeMapper extends BaseMapper<Employee> {

    //登陆
    Employee login(Employee employee);
}
