package controllers;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name="filter", urlPatterns= "/selectSearchType")

public class FilterServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Filteration ------------------ :)");
        dbConnection.dbConnection databaseCon = new dbConnection.dbConnection();
        String search_type = req.getParameter("search_type");

        ArrayList<String> seacrh_res;

        try {
            seacrh_res = databaseCon.getSearchDetails(search_type);
            String json = new Gson().toJson(seacrh_res);
            System.out.println(json);

            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write(json);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        //req.getRequestDispatcher("/home.jsp").forward(req,resp);
    }
}
