<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*,bean.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
</head>

<body>
<%
user u=new user();
u=(user)session.getAttribute("user");

%>
<p>用户：
<% if (u==null){ out.println("<a href='../../shopping_cart/login.html';>访客请登录</a>");}
else{
	out.println(u.getUsername()+"		ID:"+u.getID());
	out.println("&nbsp;&nbsp;&nbsp;&nbsp; <a href='../../shopping_cart/shop/mycart.jsp';>购物车</a>");
	out.println("&nbsp;&nbsp;&nbsp;&nbsp; <a href='../shopping_cart/exit_logon'>退出登录</a>");
}
	%>	
	
	
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	          <a href="../../shopping_cart/shop/index.jsp">大猫商城主页</a></p>
<hr />
<p>&nbsp;</p>
</body>
</html>