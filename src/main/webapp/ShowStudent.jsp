<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.biz.entity.Student" %>
<%@page import="java.util.List"%>
<%@page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生信息展示</title>
<script type="text/javascript" src="jquery-3.3.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	
	$("#first").click(function(){
	
		 var currPage=$("#currPage").val();
		
		if(currPage==1){
			alert("已经是第一页了");
		} else{
			
			$("#first").attr("href","StudentShowServlet?pageNumber=1");
			
		}
			
	}); 
	
	
	$("#before").click(function(){
		
		var currPage=$("#currPage").val();
		
		if(currPage<=1||currPage==null)
		{
			alert("已经是第一页了,兄dei~");
			}else{
				currPage--;
				$("#before").attr("href","StudentShowServlet?pageNumber="+currPage);
			}
	});
	
	
	$("#after").click(function(){
		var currPage=$("#currPage").val();
		var maxPage = $("#sumPage").val();
		if(currPage>=maxPage||currPage==null){
			alert("这是最后一页，再点就没了");
		}else{
			currPage++;
			$("#after").attr("href","StudentShowServlet?pageNumber="+currPage);
		}
	});
	
	$("#last").click(function(){
		var currPage=$("#currPage").val();
		var maxPage = $("#sumPage").val();
		if(currPage==maxPage){
			alert("这是尾页")
		}else{
			$("#last").attr("href","StudentShowServlet?pageNumber="+maxPage);
		}
	});
	
	
	$("#choose").click(function(){
		var mychoose = document.getElementById("input").value;
		var cuurPage = $("#currPage").val();
		var maxPage = $("#sumPage").val();
		
		if(mychoose>=1||mychoose<=maxpage){
			
			$("#choose").attr("href","StudentShowServlet?pageNumber="+mychoose);
		}
	});
});


</script>
</head>
<body>
<table border="1">
	<tr><td>
	<input type="button" onclick="window.location.href='Main.jsp'" value="返回主界面">  	
	<input type="button" onclick="window.location.href='AddStudentRedis.jsp'" value="添  加">  
  	</td></tr>
	<tr>
	<td>学生分数</td>
	<td>学生姓名</td>
	<td>出生日期</td>
	<td>备        注</td>
	<td>学生id</td>
	</tr>
<% 
	List<Student> students =(List<Student>) request.getAttribute("ADD");
	Integer currentPage =(Integer)request.getAttribute("CURRENT");
	Long maxPage =(Long) request.getAttribute("MAX");
	
	if(students!=null&&students.size()>0)
	{
		for(int i=0;i<students.size();i++){
		Student student = students.get(i);
%>

	<tr>
	<td><%=student.getId() %></td>
	<td><%=student.getName() %></td>
	<td><%=student.getBirthday() %></td>
	<td><%=student.getDescription() %></td>
	<td><%=student.getAvgescore() %></td>
	<td><input type="button" name="del" onclick="window.location.href='StudentDeleteServlet?id=<%=student.getId() %>&name=<%=student.getName() %>&birthday=<%=student.getBirthday() %>&description=<%=student.getDescription() %>&avgscore=<%=student.getAvgescore() %>'" value="删  除"></td>
	<td><input type="button" name="update" onclick="window.location.href='StudentUpdateServlet?id=<%=student.getId() %>&name=<%=student.getName() %>&birthday=<%=student.getBirthday() %>&description=<%=student.getDescription() %>&avgscore=<%=student.getAvgescore() %>'" value="修  改"></td>
	
	</tr>
	<%
	  }
  	}
  %>  
  	
  	<tr>
  	<td><a href="" id="first">首页</a></td>
  	<td><a href="" id="before">上一页</a></td>
  	<td><a href="" id="after">下一页</a></td>
  	<td><a href="" id="last">尾页</a></td>
  	<td>
  	总页数：<input type="text" id="sumPage" readonly="value" style="width:6px;" value="<%=maxPage %>"/>
  	当前页数：<input type="text" id="currPage"  readonly="value" style="width:6px;" value="<%=currentPage %>"/>
  	</td>
  	<td><input type ="text" id="input" placeholder="请输入您想跳转的界面" style="width:60px;"></td>
  	<td><a href="" id="choose">跳转</a></td>
  	</tr>
  	
  	
  	
  	
  	
  	
  	
</table>
</body>
</html>