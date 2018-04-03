<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.* ,bean.*,java.util.*,one.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>大猫购物商城|搜索结果</title>
</head>

<body>

<%@ include file="usertop.jsp" %>
<%@ include file="search_textfield.jsp" %>
<%
request.setCharacterEncoding("utf-8");
response.setContentType("text/html;charset=utf-8");
%>
<form id="form1" name="form1" method="post" action="selectgood">
<center>
<table width="500" height="288" border="1">



<%
	ArrayList l= (ArrayList)request.getAttribute("return_list");
	
//绘制商品列表
  for(Object good : l){
		goodbean g=(goodbean)good;

	  %>
	  
	  <tr>
	      <td height='23' colspan='2'>&nbsp;
	      </td>     
	  </tr>
	  
	  <tr>
	      <td colspan='2'> 
	      <center>
	      <img src='<%=g.getGood_image() %>' />
	      </center>
	      </td>
	  </tr>
	  
	  <tr>
	      <td width='218'><%=g.getGood_name() %>
	      </td>
	      <td  width='81'>售价<%=g.getGood_price() %>元
	      </td>
	  </tr>
	  
	  <tr>
	      <td colspan='2'><%=g.getGood_description() %>
	      </td>
	  </tr>
	  
	  <tr>
	      <td height='53' colspan='2'> 
	      <%  //如果没登录，将跳转到登录页面
	      if(u==null){
	    	     out.println("<a href='../../shopping_cart/login.html'>请先登录再点击购买</a>");
	      }
	    	 else{
	    		 out.println("<a href='../../shopping_cart/shop/good.jsp?good_ID="+g.getGood_ID()+ "'>点击购买</a>");
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