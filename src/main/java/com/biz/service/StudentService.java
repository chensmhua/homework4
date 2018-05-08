package com.biz.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.biz.driver.MysqlDriver;
import com.biz.entity.Student;


public class StudentService {

	//显示学生信息
	public List<Student> showStudent(Student display)
	{
		
		List<Student> students = new ArrayList<Student>();
		//使用MysqlDriver工具连接mysql数据库
		Connection connection  = MysqlDriver.getConnection();
		Statement stmt = null;
		//获取集合
		ResultSet rs = null;
		Student student =null;
		try
		{
			stmt = connection.createStatement();
			//显示学生信息的sql语句
			String sql ="select * from student";
			rs = stmt.executeQuery(sql);
			//循环遍历
			while(rs.next())
			{
				String id=rs.getString("id");
				String name =rs.getString("name");
				String birthday = rs.getString("birthday");
				String description =rs.getString("description");
				int avgescore = rs.getInt("avgescore");
				
				student = new Student(id,name,birthday,description,avgescore);
				students.add(student);
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			//关闭资源
			MysqlDriver.closeResultSet(rs);
			MysqlDriver.closeStatement(stmt);
			MysqlDriver.closeConnection(connection);
			
		}
		return students;
	}
	
	
	
	//修改学生信息
	
}
