package com.dylan.controllers;

import com.dylan.models.Employee;
import com.dylan.models.Request;
import com.dylan.repositories.EmployeeRepo;
import com.dylan.services.EmployeeServices;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EmployeeController implements FrontController{
    private ObjectMapper om = new ObjectMapper();
    EmployeeServices es = new EmployeeServices();

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String path = (String) request.getAttribute("path");

        System.out.println("Path attribute: " + path);

        //localhost:8080/dylan_p1/????



        int employeeId = Integer.parseInt(path);
        Employee e = null;



        switch (request.getMethod()) {

            case "GET": {
                e = es.getEmployeeById(employeeId);
                if(e != null){

                    response.getWriter().write(om.writeValueAsString(e));
                }else{

                    response.sendError(404, "employee not found");
                }

                break;
            }



//                case "PUT": {
//                    e = om.readValue(request.getReader(), Request.class);
//                    rs.updateRequest(r);
//                    break;
//                }
//
//                case "DELETE": {
//                    rs.deleteRequest(requestId);
//                    break;
//                }

            default: {
                response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);

                //say something like bad request or what makes sense for app
                break;
            }


        }
    }
}

