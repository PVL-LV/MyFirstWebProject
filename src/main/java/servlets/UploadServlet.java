package servlets;

import model.DataCollection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;

@WebServlet("/UploadServlet")
@MultipartConfig()
public class UploadServlet extends HttpServlet {

    private static final long serialVersionUID = 205242440643911308L;

    private static final String UPLOAD_DIR = "uploads";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // gets absolute path of the web application
        String applicationPath = request.getServletContext().getRealPath("");
        System.out.println(applicationPath);
        // constructs path of the directory to save uploaded file
        String uploadFilePath = applicationPath + File.separator + UPLOAD_DIR;

        System.out.println(uploadFilePath);

        // creates the save directory if it does not exists
        File fileSaveDir = new File(uploadFilePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdirs();
        }

        System.out.println("Upload File Directory="+fileSaveDir.getAbsolutePath());

        String fileName = null;
        //Get all the parts from request and write it to the file on server
        for (Part part : request.getParts()) {
            fileName = getFileName(part);
            part.write(uploadFilePath + File.separator + fileName);
        }

        //add input path
        DataCollection.args[0] = ("inputPath=" + fileSaveDir.getAbsolutePath() +"/" + fileName);

        //add output path
        DataCollection.args[2] = ("outputPath=" + uploadFilePath + "/output.txt");
        System.out.println("outputPath = " + uploadFilePath);


        HttpSession session = request.getSession();

        session.setAttribute("taskDone", true);
        session.setAttribute("message", fileName + " File uploaded successfully!");
        session.setAttribute("uploadFilePath", uploadFilePath);

        getServletContext().getRequestDispatcher("/mainPage.jsp").forward(request, response);
    }


    //Utility method to get file name from HTTP header content-disposition
    private String getFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");

        System.out.println("content-disposition header= "+contentDisp);

        String[] tokens = contentDisp.split(";");
        for (String token : tokens) {
            if (token.trim().startsWith("filename")) {
                return token.substring(token.indexOf("=") + 2, token.length()-1);
            }
        }
        return "";
    }




    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
