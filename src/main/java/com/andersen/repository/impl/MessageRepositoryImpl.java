package com.andersen.repository.impl;

import com.andersen.entity.Message;
import com.andersen.repository.CrudRepository;
import com.andersen.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class MessageRepositoryImpl implements CrudRepository<Message> {
    private SessionFactory sessionFactory = HibernateUtil.sessionFactory;

    @Override
    public Message get(long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Message.class, id);
        }
    }

    @Override
    public void saveOrUpdate(Message message) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.saveOrUpdate(message);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Message message) {
        try (Session session = sessionFactory.openSession()) {
            session.getTransaction().begin();
            session.delete(message);
            session.getTransaction().commit();
        }
    }

    @Override
    public List<Message> getAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Message m ORDER BY m.id DESC ").list();
        }
    }
}
