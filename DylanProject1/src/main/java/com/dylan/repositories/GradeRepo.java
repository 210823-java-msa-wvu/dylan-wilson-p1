package com.dylan.repositories;

import com.dylan.models.Grade;
import com.dylan.models.Request;
import com.dylan.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class GradeRepo {

   public  List<Grade> getAll(){
        Session s = HibernateUtil.getSession();

        String query = "from grades";
        Query<Grade> q= s.createQuery(query, Grade.class);

        List<Grade> grades = q.getResultList();

        s.close();

        return grades;

    }

    public Grade getById(Integer id) {
       Session s = HibernateUtil.getSession();

        Grade g = s.get(Grade.class, id);

        s.close();


        return g;

    }
}
