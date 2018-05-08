package com.biz.driver;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

public class MysqlDriver {
	
	
	//��ȡ����
			public static Connection getConnection(){
				Connection connection = null;
				try {
					Class.forName("com.mysql.jdbc.Driver");
					connection =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/chenhuadong","root","");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return connection;
			}
	
    
  //�ر�ResultSet(��¼��)����
  		public static void closeResultSet(ResultSet rs){
  			if(rs != null){
  				try {
  					rs.close();
  				} catch (SQLException e) {
  					// TODO Auto-generated catch block
  					e.printStackTrace();
  				}
  			}
  		}
  		
  		//�ر�Statement����
  		public static void closeStatement(Statement stmt){
  			if(stmt != null){
  				try {
  					stmt.close();
  				} catch (SQLException e) {
  					// TODO Auto-generated catch block
  					e.printStackTrace();
  				}
  			}
  		}
  		
  		//�ر�Connection����
  		public static void closeConnection(java.sql.Connection connection){
  			try {
  				if(connection != null && !connection.isClosed()){
  					connection.close();
  				}
  			} catch (SQLException e) {
  				// TODO Auto-generated catch block
  				e.printStackTrace();
  			}
  		}
    
}
