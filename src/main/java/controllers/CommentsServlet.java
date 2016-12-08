package controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name="CommentsServlet", urlPatterns= "/comments")

public class CommentsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String phone_id = req.getParameter("phone_id");
        String comment = req.getParameter("cmt");
        int id = Integer.parseInt(phone_id);

        dbConnection.dbConnection databaseCon = new dbConnection.dbConnection();
        try {
            databaseCon.postComment(id, comment);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        resp.sendRedirect("http://localhost:8080/login");
    }
}
