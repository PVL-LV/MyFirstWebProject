package servlets;

import model.DataCollection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@WebServlet("/MinCharSetServlet")
public class MinCharSetServlet extends HttpServlet {

    final Logger logger = LogManager.getLogger(MinCharSetServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();


        String minValue = null;
        minValue = request.getParameter("minValue");

        if (isInteger(minValue)) {
            //send minValue to args array
            DataCollection.args[1] = ("minValue=" + minValue);

            logger.debug("this is loger debug");

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
