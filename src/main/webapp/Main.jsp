<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
</head>

<body>
<center>
<h3>欢迎进入学生信息管理</h3>
<form name="show" action="StudentShowServlet" method="post">
	<button type="submit">展	示</button>
</form>
<br/>
<br/>
<input type="button" onclick="window.location.href='AddStudentRedis.jsp'" value="添  加">
</center>
</body>
</html>