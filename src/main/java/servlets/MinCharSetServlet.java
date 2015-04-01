package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/MinCharSetServlet")
public class MinCharSetServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        String minValue = null;
        minValue = request.getParameter("minValue");

        if (isInteger(minValue)) {

            session.setAttribute("setMinTaskDone", true);
            session.setAttribute("minValMessage", "Minimum char in the word set as " + minValue);
            getServletContext().getRequestDispatcher("/mainPage.jsp").forward(request, response);
        } else {
            session.setAttribute("setMinTaskDone", false);
            session.setAttribute("minValMessage2", "You should set valid value, default value is 1" );
            getServletContext().getRequestDispatcher("/mainPage.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    private boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return Boolean.TRUE;
        } catch (NumberFormatException e) {
            return Boolean.FALSE;
        }
    }
}
