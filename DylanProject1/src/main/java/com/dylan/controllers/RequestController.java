package com.dylan.controllers;

import com.dylan.models.Request;
import com.dylan.repositories.RequestRepo;
import com.dylan.services.RequestServices;
import com.dylan.servlets.FrontControllerServlet;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RequestController implements FrontController{
    private RequestServices rs = new RequestServices();
    RequestRepo rr = new RequestRepo();
    private ObjectMapper om = new ObjectMapper();
    private Logger log = LogManager.getLogger(RequestController.class);
    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String path = (String) request.getAttribute("path");
            log.trace("Path attribute: " + path);
        System.out.println("Path attribute: " + path);

        if(path == null || path.equals("")) {//localhost:8080/dylan_p1/requests

            switch (request.getMethod()) {

                case "GET": {
                    System.out.println("Getting all requests from the database...");
                    response.getWriter().write(om.writeValueAsString(rs.getRequests()));



                    break;
                }

                case "POST": {
                    Request r = om.readValue(request.getReader(), Request.class);
                    rs.createRequest(r);
                    System.out.println("Creating new request hopefully");


                    break;
                }


            }


        }else {

            int requestId = Integer.parseInt(path);
            Request r = null;



            switch (request.getMethod()) {

                case "GET": {
                    response.getWriter().write(om.writeValueAsString(rs.getRequestsById(requestId)));
                   // r = rs.getRequestsById(requestId);

                   // response.sendError(404, "Request not found");

                    break;
                }

                case "POST": {
                    r = om.readValue(request.getReader(), Request.class);
                    rs.createRequest(r);
                    System.out.println("else post method");


                    break;

                }

                case "PUT": {
                    r = om.readValue(request.getReader(), Request.class);
                    // TODO: 10/8/2021 put back or fix ********** -------> rs.updateRequest(r);
                    break;
                }

                case "DELETE": {
                    rs.deleteRequest(requestId);
                    break;
                }

                default: {
                    response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);

                    //say something like bad request or what makes sense for app
                    break;
                }


            }
        }
    }
}