import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Vlogin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            String name = request.getParameter("name");
            String card = request.getParameter("card");

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/online_voting", "root", "ADMIN");

            PreparedStatement p = con.prepareStatement(
                "SELECT VoterCardNo FROM register1 WHERE FirstName=? AND VoterCardNo=?");

            p.setString(1, name);
            p.setString(2, card);

            ResultSet rs = p.executeQuery();

            if (rs.next()) {
                // User logged in successfully
                HttpSession session = request.getSession();
                session.setAttribute("voterCard", card);  // store voter card or any unique id

                response.sendRedirect("Vote.jsp");
            } else {
                // Invalid login — display message and include same login page
                out.println("<style>h1 { color: purple; text-align:center; }</style>");
                out.println("<h1>INVALID LOGIN CREDENTIALS</h1>");
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.include(request, response);
            }

            rs.close();
            p.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace(out);
        }
    }
}