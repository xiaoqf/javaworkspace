package learn.main;

import learn.dao.BookOperate;
import learn.dao.UserOperate;
import learn.dto.Book;
import learn.dto.User;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class testMain {

	public static void main(String[] args) {
        Configuration config = new Configuration().configure();
        ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        SessionFactory factory = config.buildSessionFactory(registry);
        UserOperate operate = new UserOperate(factory);
        User user = new User();
        user.setUserName("xiaoqf123");
        user.setPassword("xiaoqf123");
        operate.insUser(user);
        user = operate.getUser("xiaoqf123");
        System.out.println(user);
        user.setUserName("xiaoabc");
        operate.updUser(user);
        System.out.println(operate.getUser("xiaoabc"));
//        operate.delUser("xiaoabc");
//        System.out.println(operate.getUser("xiaoabc"));

        BookOperate bookOperate = new BookOperate(factory);
        Book book = new Book();
        book.setBookName("xiaoBook123");
        book.setAuther("xiaoqf");
        bookOperate.insBook(book);
        book = bookOperate.getBook("xiaoBook123");
        System.out.println(book);
        book.setBookName("xiaoabc");
        bookOperate.updBook(book);
        System.out.println(bookOperate.getBook("xiaoabc"));
//        bookOperate.delBook("xiaoabc");
//        System.out.println(bookOperate.getBook("xiaoabc"));
        factory.close();
    }

}
