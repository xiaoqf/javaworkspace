package dao;

import dto.User;

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
        Transaction tx = loadSession.beginTransaction();
        User user = (User) loadSession.get(User.class, userId);
        tx.commit();
        loadSession.close();
        return user;
    }
    
	public User getUser(String userName) {
		Session loadSession = factory.openSession();
		Transaction tx = loadSession.beginTransaction();
		User user = (User) loadSession
				.createQuery("from User as user where user.userName=?")
				.setString(0, userName).uniqueResult();
		tx.commit();
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
    
    public boolean delUser(String userName) {
        Session delSession = factory.openSession();
        try {
            Transaction tx = delSession.beginTransaction();
            delSession.delete(getUser(userName));
            delSession.flush();
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
            if (getUser(user.getUserName()) != null) {
            	return false;
            }
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
