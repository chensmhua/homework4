<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>跟新界面</title>
</head>
<body>
<h3>请修改内容</h3>
<form action="StudentAddServletRedis" method="post">
<table>
 <tr>
	<td><input type="text" name="id" placeholder="请修改平均分数"></td>
 </tr>	
 <tr>
	<td><input type="text" name="name" placeholder="请修改名称"></td>
 </tr>	
 <tr>
	<td><input type="text" name="birthday" placeholder="请修改出生年月"></td>
 </tr>	
 <tr>
	<td><input type="text" name="description" placeholder="请修改备注"></td>
 </tr>
 <tr>
	<td><input type="text" name="avgscore" placeholder="请修改id"></td>
 </tr>
 <tr>
	<td><button type="submit">提交</button></td>
 </tr>
</table>
</body>
</html>