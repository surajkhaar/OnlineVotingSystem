package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class Results_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <title>Voting Results</title>\n");
      out.write("    <style>\n");
      out.write("        body {\n");
      out.write("            font-family: Arial, sans-serif;\n");
      out.write("            margin: 30px;\n");
      out.write("        }\n");
      out.write("        h2 {\n");
      out.write("            color: #2c3e50;\n");
      out.write("            text-align: center;\n");
      out.write("        }\n");
      out.write("        table {\n");
      out.write("            border-collapse: collapse;\n");
      out.write("            width: 70%;\n");
      out.write("            margin: auto;\n");
      out.write("        }\n");
      out.write("        th, td {\n");
      out.write("            border: 1px solid #34495e;\n");
      out.write("            padding: 12px;\n");
      out.write("            text-align: center;\n");
      out.write("        }\n");
      out.write("        th {\n");
      out.write("            background-color: #34495e;\n");
      out.write("            color: white;\n");
      out.write("        }\n");
      out.write("        tr:nth-child(even) {\n");
      out.write("            background-color: #ecf0f1;\n");
      out.write("        }\n");
      out.write("        .error {\n");
      out.write("            color: red;\n");
      out.write("            text-align: center;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <h2>🗳️ Voting Results</h2>\n");
      out.write("    <table>\n");
      out.write("        <tr>\n");
      out.write("            <th>Candidate Name</th>\n");
      out.write("            <th>Party</th>\n");
      out.write("            <th>Total Votes</th>\n");
      out.write("        </tr>\n");
      out.write("        ");

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
                if (!hasResults) {
        
      out.write("\n");
      out.write("        <tr>\n");
      out.write("            <td colspan=\"3\">No voting results available yet.</td>\n");
      out.write("        </tr>\n");
      out.write("        ");

                }
            } catch (Exception e) {
        
      out.write("\n");
      out.write("        <tr>\n");
      out.write("            <td colspan=\"3\" class=\"error\">Error loading results: ");
      out.print( e.getMessage() );
      out.write("</td>\n");
      out.write("        </tr>\n");
      out.write("        ");

            } finally {
                try { if (rs != null) rs.close(); } catch(Exception e) {}
                try { if (ps != null) ps.close(); } catch(Exception e) {}
                try { if (con != null) con.close(); } catch(Exception e) {}
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
