package ro.teamnet.zth.appl.controller;

/**
 * Created by user on 7/14/2016.
 */

import ro.teamnet.zth.api.annotations.MyController;
import ro.teamnet.zth.api.annotations.MyRequestMethod;
import ro.teamnet.zth.appl.domain.Department;
import ro.teamnet.zth.appl.service.impl.DepartmentServiceImpl;

import java.util.List;

@MyController(urlPath = "/departments")
public class DepartmentController {
    @MyRequestMethod(urlPath = "/all")
    public List<Department> getAllDepartments(){
        DepartmentServiceImpl departmentService = new DepartmentServiceImpl();

        return  departmentService.findalldepartments();
    }
}
