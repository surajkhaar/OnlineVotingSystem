package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class add_005fcandidate_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <title>Register Candidate</title>\n");
      out.write("    <style>\n");
      out.write("        body {\n");
      out.write("            background-color: #f0f8ff;\n");
      out.write("            text-align: center;\n");
      out.write("            padding-top: 50px;\n");
      out.write("        }\n");
      out.write("        input, select {\n");
      out.write("            margin: 10px;\n");
      out.write("            padding: 10px;\n");
      out.write("            border-radius: 8px;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <h2>Register Candidate</h2>\n");
      out.write("    <form method=\"post\" action=\"AddCandidate\">\n");
      out.write("        First Name: <input type=\"text\" name=\"fname\" required><br>\n");
      out.write("        Last Name: <input type=\"text\" name=\"lname\" required><br>\n");
      out.write("        Mobile No: <input type=\"text\" name=\"mobile\" required><br>\n");
      out.write("        Email: <input type=\"email\" name=\"email\" required><br>\n");
      out.write("        Party Name: <input type=\"text\" name=\"party\" required><br>\n");
      out.write("        <input type=\"submit\" value=\"Register Candidate\">\n");
      out.write("    </form>\n");
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
