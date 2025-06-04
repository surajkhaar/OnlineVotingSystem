import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class RegVoters extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String mobile = request.getParameter("mobile");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String dob = request.getParameter("dob");
        String card = request.getParameter("card");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
  "jdbc:mysql://localhost:3306/online_voting", "root", "ADMIN"); // update DB name & password if needed

            PreparedStatement ps = con.prepareStatement(
    "INSERT INTO register1 (FirstName, LastName, MobileNo, Email, Gender, DateOfBirth, VoterCardNo) VALUES (?, ?, ?, ?, ?, ?, ?)"
);

            ps.setString(1, fname);
            ps.setString(2, lname);
            ps.setString(3, mobile);
            ps.setString(4, email);
            ps.setString(5, gender);
            ps.setString(6, dob);
            ps.setString(7, card);

            int i = ps.executeUpdate();
            if (i > 0) {
                out.println("<h3>✅ You have registered successfully!</h3>");
            } else {
                out.println("<h3>❌ Registration failed.</h3>");
            }

            con.close();
        } catch (Exception e) {
            out.println("Error: " + e.getMessage());
        }
    }
}