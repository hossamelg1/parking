package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import services.ParkingService;
import services.SectionService;
import services.EtageService;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    \n");
      out.write("    ");

        ParkingService ps = new ParkingService();
        SectionService ss = new SectionService();
        EtageService es = new EtageService();
        int number = ps.getCount();
    
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <script src=\"script/jquery-3.3.1.min.js\"></script>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.7.0/chart.min.js\" integrity=\"sha512-TW5s0IT/IppJtu76UbysrBH9Hy/5X41OTAbQuffZFU6lQ1rdcLHzpU5BzVvr/YFykoiMYZVWlr/PX1mDcfM9Qg==\" crossorigin=\"anonymous\" referrerpolicy=\"no-referrer\"></script>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("        <title>Home</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"asst/vendors/typicons.font/font/typicons.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"asset/vendors/css/vendor.bundle.base.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"asset/css/vertical-layout-light/style.css\">\n");
      out.write("        <link rel=\"shortcut icon\" href=\"asset/images/favicon.png\" />\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container-scroller\">\n");
      out.write("            <!-- partial:partials/_navbar.html -->\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "template/header.jsp", out, false);
      out.write(" \n");
      out.write("            <!-- partial -->\n");
      out.write("            <div class=\"container-fluid page-body-wrapper\">\n");
      out.write("                <!-- partial:partials/_settings-panel.html -->\n");
      out.write("\n");
      out.write("                <!-- partial -->\n");
      out.write("                <!-- partial:partials/_sidebar.html -->\n");
      out.write("                ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "template/sideBar.jsp", out, false);
      out.write(" \n");
      out.write("                <!-- partial -->\n");
      out.write("                <div class=\"main-panel\">\n");
      out.write("                    <div class=\"content-wrapper\">\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"col-sm-12 p-3\">\n");
      out.write("                                <h3 class=\"mb-0 font-weight-bold text-center\">Parking Management APP</h3>\n");
      out.write("\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"row \"id=\"cont\">\n");
      out.write("                            \n");
      out.write("                        \n");
      out.write("                        <script src=\"script/home.js\"></script>\n");
      out.write("                        <!-- main-panel ends -->\n");
      out.write("                    </div>\n");
      out.write("                        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "template/footer.jsp", out, false);
      out.write("\n");
      out.write("                    <!-- page-body-wrapper ends -->\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
