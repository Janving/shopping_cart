<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*,one.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>我的购物车</title>
</head>

<body>
<%@ include file="usertop.jsp" %>

<%
request.setCharacterEncoding("utf-8");
response.setContentType("text/html;charset=utf-8");

String good_name;
float good_price;
String good_description;
String good_image;
int good_ID=0;
int user_ID=0;
float sum=0;
int count=0;
int cart_ID=0;
int list=1;


user_ID=u.getID();
System.out.println("mycart_user_ID:"+user_ID);

String sql3="SELECT * FROM web.shopping_cart ,web.good where shopping_cart.good_ID=web.good.good_ID and purchaser_ID='"+user_ID+"'";
Connection conn=mysqlconnect.connect();
Statement st= conn.createStatement();

ResultSet rs;
rs=st.executeQuery(sql3);


%>


<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>

<center>
<table width="499" border="1">
 
  
  <% 
  //根据用户ID得到购物车信息
while(rs.next()){
	out.println("<form id='form"+list+"' name='form"+list+"' method='post' action='../../shopping_cart/setshop'>");
	count=rs.getInt("count");
	good_name=rs.getString("good_name");
	good_price=rs.getFloat("good_price");
	good_image=rs.getString("good_image");
	good_ID=rs.getInt("good_ID");
	cart_ID=rs.getInt("cart_ID");
	
	mycart mc=new mycart(good_ID,cart_ID);
	session.setAttribute(""+list,mc);

	
	sum=sum+count*good_price;
	//绘制购物车
	out.println("<tr>");
	out.println("<td width='200' rowspan='2'><img src="+good_image+" width='200' height='150'/></td>");
	out.println("<td height='54' colspan='2'>"+good_name+"</td>");
	out.println(" </tr>    <tr>");
	out.println( "<td width='126'>价格："+good_price+"元</td>");
	out.println("<td width='151'>数量："+" <input name='count"+list+"' type='text' id='count"+list+"' value='"+count+"' /> ");
	
	out.println("<input type='submit' name='button"+list+"' id='button"+list+"' value='更改购买数量'  />");
	out.println("<input type='submit' name='button_delete"+list+"' id='button_delete"+list+"' value='删除'  />");
	out.println("</form>");
	System.out.println(count+"  "+good_name+"  " + sum);
	list++;
}
  
  //如果是空的
  if (list==1){
	  out.println("购物车是空的！");
  }
  
  %>
</table>


总价：<%= sum %>
</center>

<p>&nbsp;</p>
</body>
</html>