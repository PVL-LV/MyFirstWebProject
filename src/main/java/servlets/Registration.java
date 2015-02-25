package servlets;

import model.DataBaseConnectionDAO;
import model.RegistrationDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Registration")
public class Registration extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String psw = request.getParameter("psw");
        String psw2 = request.getParameter("psw2");

        if(psw.equals(psw2)) {
            if (RegistrationDAO.registrationInDB(name, email, psw)) {
                request.setAttribute("username", name);
                RequestDispatcher view = request.getRequestDispatcher("/mainPage.jsp");
                view.forward(request, response);
            } else {
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/signUp.jsp");
                PrintWriter out = response.getWriter();
                out.println("<font color=red>name or password is wrong.</font>");
                rd.include(request, response);
            }
        }else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/signUp.jsp");
            PrintWriter out = response.getWriter();
            out.println("<font color=red> password is not the same.</font>");
            rd.include(request, response);
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
