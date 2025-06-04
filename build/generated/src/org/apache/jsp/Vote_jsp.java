package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class Vote_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <title>Online Voting System - Vote</title>\n");
      out.write("    <style>\n");
      out.write("        table {\n");
      out.write("            width: 80%;\n");
      out.write("            border-collapse: collapse;\n");
      out.write("            margin: 20px auto;\n");
      out.write("        }\n");
      out.write("        th, td {\n");
      out.write("            border: 1px solid #888;\n");
      out.write("            padding: 10px;\n");
      out.write("            text-align: center;\n");
      out.write("        }\n");
      out.write("        th {\n");
      out.write("            background-color: #4CAF50;\n");
      out.write("            color: white;\n");
      out.write("        }\n");
      out.write("        h1 {\n");
      out.write("            text-align: center;\n");
      out.write("            color: #333;\n");
      out.write("        }\n");
      out.write("        input[type=submit] {\n");
      out.write("            display: block;\n");
      out.write("            margin: 20px auto;\n");
      out.write("            padding: 10px 20px;\n");
      out.write("            font-size: 16px;\n");
      out.write("            cursor: pointer;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("<h1>Select Your Candidate to Vote</h1>\n");
      out.write("\n");

    String voterCard = (String) session.getAttribute("voterCard");
    if (voterCard == null) {
        out.println("<h3 style='color:red; text-align:center;'>Session expired or not logged in. Please login again.</h3>");
        return;
    }

      out.write("\n");
      out.write("\n");
      out.write("<form method=\"post\" action=\"CastVote\">\n");
      out.write("    <!-- Hidden field to pass voter ID -->\n");
      out.write("    <input type=\"hidden\" name=\"voterId\" value=\"");
      out.print( voterCard );
      out.write("\">\n");
      out.write("    \n");
      out.write("    <table>\n");
      out.write("        <tr>\n");
      out.write("            <th>Select</th>\n");
      out.write("            <th>First Name</th>\n");
      out.write("            <th>Last Name</th>\n");
      out.write("            <th>Party Name</th>\n");
      out.write("        </tr>\n");
      out.write("        ");

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/online_voting", "root", "ADMIN");
                PreparedStatement ps = con.prepareStatement("SELECT id, FirstName, LastName, PartyName FROM candidates");
                ResultSet rs = ps.executeQuery();
                boolean hasCandidates = false;

                while (rs.next()) {
                    hasCandidates = true;
        
      out.write("\n");
      out.write("        <tr>\n");
      out.write("            <td><input type=\"radio\" name=\"candidateId\" value=\"");
      out.print( rs.getInt("id") );
      out.write("\" required></td>\n");
      out.write("            <td>");
      out.print( rs.getString("FirstName") );
      out.write("</td>\n");
      out.write("            <td>");
      out.print( rs.getString("LastName") );
      out.write("</td>\n");
      out.write("            <td>");
      out.print( rs.getString("PartyName") );
      out.write("</td>\n");
      out.write("        </tr>\n");
      out.write("        ");

                }
                if (!hasCandidates) {
        
      out.write("\n");
      out.write("        <tr><td colspan=\"4\">No candidates available currently.</td></tr>\n");
      out.write("        ");

                }
                rs.close();
                ps.close();
                con.close();
            } catch (Exception e) {
                out.println("<tr><td colspan='4' style='color:red;'>Error loading candidates: " + e.getMessage() + "</td></tr>");
            }
        
      out.write("\n");
      out.write("    </table>\n");
      out.write("    \n");
      out.write("    <input type=\"submit\" value=\"Cast Vote\">\n");
      out.write("</form>\n");
      out.write("\n");
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
