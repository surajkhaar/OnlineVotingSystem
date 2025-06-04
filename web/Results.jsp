<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Voting Results</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 30px;
        }
        h2 {
            color: #2c3e50;
            text-align: center;
        }
        table {
            border-collapse: collapse;
            width: 70%;
            margin: auto;
        }
        th, td {
            border: 1px solid #34495e;
            padding: 12px;
            text-align: center;
        }
        th {
            background-color: #34495e;
            color: white;
        }
        tr:nth-child(even) {
            background-color: #ecf0f1;
        }
        .error {
            color: red;
            text-align: center;
        }
    </style>
</head>
<body>
    <h2>🗳️ Voting Results</h2>
    <table>
        <tr>
            <th>Candidate Name</th>
            <th>Party</th>
            <th>Total Votes</th>
        </tr>
        <%
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/online_voting", "root", "ADMIN");

                String query = "SELECT c.FirstName, c.LastName, c.PartyName, COUNT(v.CandidateID) AS voteCount " +
                               "FROM candidates c LEFT JOIN votes v ON c.id = v.CandidateID " +
                               "GROUP BY c.id, c.FirstName, c.LastName, c.PartyName";

                ps = con.prepareStatement(query);
                rs = ps.executeQuery();

                boolean hasResults = false;
                while (rs.next()) {
                    hasResults = true;
        %>
        <tr>
            <td><%= rs.getString("FirstName") %> <%= rs.getString("LastName") %></td>
            <td><%= rs.getString("PartyName") %></td>
            <td><%= rs.getInt("voteCount") %></td>
        </tr>
        <%
                }
                if (!hasResults) {
        %>
        <tr>
            <td colspan="3">No voting results available yet.</td>
        </tr>
        <%
                }
            } catch (Exception e) {
        %>
        <tr>
            <td colspan="3" class="error">Error loading results: <%= e.getMessage() %></td>
        </tr>
        <%
            } finally {
                try { if (rs != null) rs.close(); } catch(Exception e) {}
                try { if (ps != null) ps.close(); } catch(Exception e) {}
                try { if (con != null) con.close(); } catch(Exception e) {}
            }
        %>
    </table>
</body>
</html>