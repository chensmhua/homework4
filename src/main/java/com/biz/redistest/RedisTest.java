package com.biz.redistest;

import java.util.Date;

import com.biz.entity.Student;
import com.biz.service.StudentRedisService;

public class RedisTest {
	
	    
	    public static void main(String[] args) {
	    	Student student = new Student();
	        StudentRedisService studentRedisService = new StudentRedisService();
	        studentRedisService.connectRedis();
	        
	         studentRedisService.AddStudents(student, 1, "1,chenhuadong,2001/02/03,����Ա,100");
	       //ɾ��
	       //ɾ��  studentRedisService.DeleteStudent(student,"1.*");
	      //��ѯ 
	        studentRedisService.QueryStudent(student);
	    }
}
