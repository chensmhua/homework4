package com.biz.redistest;

import java.util.Date;

import com.biz.entity.Student;
import com.biz.service.StudentRedisService;

public class RedisTest {
	
	    
	    public static void main(String[] args) {
	    	Student student = new Student();
	        StudentRedisService studentRedisService = new StudentRedisService();
	        studentRedisService.connectRedis();
	        
	         studentRedisService.AddStudents(student, 1, "1,chenhuadong,2001/02/03,³ÌÐòÔ±,100");
	       //É¾³ý
	       //É¾³ý  studentRedisService.DeleteStudent(student,"1.*");
	      //²éÑ¯ 
	        studentRedisService.QueryStudent(student);
	    }
}
