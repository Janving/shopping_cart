<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>???????</title>
</head>

<body>

<jsp:useBean id="user" class="userclass.user" scope="request"/>
用户名：	<jsp:getProperty name="user" property="username"/>
<p>&nbsp;</p>
<form id="form1" name="form1" method="post" action="admin">
  <p>
    <input type="submit" name="add" id="button" value="添加信息" />
  （ID:110301;姓名：李；密码：110301）</p>


  <p>
    <input type="submit" name="change" id="change" value="修改信息" />
  （把李的密码改为123456）</p>


  <p>
    <input type="submit" name="delete" id="delete" value="删除信息" />
  （删除用户李信息） </p>
</form>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<hr />
<center>
<p><a href="login.html">登录</a> | <a href="register.html">注册</a></p>
<p>没有到公安局备案</p>
</center>
</body>
</html>