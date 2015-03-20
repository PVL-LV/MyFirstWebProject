package servlets;

import model.DataBaseConnectionDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Login")
public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String pass = request.getParameter("pass");

        if (DataBaseConnectionDAO.validate(username, pass)) {

            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            Cookie userName = new Cookie("username", username);
            response.addCookie(userName);
            response.sendRedirect("/mainPage.jsp");

            //request.setAttribute("username", username);
           // RequestDispatcher view = request.getRequestDispatcher("/mainPage.jsp");
           // view.forward(request, response);
        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
            PrintWriter out= response.getWriter();
            out.println("<font color=red>Either user name or password is wrong.</font>");
            rd.include(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
