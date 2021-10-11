package com.dylan.services;


import com.dylan.models.Employee;
import com.dylan.models.Grade;
import com.dylan.repositories.EmployeeRepo;
import com.dylan.repositories.GradeRepo;

import java.util.List;

public class GradeServices {

    EmployeeRepo er = new EmployeeRepo();
    GradeRepo gr = new GradeRepo();

    public List<Grade> getGrades() {

        return gr.getAll();
    }


    public Grade getGradeById(Integer id) {return gr.getById(id);}
}
