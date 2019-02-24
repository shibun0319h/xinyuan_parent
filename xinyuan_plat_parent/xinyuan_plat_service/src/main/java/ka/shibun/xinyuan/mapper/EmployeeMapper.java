package ka.shibun.xinyuan.mapper;

import ka.shibun.xinyuan.domain.Employee;
import ka.shibun.xinyuan.query.EmployeeQuery;

import java.util.List;

public interface EmployeeMapper {

    Employee getById(Long id);

    List<Employee> loadByQuery(EmployeeQuery employeequery);

    void save(Employee employee);

    void del(Long id);
}
