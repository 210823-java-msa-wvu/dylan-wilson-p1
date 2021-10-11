package com.dylan.controllers;

import com.dylan.models.Employee;
import com.dylan.services.EmployeeServices;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import com.sun.istack.NotNull;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class LoginController implements FrontController{
    private Logger log = LogManager.getLogger(LoginController.class);
    private EmployeeServices es = new EmployeeServices();



    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("inside login controller");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("Username: " + username + " Password: " + password);




        if(es.login(username, password)) {
            Employee e = es.getEmployeeByUsername(username);

//            HttpSession session = request.getSession();
//            String currentEmployee = (String) session.getAttribute("username");
//            session.setAttribute("username", e.getUsername());


            Integer employeeId = e.getEmp_id();
//            String first_name = e.getFirst_name();
//            String last_name = e.getLast_name();
            String title = e.getTitle();


            System.out.println("inside login if statement");

//            String name = "emp_id";
//            String value = String.valueOf(employeeId);
//            Cookie cookie = new Cookie(name, value);
//            response.addCookie(cookie);
//            log.trace(cookie);
//
//           String eTitle = "title";
//           String position = String.valueOf(title);
//           Cookie cookie2 = new Cookie(eTitle, position);
//           response.addCookie(cookie2);


            response.sendRedirect("static/home.html");

        }else{
            response.sendRedirect("static/index.html");
            //response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid Login Credentials");



        }




    }
}