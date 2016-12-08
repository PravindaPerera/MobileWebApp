package dbConnection;
import services.phones;
import services.comments;

import java.sql.*;
import java.util.ArrayList;

public class dbConnection {
    private Connection con;
    private Statement st;
    private ResultSet rs;
    private ResultSet rs2;

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

    public comments[] getComments() throws SQLException {
        int count = 0;
        int index = 0;
        String query = "SELECT COUNT(*) AS total FROM comments";
        rs = st.executeQuery(query);

        if(rs.next()){
            count = rs.getInt("total");
        }

        comments[] comment = new comments[count];

        try{
            query = "SELECT * FROM comments";
            rs = st.executeQuery(query);

            while(rs.next()){
                comment[index] = new comments();
                comment[index].setPhone_id(rs.getInt("phone_id"));
                comment[index].setCmt_id(rs.getInt("comment_id"));
                comment[index].setCmnt(rs.getString("comment"));
                index ++;
            }


        }
        catch(Exception ex){

        }

        return comment;
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

    public ArrayList<phones> getFinalSearchRes(String search_type, String value) throws SQLException {
        String query1 = "";
        String countQu = "";
        String commentQu = "";
        int count = 0;
        int index = 0;
        ArrayList<phones> searchDetails = new ArrayList<phones>();

        if (search_type.equals("Brand")) {
            countQu = "SELECT COUNT(*) AS count FROM phones WHERE brand=?";
            query1 =  "SELECT * FROM phones WHERE brand=?";

        }
        else if (search_type.equals("Code")) {
            countQu = "SELECT COUNT(*) AS count FROM phones WHERE code_id=?";
            query1 =  "SELECT * FROM phones WHERE code_id=?";

        }
        else if (search_type.equals("Storage")) {
            countQu = "SELECT COUNT(*) AS count FROM phones WHERE storage=?";
            query1 =  "SELECT * FROM phones WHERE storage=?";

        }
        else if (search_type.equals("Display")) {
            countQu = "SELECT COUNT(*) AS count FROM phones WHERE display=?";
            query1 =  "SELECT * FROM phones WHERE display=?";


        }
        else if (search_type.equals("Battery")) {
            countQu = "SELECT COUNT(*) AS count FROM phones WHERE battery=?";
            query1 =  "SELECT * FROM phones WHERE battery=?";

        }
        else if (search_type.equals("Front Camera")) {
            countQu = "SELECT COUNT(*) AS count FROM phones WHERE front_cam=?";
            query1 =  "SELECT * FROM phones WHERE front_cam=?";


        }
        else if (search_type.equals("Rear Camera")) {
            countQu = "SELECT COUNT(*) AS count FROM phones WHERE rear_cam=?";
            query1 =  "SELECT * FROM phones WHERE rear_cam=?";

        }
        else {

        }

        PreparedStatement preparedStmtCount = con.prepareStatement(countQu);
        preparedStmtCount.setString (1, value);
        rs =preparedStmtCount.executeQuery();

        if(rs.next()){
            count = rs.getInt("count");
        }

        phones[] phoneDetails = new phones[count];

        PreparedStatement preparedStmt = con.prepareStatement(query1);
        preparedStmt.setString (1, value);
        rs =preparedStmt.executeQuery();

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

            commentQu = "SELECT comment FROM comments WHERE phone_id = ?";
            preparedStmtCount = con.prepareStatement(commentQu);
            preparedStmtCount.setInt(1, phoneDetails[index].getPhone_id());
            rs2 = preparedStmtCount.executeQuery();

            while(rs2.next()){
                phoneDetails[index].comments.add(rs2.getString("comment"));
            }

            index ++;

        }

        for (int i=0; i<phoneDetails.length; i++){
            searchDetails.add(phoneDetails[i]);
        }

        return searchDetails;
    }
}
