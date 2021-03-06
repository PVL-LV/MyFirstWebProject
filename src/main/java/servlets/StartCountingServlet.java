package servlets;

import model.CheckMinVal;
import model.DataCollection;
import servlets.UploadServlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/StartCountingServlet")
public class StartCountingServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("counting servlet start");

        CheckMinVal.minValCheck();

        DataCollection.sendDataToCounter();

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/downloadResult.jsp");
        rd.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
