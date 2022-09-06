package com.maven.Student;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;



public class ConnectionJdbc {
	
	
	
	public static void main(String[] args) throws IOException {
		
		
		System.out.println(ConnectionJdbc.get_connection());
	}
	
	
		
	public static Connection get_connection() throws IOException {
			
			Properties p=new Properties();
			
	
			InputStream is=new FileInputStream("C:\\Users\\Mohan\\eclipse-workspace\\Student\\Config.properties");
			
			p.load(is);
			
				
			String url=p.getProperty("url" );
			String uname=p.getProperty("uname");
			String pass=p.getProperty("pass");

			
			
			Connection connection=null ;
			
			try {
				
				Class.forName("org.postgresql.Driver");
				
				connection = DriverManager.getConnection(url , uname , pass);
				
				
				if(connection !=null) {
					
//					System.out.println("connection ok");
				}
				else {
//					System.out.println("connection failed");
				}
				
			}
			catch(Exception e) {
				
				e.printStackTrace();
			}
			
			return connection;
		}
		
	
}
