package servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import dao.UserOperate;
import dto.User;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        Enumeration<String> parameters = request.getParameterNames();
        
        System.out.println("parameters:");
        while(parameters.hasMoreElements()) {
            String parameter = parameters.nextElement();
            System.out.println(parameter + " = " + request.getParameter(parameter));
        }
        System.out.println("end");
        
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        
        System.out.println(userName);
        System.out.println(password);
        
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        
        Configuration config = new Configuration().configure();
        ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        SessionFactory factory = config.buildSessionFactory(registry);
        UserOperate operate = new UserOperate(factory);
        if (operate.insUser(user)) {
            response.sendRedirect("res_success.html");
        } else {
            request.setAttribute("errMessage", "用户名已存在。");
            request.getRequestDispatcher("/register.html").forward(request, response);
        }
    }

}
