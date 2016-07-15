package ro.teamnet.zth.appl.service;

import ro.teamnet.zth.api.annotations.MyRequestMethod;
import ro.teamnet.zth.api.em.EntityManagerImpl;
import ro.teamnet.zth.appl.dao.EmployeeDao;
import ro.teamnet.zth.appl.domain.Employee;

import java.util.List;

/**
 * Created by user on 7/15/2016.
 */
public class EmployeeServiceImpl implements EmployeeService {

    @Override
    public List<Employee> findallemployees() {
        EmployeeDao entityDao = new EmployeeDao();
        return entityDao.getAllEmployees();
    }

    @Override
    public Employee findOneEmployee( Long id) {
        EmployeeDao employeeDao = new EmployeeDao();
        return employeeDao.getEmployeeById(id);
    }
}
