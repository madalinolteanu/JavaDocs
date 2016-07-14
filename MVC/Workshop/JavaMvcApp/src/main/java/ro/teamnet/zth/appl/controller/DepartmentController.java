package ro.teamnet.zth.appl.controller;

/**
 * Created by user on 7/14/2016.
 */

import ro.teamnet.zth.api.annotations.MyController;
import ro.teamnet.zth.api.annotations.MyRequestMethod;

@MyController(urlPath = "/departments")
public class DepartmentController {
    @MyRequestMethod(urlPath = "/all")
    public String getAllDepartments(){

        return  "allDepartments";
    }
}
