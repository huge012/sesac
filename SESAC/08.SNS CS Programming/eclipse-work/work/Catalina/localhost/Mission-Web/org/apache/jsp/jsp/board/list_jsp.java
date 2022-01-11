/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.56
 * Generated at: 2022-01-11 07:03:30 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.jsp.board;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.Connection;
import kr.co.mlec.util.JDBCClose;
import kr.co.mlec.util.ConnectionFactory;

public final class list_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.sql.Connection");
    _jspx_imports_classes.add("java.sql.ResultSet");
    _jspx_imports_classes.add("kr.co.mlec.util.ConnectionFactory");
    _jspx_imports_classes.add("kr.co.mlec.util.JDBCClose");
    _jspx_imports_classes.add("java.sql.PreparedStatement");
    _jspx_imports_classes.add("java.util.ArrayList");
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
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    \r\n");


	/* tbl_board에서 전체 게시글(번호, 제목, 작성자, 등록일) 조회 */
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	conn = new ConnectionFactory().getConnection();
	
	StringBuilder sql = new StringBuilder();
	sql.append("select no, title, writer, to_char(reg_date, 'yyyy-mm-dd') as reg_date ");
	sql.append(" from tbl_board ");
	sql.append(" order by no desc ");
		
	pstmt = conn.prepareStatement(sql.toString());
	ResultSet rs = pstmt.executeQuery();

	


      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<style>\r\n");
      out.write("	hr, table {\r\n");
      out.write("		width: 80%;\r\n");
      out.write("	}\r\n");
      out.write("	td {\r\n");
      out.write("		text-align: center;\r\n");
      out.write("	}\r\n");
      out.write("</style>\r\n");
      out.write("<script>\r\n");
      out.write("	function goWriterForm() {\r\n");
      out.write("		location.href = \"writeForm.jsp\"\r\n");
      out.write("	}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	<div align = \"center\">\r\n");
      out.write("		<hr>\r\n");
      out.write("		<h2>게시판 목록</h2>\r\n");
      out.write("		<hr>\r\n");
      out.write("		\r\n");
      out.write("		<table border=\"1\">\r\n");
      out.write("		<tr>\r\n");
      out.write("			<th width=\"7%\">번호</th>\r\n");
      out.write("			<th>제목</th>\r\n");
      out.write("			<th width=\"16%\">작성자</th>\r\n");
      out.write("			<th width=\"20%\">등록일</th>\r\n");
      out.write("		</tr>\r\n");
      out.write("		");

			while(rs.next()) {
				int no = rs.getInt("no");
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String date = rs.getString("reg_date");
		
      out.write("\r\n");
      out.write("			<tr>\r\n");
      out.write("				<td>");
      out.print( no );
      out.write("</td>\r\n");
      out.write("				<td>");
      out.print( title );
      out.write("</td>\r\n");
      out.write("				<td>");
      out.print( writer );
      out.write("</td>\r\n");
      out.write("				<td>");
      out.print( date );
      out.write("</td>\r\n");
      out.write("			</tr>\r\n");
      out.write("			\r\n");
      out.write("		<!--\r\n");
      out.write("			<tr>\r\n");
      out.write("				<td>");
      out.print( rs.getInt("no") );
      out.write("</td>\r\n");
      out.write("				<td>");
      out.print( rs.getString("title") );
      out.write("</td>\r\n");
      out.write("				<td>");
      out.print( rs.getString("writer") );
      out.write("</td>\r\n");
      out.write("				<td>");
      out.print( rs.getString("reg_date") );
      out.write("</td>\r\n");
      out.write("			</tr>\r\n");
      out.write("		-->\r\n");
      out.write("			");
 } 
      out.write("\r\n");
      out.write("		</table>\r\n");
      out.write("		\r\n");
      out.write("		<!-- <a href=\"#\">새글등록</a> -->\r\n");
      out.write("		<br>\r\n");
      out.write("		<br>\r\n");
      out.write("		<button onclick=\"goWriterForm()\">새글등록</button>\r\n");
      out.write("		\r\n");
      out.write("	</div>\r\n");
      out.write("		\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");

	JDBCClose.close(pstmt, conn);

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
