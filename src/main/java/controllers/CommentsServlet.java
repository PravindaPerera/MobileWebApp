package controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name="comment", urlPatterns= "/comments")

public class CommentsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String phone_id = req.getParameter("phone_id");
        System.out.println(phone_id);
        req.getRequestDispatcher("/WEB-INF/views/test.jsp").forward(req,resp);
    }
}
