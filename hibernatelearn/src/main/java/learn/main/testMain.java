package learn.main;


import learn.dao.UserOperate;
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
        operate.delUser("xiaoabc");
        System.out.println(operate.getUser("xiaoabc"));
        factory.close();
    }

}
