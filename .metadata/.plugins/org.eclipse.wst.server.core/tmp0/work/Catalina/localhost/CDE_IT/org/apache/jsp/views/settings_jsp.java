/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.31
 * Generated at: 2020-03-08 14:08:13 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class settings_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("<title>Bootstrap Example</title>\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("\thref=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css\">\r\n");
      out.write("<script\r\n");
      out.write("\tsrc=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>\r\n");
      out.write("<script\r\n");
      out.write("\tsrc=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js\"></script>\r\n");
      out.write("<script\r\n");
      out.write("\tsrc=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js\"></script>\r\n");
      out.write("\t\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"../style/bootsrtap.min.css\">\r\n");
      out.write("<script src=\"../style/jquery.min.js\"></script>\r\n");
      out.write("<!-- <script -->\r\n");
      out.write("<!-- \tsrc=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js\"></script> -->\r\n");
      out.write("<!-- <script -->\r\n");
      out.write("<!-- \tsrc=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js\"> </script> -->\r\n");
      out.write("<!-- <style> -->\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" href=\"../style/bootsrtap.min.css\">\r\n");
      out.write("<script src=\"../style/jquery.min.js\"></script>\r\n");
      out.write("<script\tsrc=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js\"></script>\r\n");
      out.write("<script\tsrc=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js\"> </script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<br>\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"container\">\r\n");
      out.write("\t\t<div>\r\n");
      out.write("\t\t\t<img src=\"../img/logoe.png\" style=\"max-height: 75px\">\r\n");
      out.write("\t\t\t<text style=\"font-size:30px; color:gray ; margin-left:30px;\">\r\n");
      out.write("\t\t\tSettings<text>\r\n");
      out.write("\t\t\t<hr />\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<br>\r\n");
      out.write("\r\n");
      out.write("\t\t<!-- Nav tabs -->\r\n");
      out.write("\t\t<ul class=\"nav nav-tabs\" role=\"tablist\">\r\n");
      out.write("\t\t\t<li class=\"nav-item\"><a class=\"nav-link active\" data-toggle=\"tab\"\r\n");
      out.write("\t\t\t\thref=\"#vms\">VMS</a></li>\r\n");
      out.write("\t\t\t<li class=\"nav-item\"><a class=\"nav-link\"\r\n");
      out.write("\t\t\t\tdata-toggle=\"tab\" href=\"#inheritance\">Inheritance</a></li>\r\n");
      out.write("\t\t\t<li class=\"nav-item\"><a class=\"nav-link\" data-toggle=\"tab\"\r\n");
      out.write("\t\t\t\thref=\"#Coupling\">Coupling</a></li>\r\n");
      out.write("\t\t\t<li class=\"nav-item\"><a class=\"nav-link\" data-toggle=\"tab\"\r\n");
      out.write("\t\t\t\thref=\"#Control\">Control Structures</a></li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\r\n");
      out.write("\t\t<!-- Tab panes -->\r\n");
      out.write("\t\t<div class=\"tab-content\">\r\n");
      out.write("\t\t\t<div id=\"vms\" class=\"container tab-pane active\">\r\n");
      out.write("\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t\t<div class=\"col-sm border border-success\">\r\n");
      out.write("\t\t\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t\t\t<h5 align=\"center\">Weights related to the size factor</h5>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"table-responsive\">\r\n");
      out.write("\t\t\t\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t\t\t\t<table class=\"table table-bordered\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<thead class=\"thead-light\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<th>Program Component</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<th>Weight</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t</thead>\r\n");
      out.write("\t\t\t\t\t\t\t\t<tbody>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td>Keyword</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td><input type=\"number\" class=\"form-control\"   style=\"width:60px\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td>Identifier</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td><input type=\"number\" class=\"form-control\"   style=\"width:60px\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td>Operator</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td><input type=\"number\" class=\"form-control\"   style=\"width:60px\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td>Numerical value</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td><input type=\"number\" class=\"form-control\"   style=\"width:60px\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td>String literal</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td><input type=\"number\" class=\"form-control\"   style=\"width:60px\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tbody>\r\n");
      out.write("\t\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<button type=\"button\" class=\"btn btn-success\">Save</button>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t&nbsp\r\n");
      out.write("\t\t\t\t\t<div class=\"col-sm border border-success\">\r\n");
      out.write("\t\t\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t\t\t<h5 align=\"center\">Weights related to the variable factor</h5>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"table-responsive\">\r\n");
      out.write("\t\t\t\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t\t\t\t<table class=\"table table-bordered\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<thead class=\"thead-light\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<th>Program Component</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<th>Weight</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t</thead>\r\n");
      out.write("\t\t\t\t\t\t\t\t<tbody>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td>Method with a primitive return type</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td><input type=\"number\" class=\"form-control\"   style=\"width:60px\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td>Method with a composite return type</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td><input type=\"number\" class=\"form-control\"   style=\"width:60px\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td>Method with a void return type</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td><input type=\"number\" class=\"form-control\"   style=\"width:60px\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td>Primitive data type parameter</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td><input type=\"number\" class=\"form-control\"   style=\"width:60px\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td>Composite data type parameter</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td><input type=\"number\" class=\"form-control\"   style=\"width:60px\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tbody>\r\n");
      out.write("\t\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<button type=\"button\" class=\"btn btn-success\">Save</button>\r\n");
      out.write("\t\t\t\t\t\t<p></p>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t<div class=\"row justify-content-md-center\">\r\n");
      out.write("\t\t\t\t\t<div class=\"col-md-6 border border-success\">\r\n");
      out.write("\t\t\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t\t\t<h5 align=\"center\">Weights related to the method factor</h5>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"table-responsive\">\r\n");
      out.write("\t\t\t\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t\t\t\t<table class=\"table table-bordered\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<thead class=\"thead-light\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<th>Program Component</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<th>Weight</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t</thead>\r\n");
      out.write("\t\t\t\t\t\t\t\t<tbody>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td>Global variable</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td><input type=\"number\" class=\"form-control\"   style=\"width:60px\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td>Local variable</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td><input type=\"number\" class=\"form-control\"   style=\"width:60px\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td>Primitive data type variable</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td><input type=\"number\" class=\"form-control\"   style=\"width:60px\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td>Composite data type variable</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td><input type=\"number\" class=\"form-control\"   style=\"width:60px\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tbody>\r\n");
      out.write("\t\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<button type=\"button\" class=\"btn btn-success\">Save</button>\r\n");
      out.write("\t\t\t\t\t\t<p></p>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<br>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div id=\"inheritance\" class=\"container tab-pane fade\">\r\n");
      out.write("\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t<div class=\"col-sm border border-success\">\r\n");
      out.write("\t\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t\t<h5 align=\"center\">Weights related to the inheritance factor</h5>\r\n");
      out.write("\t\t\t\t\t<div class=\"table-responsive\">\r\n");
      out.write("\t\t\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t\t\t<table class=\"table table-bordered\">\r\n");
      out.write("\t\t\t\t\t\t\t<thead class=\"thead-light\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<th>Inherited Pattern</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<th>Weight</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t</thead>\r\n");
      out.write("\t\t\t\t\t\t\t<tbody>\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td>A class with no inheritance (direct or indirect)</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td><input type=\"number\" class=\"form-control\"   style=\"width:60px\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td>A class inheriting (directly or indirectly) from one user-defined class</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td><input type=\"number\" class=\"form-control\"   style=\"width:60px\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td>A class inheriting (directly or indirectly) from two user-defined classes</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td><input type=\"number\" class=\"form-control\"   style=\"width:60px\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td>A class inheriting (directly or indirectly) from three user-defined classes</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td><input type=\"number\" class=\"form-control\"   style=\"width:60px\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td>A class inheriting (directly or indirectly) from more than three user-defined classes</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td><input type=\"number\" class=\"form-control\"   style=\"width:60px\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t</tbody>\r\n");
      out.write("\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<button type=\"button\" class=\"btn btn-success\">Save</button>\r\n");
      out.write("\t\t\t\t\t<p></p>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div id=\"Coupling\" class=\"container tab-pane fade\">\r\n");
      out.write("\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t<div class=\"col-sm border border-success\">\r\n");
      out.write("\t\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t\t<h5 align=\"center\">Weights related to the coupling factor</h5>\r\n");
      out.write("\t\t\t\t\t<div class=\"table-responsive\">\r\n");
      out.write("\t\t\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t\t\t<table class=\"table table-bordered\">\r\n");
      out.write("\t\t\t\t\t\t\t<thead class=\"thead-light\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<th>Coupling Type</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<th>Weight</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t</thead>\r\n");
      out.write("\t\t\t\t\t\t\t<tbody>\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td>A recursive call</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td><input type=\"number\" class=\"form-control\"   style=\"width:60px\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td>A regular method calling another regular method in the same file</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td><input type=\"number\" class=\"form-control\"   style=\"width:60px\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td>A regular method calling another regular method in a different file</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td><input type=\"number\" class=\"form-control\"   style=\"width:60px\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td>A regular method calling a recursive method in the same file</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td><input type=\"number\" class=\"form-control\"   style=\"width:60px\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td>A regular method calling a recursive method in a different file</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td><input type=\"number\" class=\"form-control\"   style=\"width:60px\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td>A recursive method calling another recursive method in the same file</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td><input type=\"number\" class=\"form-control\"   style=\"width:60px\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td>A recursive method calling another recursive method in a different file</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td><input type=\"number\" class=\"form-control\"   style=\"width:60px\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td>A recursive method calling a regular method in the same file</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td><input type=\"number\" class=\"form-control\"   style=\"width:60px\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td>A recursive method calling a regular method in a different file</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td><input type=\"number\" class=\"form-control\"   style=\"width:60px\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td>A regular method referencing a global variable in the same file</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td><input type=\"number\" class=\"form-control\"   style=\"width:60px\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td>A regular method referencing a global variable in a different file</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td><input type=\"number\" class=\"form-control\"   style=\"width:60px\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td>A recursive method referencing a global variable in the same file</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td><input type=\"number\" class=\"form-control\"   style=\"width:60px\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td>A recursive method referencing a global variable in a different file</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td><input type=\"number\" class=\"form-control\"   style=\"width:60px\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t</tbody>\r\n");
      out.write("\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<button type=\"button\" class=\"btn btn-success\">Save</button>\r\n");
      out.write("\t\t\t\t\t<p></p>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div id=\"Control\" class=\"container tab-pane fade\">\r\n");
      out.write("\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t<div class=\"col-sm border border-success\">\r\n");
      out.write("\t\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t\t<h5 align=\"center\">Weights related to the control structure factor</h5>\r\n");
      out.write("\t\t\t\t\t<div class=\"table-responsive\">\r\n");
      out.write("\t\t\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t\t\t<table class=\"table table-bordered\">\r\n");
      out.write("\t\t\t\t\t\t\t<thead class=\"thead-light\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<th>Program Component</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<th>Weight</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t</thead>\r\n");
      out.write("\t\t\t\t\t\t\t<tbody>\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td>A conditional control structure such as an âifâ or âelse-ifâ condition</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td><input type=\"number\" class=\"form-control\"   style=\"width:60px\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td>An iterative control structure such as a âforâ, âwhileâ, or âdo-whileâ loop</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td><input type=\"number\" class=\"form-control\"   style=\"width:60px\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td>The âswitchâ statement in a âswitch-caseâ control structure</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td><input type=\"number\" class=\"form-control\"   style=\"width:60px\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td>Each âcaseâ statement in a âswitch-caseâ control structure</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td><input type=\"number\" class=\"form-control\"   style=\"width:60px\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t</tbody>\r\n");
      out.write("\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<button type=\"button\" class=\"btn btn-success\">Save</button>\r\n");
      out.write("\t\t\t\t\t<p></p>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
