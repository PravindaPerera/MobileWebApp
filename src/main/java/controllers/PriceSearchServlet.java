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

/**
 * Created by Pravinda Perera on 12/9/2016.
 */
@WebServlet(name = "PriceSearchServlet", urlPatterns= "/priceSearch")
public class PriceSearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("Price Search Servlet------------------ :)");
        dbConnection.dbConnection databaseCon = new dbConnection.dbConnection();
        String max_price = req.getParameter("max_price");
        String min_price = req.getParameter("min_price");

        System.out.println(max_price);
        System.out.println(min_price);

        ArrayList<phones> seacrh_res;

        try {
            seacrh_res = databaseCon.getPriceSearchRes(max_price, min_price);
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
