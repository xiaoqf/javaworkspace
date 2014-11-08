package learn.main;

import learn.dao.UserOperate;
import learn.dto.User;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class testMain {

    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        Configuration config = new Configuration().configure();
        SessionFactory factory = config.buildSessionFactory();
        UserOperate operate = new UserOperate(factory);
        User user = new User();
        user.setUserName("xiaoqf123");
        user.setPassword("xiaoqf123");
        operate.insUser(user);
        user = operate.getUser(1);
        System.out.println(operate.getUser(1));
        user.setUserName("xiaoabc");
        operate.updUser(user);
        user = operate.getUser(1);
        System.out.println(operate.getUser(1));
        operate.delUser(1);
        user = operate.getUser(1);
        System.out.println(operate.getUser(1));
        // try {
        // // 加载MySql的驱动类
        // Class.forName("org.mariadb.jdbc.Driver");
        // String url = "jdbc:mysql://localhost:3306/learn";
        // String username = "root";
        // String password = "xiaoqf@lkg1988";
        // Connection con = DriverManager.getConnection(url, username, password);
        //
        // Statement stmt = con.createStatement();
        // ResultSet rs = stmt.executeQuery("select * from Users");
        // System.out.println(rs);
        // } catch (Exception e) {
        // e.printStackTrace();
        // }
    }

}
