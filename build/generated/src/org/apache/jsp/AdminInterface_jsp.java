package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class AdminInterface_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <title>Admin Interface - Voting Results</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <h2>?? Voting Results</h2>\n");
      out.write("    <table border=\"1\">\n");
      out.write("        <tr>\n");
      out.write("            <th>Candidate Name</th>\n");
      out.write("            <th>Party</th>\n");
      out.write("            <th>Total Votes</th>\n");
      out.write("        </tr>\n");
      out.write("        ");

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
        
      out.write("\n");
      out.write("        <tr>\n");
      out.write("            <td>");
      out.print( rs.getString("FirstName") );
      out.write(' ');
      out.print( rs.getString("LastName") );
      out.write("</td>\n");
      out.write("            <td>");
      out.print( rs.getString("PartyName") );
      out.write("</td>\n");
      out.write("            <td>");
      out.print( rs.getInt("voteCount") );
      out.write("</td>\n");
      out.write("        </tr>\n");
      out.write("        ");

                }
                rs.close();
                ps.close();
                con.close();
            } catch (Exception e) {
                out.println("Error: " + e.getMessage());
            }
        
      out.write("\n");
      out.write("    </table>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
