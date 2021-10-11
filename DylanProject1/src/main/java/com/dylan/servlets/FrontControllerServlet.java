package com.dylan.servlets;

import com.dylan.controllers.FrontController;
import org.apache.catalina.servlets.DefaultServlet;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FrontControllerServlet extends DefaultServlet {
    private Logger log = LogManager.getLogger(FrontControllerServlet.class);
    private RequestHandler rh = new RequestHandler();




    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uriNoContext = request.getRequestURI().substring(request.getContextPath().length());
        log.trace(uriNoContext);
//******************************check  here*************************
        if(uriNoContext.startsWith("/static")) {
            log.trace("Accessing static resources and trying to forward...");
            super.doGet(request, response);

        }else {
            // 'get' the correct servlet based on the uri
            log.trace("Not static...Getting the appropriate controller...");
            FrontController fc = rh.handle(request, response);


            if (fc != null) {
                log.trace("Processing request...");
                fc.process(request, response);
            } else {

                log.trace("no go");
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
            }
        }

    }



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        process(request, response);




    }
    // TODO: 10/6/2021 may not need*****
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        process(request, response);

    }
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        process(request, response);

    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        process(request, response);
    }
}