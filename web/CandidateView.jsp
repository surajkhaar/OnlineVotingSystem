

   <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@page import ="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>VOTES GIVEN ARE:</title>
        <style>
            .table1{
                border: 1px solid black;
                width:100%;
            }
            body{
                background-color: blue;
            }
        </style>
    </head>
    <body>
        <h1>THE CANDIDATES ARE:</h1>
         <table class="table1">
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Mobile No</th>
                <th>Email Id</th>
                <th>Party Name</th>
            </tr>
             
                  <%
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/online_voting", "root", "ADMIN");
        Statement stmt = conn.createStatement();
       ResultSet rs = stmt.executeQuery("SELECT name, last_name, mobile_no, email, party_name, vote_count FROM candidates");

        while (rs.next()) {
%>
<tr>
    <td><%= rs.getString("name") %></td>
    <td><%= rs.getString("last_name") %></td>
    <td><%= rs.getString("mobile_no") %></td>
    <td><%= rs.getString("email") %></td>
    <td><%= rs.getString("party_name") %></td>
    <td><%= rs.getInt("vote_count") %></td>
</tr>
<%
        }
        conn.close();
    } catch (Exception e) {
        out.println("Error: " + e.getMessage());
    }
%>
              
           
   
       
            </table>
       </body>
</html>

<!--create table candidate (FirstName varchar(20),LastName varchar(20),MobileNo varchar(10),EmailId varchar(20),PartyName varchar(50))
    insert into candidate values('Narendra','Modi','345678964','modi@gmail.com','Bhartiya Janata party')
    insert into candidate values('Arvind','Kejriwal','4567839256','kerriwal@gmail.com','Aam Aadmi Party')
    insert into candidate values('Rahul','Gandhi','9987356284','gandhi@gmail.com','Indian National Congress')
    insert into candidate values('Uddhav','Thackery','8567459348','thackery@gmail.com','Shiv Sena')-->