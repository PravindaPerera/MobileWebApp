<%--
  Created by IntelliJ IDEA.
  User: Pravinda Perera
  Date: 12/5/2016
  Time: 6:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="services.phones" %>
<%@ page import="java.util.ArrayList" %>

<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" media="screen">
</head>
<body>

<% ArrayList<phones> pd = (ArrayList<phones>)request.getAttribute("phone_details");
%>

<table class="table table-bordered">
    <tr>
        <th>Phone ID</th>
        <th>Brand</th>
        <th>Code</th>
        <th>Storage</th>
        <th>Display</th>
        <th>Battery</th>
        <th>Front Cam</th>
        <th>Rear Cam</th>
        <th>Price</th>
    </tr>


    <%
        for(int i=0; i<pd.size(); i++){
    %>

    <tr>
        <form method=post action="/comments">
            <td><%= pd.get(i).getPhone_id()%></td>
            <td><%= pd.get(i).getBrand()%></td>
            <td><%= pd.get(i).getCode()%></td>
            <td><%= pd.get(i).getStorage()%></td>
            <td><%= pd.get(i).getDisplay()%></td>
            <td><%= pd.get(i).getBattery()%></td>
            <td><%= pd.get(i).getFront_cam()%></td>
            <td><%= pd.get(i).getRear_cam()%></td>
            <td><%= pd.get(i).getPrice()%></td>
        </form>
    </tr>
    <%

        }
    %>

</table>


<script src="http://code.jquery.com/jquery.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

</body>
</html>
