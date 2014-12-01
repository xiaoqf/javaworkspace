package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ThreadSafeServlet
 */
@WebServlet("/threadsafe")
public class ThreadSafeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    int number = 0;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThreadSafeServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws  ServletException, IOException {
        doPost(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");
        synchronized (this) {
            number++;
            out.println("<p>您是第" + number + "个访问该网页的用户!</p>");
        }
        out.println("</html>");
        out.println("</body>");
    }

}
