package ro.teamnet.zth.web;

import ro.teamnet.zth.api.annotations.MyController;
import ro.teamnet.zth.api.annotations.MyRequestMethod;
import ro.teamnet.zth.appl.controller.DepartmentController;
import ro.teamnet.zth.appl.controller.EmployeeController;
import ro.teamnet.zth.appl.domain.Department;
import ro.teamnet.zth.fmk.AnnotationScanUtils;
import ro.teamnet.zth.fmk.MethodAttributes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by user on 7/14/2016.
 */
public class DispatcherServlet extends HttpServlet {
    //ROL de Registru
    // KEY : urlPAth
    //VAL : info despre metoda care proceseaza url-ul
    HashMap<String, MethodAttributes> allowedMethods = new HashMap<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //instructiuni de delegare
        dispatchReply("GET",req,resp);
        //super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //instructiuni de delegare
        //super.doPost(req, resp);
        dispatchReply("POST",req,resp);
    }

    @Override
    public void init() throws ServletException {
        try {
            /*Cautam clase din pachet*/
            Iterable <Class> classes = AnnotationScanUtils.getClasses("ro.teamnet.zth.appl.controller");
            for(Class controller : classes){
                if(controller.isAnnotationPresent(MyController.class)){
                    MyController controlerAnnotation =
                            (MyController) controller.getAnnotation(MyController.class);
                    String controllerUrlPath = controlerAnnotation.urlPath();
                    Method[] controllerMethods = controller.getMethods();
                    for(Method controllerMethod : controllerMethods){
                        if(controllerMethod.isAnnotationPresent(MyRequestMethod.class)){
                            MyRequestMethod controllerRequestMethod =
                                    controllerMethod.getAnnotation(MyRequestMethod.class);
                            String controllerMethodUrlPath = controllerRequestMethod.urlPath();
                            // construies keya pentru HashMap
                            String key = controllerUrlPath + controllerMethodUrlPath;

                            MethodAttributes methodAtributes = new MethodAttributes();
                            methodAtributes.setControllerClass(controller.getName());
                            methodAtributes.setMethodType(controllerRequestMethod.methodType());
                            methodAtributes.setMethodName(controllerMethod.getName());

                            allowedMethods.put(key,methodAtributes);
                        }
                    }
                }
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    protected void dispatchReply(String get, HttpServletRequest req, HttpServletResponse resp){
        Object r = null;
        try{
             r = dispatch(req,resp);

        }catch (Exception e){
            sendExceptionError(e,req,resp);
        }
        try {
            replay(r,req,resp);
        } catch (IOException e) {
            sendExceptionError(e,req,resp);
            e.printStackTrace();
        }
    }
    protected Object dispatch(HttpServletRequest req, HttpServletResponse resp){
        String path = req.getPathInfo();
        MethodAttributes methodAttributes = allowedMethods.get(path);
        if(methodAttributes == null){
            /*Nu putem procesa URL*/
            return " PROCESAM URL !!!";
        }

//        EmployeeController controller = new EmployeeController();
//        String allEmplloyee = controller.getAllEmployees();
//        return allEmplloyee;
        String controllerName = methodAttributes.getControllerClass();
        try {
            Class<?> className = Class.forName(controllerName);
            Object controllerInstance = className.newInstance();
            Method method = className.
                    getMethod(methodAttributes.getMethodName());
            Object result =  method.invoke(controllerInstance);
            return result;


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return "You shall not pass!!!";
    }
    protected void replay(Object r, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter out = resp.getWriter();
        out.printf(String.valueOf(allowedMethods.toString()));
    }
    private void sendExceptionError(Exception e, HttpServletRequest req, HttpServletResponse resp) {

    }


}
