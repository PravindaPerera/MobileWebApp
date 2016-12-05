package controllers;

import services.phones;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name="hello", urlPatterns= "/hello")
public class HelloServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        dbConnection.dbConnection databaseCon = new dbConnection.dbConnection();
        try {

            phones[] phoneDetails = databaseCon.getData();
            ArrayList<phones> phoneList = new ArrayList<phones>();
            for(int i=0; i<phoneDetails.length; i++){
                //System.out.println(phoneDetails[i].getCode());
                phoneList.add(phoneDetails[i]);

            }
            req.setAttribute("phone_details", phoneList);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        req.getRequestDispatcher("/home.jsp").forward(req,resp);
    }
}


