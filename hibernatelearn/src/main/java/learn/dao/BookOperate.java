package learn.dao;

import learn.dto.Book;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class BookOperate {

    private SessionFactory factory;

    public BookOperate(SessionFactory factory) {
        this.factory = factory;
    }

    public Book getBook(Integer bookId) {
        Session loadSession = factory.openSession();
        Transaction tx = loadSession.beginTransaction();
        Book book = (Book) loadSession.get(Book.class, bookId);
        tx.commit();
        loadSession.close();
        return book;
    }
    
	public Book getBook(String bookName) {
		Session loadSession = factory.openSession();
		Transaction tx = loadSession.beginTransaction();
		Book book = (Book) loadSession
				.createQuery("from Book as book where book.bookName=?")
				.setString(0, bookName).uniqueResult();
		tx.commit();
		loadSession.close();
		return book;
	}

    public boolean delBook(Integer bookId) {
        Session delSession = factory.openSession();
        try {
            Transaction tx = delSession.beginTransaction();
            delSession.delete(getBook(bookId));
            tx.commit();
            delSession.close();
            return true;
        } catch (Exception e) {
            delSession.close();
            return false;
        }
    }
    
    public boolean delBook(String bookName) {
        Session delSession = factory.openSession();
        try {
            Transaction tx = delSession.beginTransaction();
            delSession.delete(getBook(bookName));
            delSession.flush();
            tx.commit();
            delSession.close();
            return true;
        } catch (Exception e) {
            delSession.close();
            return false;
        }
    }

    public boolean insBook(Book book) {
        Session insSession = factory.openSession();
        try {
            Transaction tx = insSession.beginTransaction();
            if (getBook(book.getBookName()) != null) {
            	return false;
            }
            insSession.save(book);
            tx.commit();
            insSession.close();
            return true;
        } catch (Exception e) {
            insSession.close();
            return false;
        }
    }

    public boolean updBook(Book book) {

        Session updSession = factory.openSession();
        try {
            Transaction tx = updSession.beginTransaction();
            updSession.update(book);
            tx.commit();
            updSession.close();
            return true;
        } catch (Exception e) {
            updSession.clear();
            return false;
        }
    }

}
