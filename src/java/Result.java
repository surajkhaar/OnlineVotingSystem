
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Result extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/online_voting", "root", "ADMIN");

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(
                    "SELECT c.FirstName, c.LastName, c.PartyName, COUNT(v.VoteID) AS votes "
                    + "FROM candidates c "
                    + "LEFT JOIN vote v ON v.CandidateID = c.id "
                    + "GROUP BY c.id, c.FirstName, c.LastName, c.PartyName");

            out.println("<html><head><title>Voting Results</title></head><body style='text-align:center;'>");
            out.println("<h1>🗳️ Voting Results</h1>");
            out.println("<table border='1' align='center'><tr><th>Candidate</th><th>Party</th><th>Votes</th></tr>");

            while (rs.next()) {
                String fullName = rs.getString("FirstName") + " " + rs.getString("LastName");
                String party = rs.getString("PartyName");
                int voteCount = rs.getInt("votes");
                out.println("<tr><td>" + fullName + "</td><td>" + party + "</td><td>" + voteCount + "</td></tr>");
            }

            out.println("</table></body></html>");
            con.close();

        } catch (Exception e) {
            out.println("<h3>Error: " + e.getMessage() + "</h3>");
            e.printStackTrace(out);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}

//create table votes(PartyName varchar(20));
//select count(*) from votes where PartyName='SHIV SENA';
