package dao;

import models.Users;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public Users findId(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Users.class, id);
    }

    @Override
    public void save(Users users) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(users);
        tx.commit();
        session.close();

    }

    @Override
    public void update(Users users) {
        Session session =HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(users);
        tx.commit();
        session.close();

    }

    @Override
    public void delete(Users users) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(users);
        tx.commit();
        session.close();

    }

    @Override
    public List<Users> findAllUsers() {
        List<Users> users = (List<Users>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Users").list();
        return users;
    }
}
