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

@WebServlet(name="login", urlPatterns= "/login")
public class LoginServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String uname = req.getParameter("uname");
        String pword = req.getParameter("pword");
        String brand = "Samsung";
        Boolean user = false;

        dbConnection.dbConnection databaseCon = new dbConnection.dbConnection();
        try {
            user = databaseCon.checkLogin(uname, pword);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(user){
            req.setAttribute("p_name", uname);
            try {
                phones[] phoneDetails = databaseCon.getPhonesByBrand(brand);
                ArrayList<phones> phoneList = new ArrayList<phones>();
                for(int i=0; i<phoneDetails.length; i++){
                    phoneList.add(phoneDetails[i]);
                }
                req.setAttribute("phone_details", phoneList);
            } catch (SQLException e) {
                e.printStackTrace();
            }


            req.getRequestDispatcher("/WEB-INF/views/dashboard.jsp").forward(req,resp);
        }
        else{
            req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req,resp);
        }

    }
}
