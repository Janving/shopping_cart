<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*,one.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>商品详情页</title>
</head>

<body>

<%@ include file="usertop.jsp" %>


<%
request.setCharacterEncoding("utf-8");
response.setContentType("text/html;charset=utf-8");


//从url中获得
int good_ID=Integer.parseInt(request.getParameter("good_ID"));

String good_name="";
float good_price;
String good_description="";
String good_image="";

String sql="SELECT * FROM web.good where good_ID='"+good_ID+"'";

Connection conn=mysqlconnect.connect();
Statement st= conn.createStatement();
ResultSet rs;
rs=st.executeQuery(sql);

good_price=(float)0;

while(rs.next()){
	  good_name=rs.getString("good_name");
	  good_price=rs.getFloat("good_price");
	  good_description=rs.getString("good_description");
	  good_image=rs.getString("good_image");
}

//System.out.println("good_id:"+good_ID);
session.setAttribute("buy_good_ID",good_ID);

%>
<center>
<form id="form1" name="form1" method="post" action="../add_shop_info">
  <p>&nbsp;</p>
  <table width="472" height="119" border="1">
    <tr>
      <td colspan="2">  <img src='<%= good_image%>'/></td>
    </tr>
    <tr>
      <td width="232"><%= good_name%></td>
      <td width="224">价格：<%= good_price %>元</td>
    </tr>
    <tr>
      <td colspan="2"><%= good_description%></td>
    </tr>
    <tr>
      <td>数量：
        <label for="textfield"></label>
      <input name="count_text" type="text" id="count_text" value="1" /></td>
      <td><input type="submit" name="button" id="button" value="点击添加到购物车" /></td>
    </tr>
  </table>
  <p></p>
</form>
</center>
<p>&nbsp;</p>
</body>
</html>