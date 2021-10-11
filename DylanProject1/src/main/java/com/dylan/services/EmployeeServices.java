package com.dylan.services;

import com.dylan.models.Employee;
import com.dylan.repositories.EmployeeRepo;

public class EmployeeServices {

    EmployeeRepo er = new EmployeeRepo();
    public Employee getEmployeeById (Integer id) {return er.getById(id);}


    public boolean login(String username, String password) {


        Employee e = er.getByUsername(username);


        if (e != null) {

            if(username.equals(e.getUsername()) && password.equals(e.getPassword())) {


                return true;
            }
        }
        return false;
    }

    public Employee getEmployeeByUsername (String username) {return er.getByUsername(username);}



}