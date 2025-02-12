package com.example.demo.domain.repository;


import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.demo.domain.entity.user;
import com.example.util.HibernateUtil;


public class PGUserRepository implements IUserRepository{
    
    public PGUserRepository(){}

    @Override
    public void addUser(user u) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.persist(u);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
    }

    @Override
    public void deleteUser(user u) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.remove(u);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
    }

    @Override
    public user getUser(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            user u  = session.get(user.class, id);
            return u;
        } catch (Exception e) {
        }

        return null;
    }

    @Override
    public void updateUser(user u) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.merge(u);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
    }


    
   
}
