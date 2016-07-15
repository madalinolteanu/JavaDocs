package ro.teamnet.zth.appl.controller;

import ro.teamnet.zth.api.annotations.MyController;
import ro.teamnet.zth.api.annotations.MyRequestMethod;
import ro.teamnet.zth.api.annotations.MyRequestParam;
import ro.teamnet.zth.appl.dao.EmployeeDao;
import ro.teamnet.zth.appl.domain.Employee;
import ro.teamnet.zth.appl.service.EmployeeServiceImpl;

import java.util.List;

/**
 * Created by user on 7/14/2016.
 */
@MyController(urlPath = "/employees")
public class EmployeeController {
    //private final EmployeeDao employeeService = new EmployeeDao();
    @MyRequestMethod(urlPath = "/all")
    public List<Employee> getAllEmployees(){
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        return  employeeService.findallemployees();
    }
    @MyRequestMethod(urlPath = "/one")
    public Employee getOneEmployee(@MyRequestParam(name="id") Long id)  {
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        return employeeService.findOneEmployee(id);
    }
    @MyRequestMethod(urlPath = "/delete",methodType = "DELETE")
    public void deleteOneEmployee(@MyRequestParam(name="id") Long id){
        EmployeeDao employeeDao = new EmployeeDao();
        Employee employee = employeeDao.getEmployeeById(id);
        employeeDao.deleteEmployee(employee);
    }
}
