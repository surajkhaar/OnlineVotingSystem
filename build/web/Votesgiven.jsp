<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>CANDIDATE VIEW</title>
    <style>
        .table1 {
            border: 1px solid black;
            width: 100%;
        }
        body {
            background-color: purple;
        }
        th {
            width: 150px;
            text-align: center;
            border: 1px solid black;
            color: red;
            padding: 30px;
        }
        td {
            width: 150px;
            text-align: center;
            border: 1px solid black;
            color: #ADEF07;
            padding: 30px;
        }
        h1 {
            color: #F2BB12;
        }
    </style>
</head>
<body>
    <h1>THE VOTES GIVEN ARE:</h1>
    <table class="table1">
        <tr>
            <th>PARTY NAME</th>
        </tr>
<%
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
       Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/online_voting", "root", "ADMIN");        Statement stm = conn.createStatement();
       ResultSet rs = stm.executeQuery("SELECT * FROM votes");

        while (rs.next()) {
%>
        <tr>
            <td><%= rs.getString("PartyName") %></td>
        </tr>
<%
        }
        conn.close();
    } catch (Exception ex) {
        out.println("<p style='color:red;'>Error: " + ex.getMessage() + "</p>");
        ex.printStackTrace(); // logs error in Tomcat console
    }
%>
      
    </table>
</body>
</html>