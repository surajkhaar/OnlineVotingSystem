import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class CastVote extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(false);
        String voterIdStr = (String) session.getAttribute("voterCard"); // From session
        String candidateIdStr = request.getParameter("candidateId");

        if (voterIdStr == null || candidateIdStr == null) {
            out.println("Error: Missing voter ID or candidate ID.");
            return;
        }

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/online_voting", "root", "ADMIN");

            // Optional: check if this voter already voted (if you have votes table)

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO votes (VoterCardNo, CandidateID) VALUES (?, ?)");
            ps.setString(1, voterIdStr);
            ps.setInt(2, Integer.parseInt(candidateIdStr));

            int i = ps.executeUpdate();

            if (i > 0) {
                out.println("<h3>✅ Your vote has been cast successfully!</h3>");
            } else {
                out.println("<h3>❌ Failed to cast vote. Try again.</h3>");
            }

            ps.close();
            con.close();

        } catch (Exception e) {
            out.println("Error while voting: " + e.getMessage());
        }
    }
}