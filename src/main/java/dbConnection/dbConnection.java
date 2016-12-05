package dbConnection;
import services.phones;

import java.sql.*;
import java.util.ArrayList;

public class dbConnection {
    private Connection con;
    private Statement st;
    private ResultSet rs;

    public dbConnection(){
        try{

            Class.forName("com.mysql.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mobileadvertizer", "root", "");
            st = con.createStatement();

        }
        catch (Exception ex){
            System.out.println("Error: "+ex);
        }
    }

    public boolean checkLogin(String uname, String pword) throws SQLException {
        String query = "SELECT * FROM login";
        rs = st.executeQuery(query);

        String username;
        String password;

        while(rs.next()){
            username = rs.getString("username");
            password = rs.getString("password");

            if(username.equals(uname) && password.equals(pword)){
                System.out.println("true");
                return true;
            }
        }

        return false;
    }

    public boolean SignUp(String uname, String pword) throws SQLException {
        String query = "SELECT * FROM login";
        rs = st.executeQuery(query);

        String username;
        String password;

        while(rs.next()){
            username = rs.getString("username");

            if(username.equals(uname)){
                System.out.println("true");
                return false;
            }
        }

        query = "INSERT INTO login (username, password) VALUES (?,?)";
        PreparedStatement preparedStmt = con.prepareStatement(query);
        preparedStmt.setString (1, uname);
        preparedStmt.setString (2, pword);
        preparedStmt.execute();
        return true;
    }

    public phones[] getData() throws SQLException {

        int count = 0;
        int index = 0;
        String query = "SELECT COUNT(*) AS total FROM phones";
        rs = st.executeQuery(query);

        if(rs.next()){
            count = rs.getInt("total");
        }

        phones[] pd = new phones[count];


        try{
            query = "SELECT * FROM phones";
            rs = st.executeQuery(query);

            while(rs.next()){
                pd[index] = new phones();
                pd[index].setPhone_id(rs.getInt("phone_id"));
                pd[index].setBrand(rs.getString("brand"));
                pd[index].setCode(rs.getString("code_id"));
                pd[index].setStorage(rs.getString("storage"));
                pd[index].setDisplay(rs.getString("display"));
                pd[index].setBattery(rs.getString("battery"));
                pd[index].setFront_cam(rs.getString("front_cam"));
                pd[index].setRear_cam(rs.getString("rear_cam"));
                pd[index].setPrice(rs.getDouble("price"));
                index ++;
            }


        }
        catch(Exception ex){

        }
        return pd;
    }

    public void postComment(int id, String comment) throws SQLException {

        String query = "INSERT INTO comments (phone_id, comment) VALUES (?,?)";
        PreparedStatement preparedStmt = con.prepareStatement(query);
        preparedStmt.setInt(1, id);
        preparedStmt.setString (2, comment);
        preparedStmt.execute();
    }
    
    public phones[] getPhonesByBrand(String brand) throws SQLException {
        int count = 0;
        int index = 0;
        String query = "SELECT COUNT(*) AS total FROM phones WHERE brand = 'Samsung'";
        rs = st.executeQuery(query);

        if(rs.next()){
            count = rs.getInt("total");
        }

        phones[] phoneDetails = new phones[count];

        query = "SELECT * FROM phones WHERE brand = 'Samsung'";
        rs = st.executeQuery(query);

        while(rs.next()){
            phoneDetails[index] = new phones();
            phoneDetails[index].setPhone_id(rs.getInt("phone_id"));
            phoneDetails[index].setBrand(rs.getString("brand"));
            phoneDetails[index].setCode(rs.getString("code_id"));
            phoneDetails[index].setStorage(rs.getString("storage"));
            phoneDetails[index].setDisplay(rs.getString("display"));
            phoneDetails[index].setBattery(rs.getString("battery"));
            phoneDetails[index].setFront_cam(rs.getString("front_cam"));
            phoneDetails[index].setRear_cam(rs.getString("rear_cam"));
            phoneDetails[index].setPrice(rs.getDouble("price"));
            index ++;
        }

        return phoneDetails;
    }

    public ArrayList<String> getSearchDetails(String search_type) throws SQLException {
        String query = "";
        ArrayList<String> searchDetails = new ArrayList<String>();

        if (search_type.equals("Brand")) {
            query =  "SELECT DISTINCT(brand) AS type FROM phones";
        }
        else if (search_type.equals("Code")) {
            query =  "SELECT DISTINCT(code_id) AS type FROM phones";

        }
        else if (search_type.equals("Storage")) {
            query =  "SELECT DISTINCT(storage) AS type FROM phones";

        }
        else if (search_type.equals("Display")) {
            query =  "SELECT DISTINCT(display) AS type FROM phones";

        }
        else if (search_type.equals("Battery")) {
            query =  "SELECT DISTINCT(battery) AS type FROM phones";

        }
        else if (search_type.equals("Front Camera")) {
            query =  "SELECT DISTINCT(front_cam) AS type FROM phones";

        }
        else if (search_type.equals("Rear Camera")) {
            query =  "SELECT DISTINCT(rear_cam) AS type FROM phones";

        }
        else {

        }

        rs = st.executeQuery(query);
        while (rs.next()){
            searchDetails.add(rs.getString("type"));
        }

        return searchDetails;
    }
}
