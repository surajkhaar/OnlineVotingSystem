<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Interface - Voting Results</title>
</head>
<body>
    <h2>?? Voting Results</h2>
    <table border="1">
        <tr>
            <th>Candidate Name</th>
            <th>Party</th>
            <th>Total Votes</th>
        </tr>
        <%
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/online_voting", "root", "ADMIN"
                );

                String query = "SELECT c.FirstName, c.LastName, c.PartyName, COUNT(v.VoterCardNo) AS voteCount " +
                               "FROM candidates c LEFT JOIN votes v ON c.id = v.CandidateID " +
                               "GROUP BY c.id, c.FirstName, c.LastName, c.PartyName";
                PreparedStatement ps = con.prepareStatement(query);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
        %>
        <tr>
            <td><%= rs.getString("FirstName") %> <%= rs.getString("LastName") %></td>
            <td><%= rs.getString("PartyName") %></td>
            <td><%= rs.getInt("voteCount") %></td>
        </tr>
        <%
                }
                rs.close();
                ps.close();
                con.close();
            } catch (Exception e) {
                out.println("Error: " + e.getMessage());
            }
        %>
    </table>
</body>
</html>