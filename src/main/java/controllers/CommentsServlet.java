package controllers;

import com.google.gson.Gson;
import services.phones;

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

        ArrayList<phones> seacrh_res;

        try {
            seacrh_res = databaseCon.postComment(id, comment);
            String json = new Gson().toJson(seacrh_res);
            System.out.println(json);

            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write(json);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
