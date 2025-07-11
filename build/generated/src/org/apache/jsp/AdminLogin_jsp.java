package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class AdminLogin_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <title>Admin Login</title>\n");
      out.write("    <style>\n");
      out.write("        body {\n");
      out.write("            background-color: #f0f0f0;\n");
      out.write("            font-family: Arial;\n");
      out.write("            text-align: center;\n");
      out.write("            padding-top: 150px;\n");
      out.write("        }\n");
      out.write("        input[type=text], input[type=password] {\n");
      out.write("            padding: 10px;\n");
      out.write("            margin: 10px;\n");
      out.write("            width: 250px;\n");
      out.write("        }\n");
      out.write("        input[type=submit] {\n");
      out.write("            padding: 10px 25px;\n");
      out.write("            background-color: blue;\n");
      out.write("            color: white;\n");
      out.write("            border: none;\n");
      out.write("            margin-top: 20px;\n");
      out.write("        }\n");
      out.write("        h2 {\n");
      out.write("            color: navy;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <h2>🔐 Admin Login</h2>\n");
      out.write("    <form method=\"post\" action=\"AdminCheck\">\n");
      out.write("        <input type=\"text\" name=\"user\" placeholder=\"Username\" required><br>\n");
      out.write("        <input type=\"password\" name=\"pass\" placeholder=\"Password\" required><br>\n");
      out.write("        <input type=\"submit\" value=\"Login\">\n");
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
