package com.dylan.repositories;

import com.dylan.models.AccountBalance;
import com.dylan.models.Employee;
import com.dylan.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class AccountBalanceRepo {

    public AccountBalance add(AccountBalance ab) {
        Session s = HibernateUtil.getSession();

        Transaction tx = null;

        try{
            tx = s.beginTransaction();
            s.save(ab);
            tx.commit();


        }catch(HibernateException ex){

            ex.printStackTrace();

            if(tx != null) tx.rollback();


        }finally {
            s.close();
        }

        return ab;
    }


    public AccountBalance getById(Integer id) {

        Session s = HibernateUtil.getSession();

        AccountBalance ab = s.get(AccountBalance.class, id);

        s.close();


        return ab;
    }


    public List<AccountBalance> getAll() {
        Session s = HibernateUtil.getSession();
        //Create a query object
        String query = "from account_balance"; //this is HQL
        Query<AccountBalance> q = s.createQuery(query, AccountBalance.class);

        List<AccountBalance> account_balance = q.getResultList();

        s.close();

        return account_balance;
    }


    public void update(AccountBalance ab) {
        Transaction tx = null;
        try(Session s = HibernateUtil.getSession()){
            tx = s.beginTransaction();
            s.update(ab);
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
