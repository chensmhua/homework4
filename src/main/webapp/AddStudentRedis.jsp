<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加学生</title>

 <script type="text/javascript">
 function myCheck()
 {
   for(var i=0;i<document.form1.elements.length-1;i++)
   {
    if(document.form1.elements[i].value=="")
    {
      alert("当前表单不能有空项");
      document.form1.elements[i].focus();
      return false;
    }
   }
   return true;
   
 }

</script>



</head>
<body>

<form action="StudentAddServletRedis" method="post" name="form1" onSubmit="return myCheck()">
<table>
 <tr>
	<td><input type="text" name="id" id="t1" placeholder="请添加平均分数"></td>
 </tr>	
 <tr>
	<td><input type="text" name="name" id="t2" placeholder="请输入名称"></td>
 </tr>	
 <tr>
	<td><input type="text" name="birthday" id="t3" placeholder="格式为年/月/日"></td>
 </tr>	
 <tr>
	<td><input type="text" name="description" id="t4" placeholder="请输入备注"></td>
 </tr>
 <tr>
	<td><input type="text" name="avgscore" id="t5" placeholder="请输入id"></td>
 </tr>
 <tr>
	<td><button type="submit" >提交</button></td>
 </tr>
</table>
</form>
</body>
</html>