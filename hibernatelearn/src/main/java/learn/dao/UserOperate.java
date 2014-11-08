package learn.dao;

import learn.dto.User;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class UserOperate {

    private SessionFactory factory;

    public UserOperate(SessionFactory factory) {
        this.factory = factory;
    }

    public User getUser(Integer userId) {
        Session loadSession = factory.openSession();
        loadSession.beginTransaction();
        User user = (User) loadSession.get(User.class, userId);
        loadSession.close();
        return user;
    }

    public boolean delUser(Integer userId) {
        Session delSession = factory.openSession();
        try {
            Transaction tx = delSession.beginTransaction();
            delSession.delete(getUser(userId));
            tx.commit();
            delSession.close();
            return true;
        } catch (Exception e) {
            delSession.close();
            return false;
        }
    }

    public boolean insUser(User user) {
        Session insSession = factory.openSession();
        try {
            Transaction tx = insSession.beginTransaction();
            insSession.save(user);
            tx.commit();
            insSession.close();
            return true;
        } catch (Exception e) {
            insSession.close();
            return false;
        }
    }

    public boolean updUser(User user) {

        Session updSession = factory.openSession();
        try {
            Transaction tx = updSession.beginTransaction();
            updSession.update(user);
            tx.commit();
            updSession.close();
            return true;
        } catch (Exception e) {
            updSession.clear();
            return false;
        }
    }

}
