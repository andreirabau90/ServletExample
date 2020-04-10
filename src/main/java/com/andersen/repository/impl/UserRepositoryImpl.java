package com.andersen.repository.impl;

import com.andersen.entity.User;
import com.andersen.repository.CrudRepository;
import com.andersen.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import java.util.List;

public class UserRepositoryImpl implements CrudRepository<User> {
    private SessionFactory sessionFactory = HibernateUtil.sessionFactory;

    @Override
    public User get(long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(User.class, id);
        }
    }

    @Override
    public void saveOrUpdate(User user) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.saveOrUpdate(user);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(User user) {
        try (Session session = sessionFactory.openSession()) {
            session.getTransaction().begin();
            session.delete(user);
            session.getTransaction().commit();
        }
    }

    @Override
    public List<User> getAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM User ").list();
        }
    }

    public User getUserByEmailAndPassword(String email, String password) {
        try (Session session = sessionFactory.openSession()) {
            Query query = session.createQuery("FROM User u WHERE u.email=:email AND u.password=:password");
            query.setParameter("email", email);
            query.setParameter("password", password);
            if (!query.getResultList().isEmpty()) {
                return (User) query.getSingleResult();
            } else {
                return null;
            }
        }
    }

}
