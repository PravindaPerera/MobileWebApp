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
        dbConnection.dbConnection databaseCon = new dbConnection.dbConnection();
        String search_type = req.getParameter("search_type");
        ArrayList<String> seacrh_res;

        try {
            seacrh_res = databaseCon.getSearchDetails(search_type);
            String json = new Gson().toJson(seacrh_res);
            req.setAttribute("response", json);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req,resp);
    }
}