package controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet(name = "SignUpServlet", urlPatterns= "/signup")
public class SignUpServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uname = req.getParameter("un");
        String pword = req.getParameter("pw");
        Boolean user = false;

        dbConnection.dbConnection databaseCon = new dbConnection.dbConnection();
        try {
            user = databaseCon.SignUp(uname,pword);
            System.out.println(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("http://localhost:8080");

    }

}
