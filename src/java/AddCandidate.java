
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class AddCandidate extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String mobile = request.getParameter("mobile");
        String email = request.getParameter("email");
        String party = request.getParameter("party");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/online_voting", "root", "ADMIN");

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO candidates (FirstName, LastName, MobileNo, EmailId, PartyName) VALUES (?, ?, ?, ?, ?)");
            ps.setString(1, fname);
            ps.setString(2, lname);
            ps.setString(3, mobile);
            ps.setString(4, email);
            ps.setString(5, party);

            int status = ps.executeUpdate();

            if (status > 0) {
                out.println("<h3>Candidate Registered Successfully ✅</h3>");
                out.println("<a href='add_candidate.jsp'>Register Another</a>");
            } else {
                out.println("<h3>Error: Could not register candidate ❌</h3>");
            }

            con.close();
        } catch (Exception e) {
            out.println("Error: " + e.getMessage());
        }
    }
}