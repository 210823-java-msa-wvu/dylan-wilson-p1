package com.dylan.repositories;

import com.dylan.models.Employee;
import com.dylan.models.Request;
import com.dylan.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
//implements CrudRepository
public class RequestRepo {
    //@Override
    public Request add(Request r) {
        Session s = HibernateUtil.getSession();
        Transaction tx = null;

        try{
            tx = s.beginTransaction();
            s.save(r);
            tx.commit();


        }catch (HibernateException e){
            e.printStackTrace();

            if(tx != null) tx.rollback();
        }finally {
            s.close();
        }



        return r;
    }

    // @Override
    public Request getById(Integer id) {
        Session s = HibernateUtil.getSession();

        Request r = s.get(Request.class, id);

        s.close();


        return r;
    }

    // @Override
    public List<Request> getAll() {
        Session s = HibernateUtil.getSession();
        //Create a query object
        String query = "from Request"; //this is HQL //
        Query<Request> q = s.createQuery(query, Request.class);

        List<Request> requests = q.getResultList();

        s.close();

        return requests;
    }


    public List<Request> getAllById(Integer id) {

        Session s = HibernateUtil.getSession();
        //Create a query object
        String query = "from Request R where R.employee_id =" + id; //this is HQL //
        Query<Request> q = s.createQuery(query, Request.class);

        List<Request> allRequests = q.getResultList();

        s.close();

        return allRequests;


    }





















    //@Override????????
    public void update(Request r) {
        Transaction tx = null;
        try(Session s = HibernateUtil.getSession()){
            tx = s.beginTransaction();
            s.update(r);
            tx.commit();
        }catch (HibernateException ex){
            ex.printStackTrace();
            if(tx != null) tx.rollback();


        }
    }

    //@Override
    public void delete(Integer id) {
        Transaction tx = null;

        try(Session s = HibernateUtil.getSession()){

            tx = s.beginTransaction();

            s.delete(id);
            tx.commit();

        }catch (HibernateException e ){

            e.printStackTrace();
            if(tx != null) tx.rollback();
        }

    }
}
