<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.* ,util.*,one.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>大猫购物商城</title>
</head>

<body>

<%@ include file="usertop.jsp" %>
<%@ include file="search_textfield.jsp" %>
<%
request.setCharacterEncoding("utf-8");
response.setContentType("text/html;charset=utf-8");

String sql="SELECT * FROM web.good order by good_ID desc limit 10";

String good_name;
float good_price;
String good_description;
String good_image;
int good_ID;


ResultSet rs;
rs=DBUtil.commonQuery(sql, null);


%>
<form id="form1" name="form1" method="post" action="">
<center>
<table width="500" height="288" border="1">
  
 <%
  
  //绘制商品列表
  while(rs.next()){
	  good_name=rs.getString("good_name");
	  good_price=rs.getFloat("good_price");
	  good_description=rs.getString("good_description");
	  good_image=rs.getString("good_image");
	  good_ID=rs.getInt("good_ID");
	  
	  %>
	  
	  <tr>
	      <td height='23' colspan='2'>&nbsp;
	      </td>
	      
	  </tr>
	  
	  <tr>
	      <td colspan='2'> 
	      <center>
	      <img src='<%=good_image %>' />
	      </center>
	      </td>
	  
	  </tr>
	  
	  <tr>
	      <td width='218'><%=good_name %>
	      
	      </td>
	      
	      <td  width='81'>售价<%=good_price %>元
	      
	      </td>
	  
	  </tr>
	  
	  <tr>
	      <td colspan='2'><%=good_description %>
	      </td>
	 
	  </tr>
	  
	  
	  <tr>
	      <td height='53' colspan='2'> 
	        
	 
	      <%  //如果没登录，将跳转到登录页面
	      if(u==null){
	    	     out.println("<a href='../../shopping_cart/login.html'>请先登录再点击购买</a>");
	      }
	    	 else{
	    		 out.println("<a href='../../shopping_cart/shop/good.jsp?good_ID="+good_ID+ "'>点击购买</a>");
	    	 }
	    	  %>
	      
	  
	 	
	      </td>
	  
	 
	  </tr>
	  
	  
	  
 <% }%>
  
 
  
  
</table>
<p>&nbsp;</p>
</center>
  <p>&nbsp;</p>
  <p>&nbsp;</p>
</form>
<p>&nbsp;</p>
<p>&nbsp;</p>

</body>
</html>