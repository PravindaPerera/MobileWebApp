package controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import services.phones;
import services.comments;

@WebServlet(name="login", urlPatterns= "/login")
public class LoginServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String uname = req.getParameter("un");
        String pword = req.getParameter("pw");
        Boolean user = false;

        dbConnection.dbConnection databaseCon = new dbConnection.dbConnection();
        try {
            user = databaseCon.checkLogin(uname, pword);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(user){
            req.setAttribute("profile_name", uname);
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


            req.getRequestDispatcher("/home.jsp").forward(req,resp);
        }
        else{
            resp.sendRedirect("http://localhost:8080");
        }

    }
}
