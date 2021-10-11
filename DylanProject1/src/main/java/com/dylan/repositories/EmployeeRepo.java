package com.dylan.repositories;

import com.dylan.utils.HibernateUtil;
import com.dylan.models.Employee;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class EmployeeRepo  {

    public Employee getByUsername(String username) {
        Session s = HibernateUtil.getSession();
        Employee e = null;

        try{

            CriteriaBuilder cb = s.getCriteriaBuilder();

            CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);

            Root<Employee> r = cq.from(Employee.class);

            Predicate p = cb.equal(r.get("username"), username);

            cq.select(r).where(p);

            e = s.createQuery(cq).getSingleResult();
            System.out.println(e);
        }catch (HibernateException | NoResultException ex){
            System.out.println("result was found but NoResultException thrown for... reasons");
           // ex.printStackTrace();
        }finally {
            s.close();
        }

        return e;

    }

    public Employee add(Employee e) {
        //Transaction Interface
        Session s = HibernateUtil.getSession();

        Transaction tx = null;

        try{
            tx = s.beginTransaction();
            s.save(e);
            tx.commit();


        }catch(HibernateException ex){

            ex.printStackTrace();

            if(tx != null) tx.rollback();


        }finally {
            s.close();
        }

        return e;
    }


    public Employee getById(Integer id) {
        //Get session
        Session s = HibernateUtil.getSession();

        Employee e = s.get(Employee.class, id);

        s.close();


        return e;
    }


    public List<Employee> getAll() {
        //Query Object
        Session s = HibernateUtil.getSession();
        //Create a query object
        String query = "from Employee"; //this is HQL
        Query<Employee> q = s.createQuery(query, Employee.class);

        List<Employee> employees = q.getResultList();

        s.close();

        return employees;
    }


    public void update(Employee e) {

        Transaction tx = null;
        try(Session s = HibernateUtil.getSession()){
            tx = s.beginTransaction();
            s.update(e);
            tx.commit();
        }catch (HibernateException ex){
            ex.printStackTrace();
            if(tx != null) tx.rollback();


        }


    }


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
