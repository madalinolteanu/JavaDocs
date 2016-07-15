package ro.teamnet.zth.appl.service;

import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.appl.controller.EmployeeController;
import ro.teamnet.zth.appl.domain.Employee;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 7/15/2016.
 */
public interface EmployeeService {
    List<Employee> findallemployees();
    Employee findOneEmployee(Long Id);
}
