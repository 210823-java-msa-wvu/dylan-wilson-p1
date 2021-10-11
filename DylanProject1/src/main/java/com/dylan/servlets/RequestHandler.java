package com.dylan.servlets;

import com.dylan.controllers.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RequestHandler {
    //this map holds different controllers we will create
    private Logger log = LogManager.getLogger(RequestHandler.class);
    private Map<String, FrontController> controllerMap;
    {
        controllerMap = new HashMap<String, FrontController>();

        //controllers for models go under here
        controllerMap.put("employees", new EmployeeController());
        controllerMap.put("requests", new RequestController());  // TODO: 10/6/2021 make sure this is correct
        controllerMap.put("account_balance", new AccountBalanceController());
        controllerMap.put("login", new LoginController());
        controllerMap.put("grades", new GradeController());
    }
    public FrontController handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        StringBuilder uriString = new StringBuilder(request.getRequestURI()); //uri = /dylanp1/???

        uriString.replace(0,request.getContextPath().length() + 1, "");
       System.out.println(uriString);


        if (uriString.indexOf("html") != -1){

            request.setAttribute("static", uriString.toString());
            System.out.println(uriString);
            return controllerMap.get(uriString.toString());

        }

        if(uriString.indexOf("/") != -1) {

            request.setAttribute("path",uriString.substring(uriString.indexOf("/") + 1));

            uriString.replace(uriString.indexOf("/"), uriString.length() + 1, "");

        }

        return controllerMap.get(uriString.toString());
    }



}
