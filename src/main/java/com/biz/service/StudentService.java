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

	//��ʾѧ����Ϣ
	public List<Student> showStudent(Student display)
	{
		
		List<Student> students = new ArrayList<Student>();
		//ʹ��MysqlDriver��������mysql���ݿ�
		Connection connection  = MysqlDriver.getConnection();
		Statement stmt = null;
		//��ȡ����
		ResultSet rs = null;
		Student student =null;
		try
		{
			stmt = connection.createStatement();
			//��ʾѧ����Ϣ��sql���
			String sql ="select * from student";
			rs = stmt.executeQuery(sql);
			//ѭ������
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
			//�ر���Դ
			MysqlDriver.closeResultSet(rs);
			MysqlDriver.closeStatement(stmt);
			MysqlDriver.closeConnection(connection);
			
		}
		return students;
	}
	
	
	
	//�޸�ѧ����Ϣ
	
}
