package com.dylan.services;

import com.dylan.models.Employee;
import com.dylan.models.Request;
import com.dylan.repositories.EmployeeRepo;
import com.dylan.repositories.RequestRepo;

import java.util.List;

public class RequestServices {
    EmployeeRepo er = new EmployeeRepo();

    RequestRepo rr = new RequestRepo();

    public List<Request> getRequests() {

        return rr.getAll();
    }

    public Request createRequest(Request r){

        //Employee e = er.getById(r.getEmployee_id());
        String id = null;
        Employee e = new Employee(id);
        if(e != null){

            return rr.add(r);
        }else{

            System.out.println("no request created");
            return null;    //might need to change, might not need else
        }
    }

    public List<Request> getRequestsById(Integer id) {
      Employee e = new Employee(id);
      id = e.getEmp_id();




        return rr.getAllById(id);}






    // TODO: 10/8/2021 put back or fix below update method*********************

//    public void updateRequest(Request r){
//
//        if(rr.getById(r.getEmployee_id()) != null){
//            rr.update(r);
//
//        }else {
//
//            System.out.println("Request not found.");
//        }
//
//    }

    public void deleteRequest(Integer id) {
        if(rr.getById(id) != null)
            rr.delete(id);
        else System.out.println("Request not found.");
    }
}