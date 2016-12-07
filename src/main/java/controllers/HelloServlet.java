package controllers;

import services.phones;
import services.comments;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name="hello", urlPatterns= "")
public class HelloServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        dbConnection.dbConnection databaseCon = new dbConnection.dbConnection();
        try {

            phones[] phoneDetails = databaseCon.getData();
            ArrayList<phones> phoneList = new ArrayList<phones>();
            for(int i=0; i<phoneDetails.length; i++){
                phoneList.add(phoneDetails[i]);

            }

            comments[] commentDetails = databaseCon.getComments();
            ArrayList<comments> commentList = new ArrayList<comments>();
            for(int i=0; i<commentDetails.length; i++){
                commentList.add(commentDetails[i]);
            }

            req.setAttribute("phone_details", phoneList);
            req.setAttribute("comment_details", commentList);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        req.getRequestDispatcher("/main.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        dbConnection.dbConnection databaseCon = new dbConnection.dbConnection();
        try {

            phones[] phoneDetails = databaseCon.getData();
            ArrayList<phones> phoneList = new ArrayList<phones>();
            for(int i=0; i<phoneDetails.length; i++){
                phoneList.add(phoneDetails[i]);

            }

            comments[] commentDetails = databaseCon.getComments();
            ArrayList<comments> commentList = new ArrayList<comments>();
            for(int i=0; i<commentDetails.length; i++){
                commentList.add(commentDetails[i]);
            }

            req.setAttribute("phone_details", phoneList);
            req.setAttribute("comment_details", commentList);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        req.getRequestDispatcher("/main.jsp").forward(req,resp);
    }
}


