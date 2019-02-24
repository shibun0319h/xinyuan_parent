/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: IEmployeeService
 * Author:   shibun
 * Date:     2019/2/23 20:21
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package ka.shibun.xinyuan.service;

import ka.shibun.xinyuan.domain.Employee;
import ka.shibun.xinyuan.query.EmployeeQuery;

import java.util.List;

/**
 *
 *
 *
 * @author shibun
 * @create 2019/2/23
 * @since 1.0.0
 */
public interface IEmployeeService {

    Employee getById(Long id);

    List<Employee> loadByQuery(EmployeeQuery employeequery);

    void save(Employee employee);

    void del(Long id);
}