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

import services.phones;

/**
 * Created by Pravinda Perera on 12/8/2016.
 */
@WebServlet(name = "FilterSearchServlet", urlPatterns= "/finalSearch")

public class FilterSearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("Filteration Search Servlet------------------ :)");
        dbConnection.dbConnection databaseCon = new dbConnection.dbConnection();
        String search_type = req.getParameter("search_type");
        String val = req.getParameter("results");
        System.out.println(search_type);
        //take this off------
        search_type = "Storage";
        //take this off------
        ArrayList<phones> seacrh_res;

        try {
            seacrh_res = databaseCon.getFinalSearchRes(search_type, val);
            String json = new Gson().toJson(seacrh_res);
            System.out.println(json);

            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write(json);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Filteration Search Servlet------------------ :)");
        dbConnection.dbConnection databaseCon = new dbConnection.dbConnection();
        String search_type = req.getParameter("search_type");
        String val = req.getParameter("results");
        System.out.println(search_type);
        //take this off------
        search_type = "Storage";
        //take this off------
        ArrayList<phones> seacrh_res;

        try {
            seacrh_res = databaseCon.getFinalSearchRes(search_type, val);
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
