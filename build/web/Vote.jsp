<%@ page import="java.sql.*" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
    <title>Online Voting System - Vote</title>
    <style>
        table {
            width: 80%;
            border-collapse: collapse;
            margin: 20px auto;
        }
        th, td {
            border: 1px solid #888;
            padding: 10px;
            text-align: center;
        }
        th {
            background-color: #4CAF50;
            color: white;
        }
        h1 {
            text-align: center;
            color: #333;
        }
        input[type=submit] {
            display: block;
            margin: 20px auto;
            padding: 10px 20px;
            font-size: 16px;
            cursor: pointer;
        }
    </style>
</head>
<body>

<h1>Select Your Candidate to Vote</h1>

<%
    String voterCard = (String) session.getAttribute("voterCard");
    if (voterCard == null) {
        out.println("<h3 style='color:red; text-align:center;'>Session expired or not logged in. Please login again.</h3>");
        return;
    }
%>

<form method="post" action="CastVote">
    <!-- Hidden field to pass voter ID -->
    <input type="hidden" name="voterId" value="<%= voterCard %>">
    
    <table>
        <tr>
            <th>Select</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Party Name</th>
        </tr>
        <%
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/online_voting", "root", "ADMIN");
                PreparedStatement ps = con.prepareStatement("SELECT id, FirstName, LastName, PartyName FROM candidates");
                ResultSet rs = ps.executeQuery();
                boolean hasCandidates = false;

                while (rs.next()) {
                    hasCandidates = true;
        %>
        <tr>
            <td><input type="radio" name="candidateId" value="<%= rs.getInt("id") %>" required></td>
            <td><%= rs.getString("FirstName") %></td>
            <td><%= rs.getString("LastName") %></td>
            <td><%= rs.getString("PartyName") %></td>
        </tr>
        <%
                }
                if (!hasCandidates) {
        %>
        <tr><td colspan="4">No candidates available currently.</td></tr>
        <%
                }
                rs.close();
                ps.close();
                con.close();
            } catch (Exception e) {
                out.println("<tr><td colspan='4' style='color:red;'>Error loading candidates: " + e.getMessage() + "</td></tr>");
            }
        %>
    </table>
    
    <input type="submit" value="Cast Vote">
</form>

</body>
</html>