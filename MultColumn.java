package com.maven.Student;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MultColumn {
	
	
	static ConnectionJdbc obj=new ConnectionJdbc();
	
	static Connection connection=null;
	
	Statement statement=null;
	
	ResultSet rs=null;
	
	PreparedStatement ps=null;
	
	static List<String> strclm;
	
	
	public List<String> checkcolumn(String clname , String tbname) throws IOException{
		
		connection=obj.get_connection();
		
		String query="select " + clname +" from "+ tbname;
		
		try {
			statement=connection.createStatement();
			
			rs=statement.executeQuery(query);
			ResultSetMetaData rsMetaData = rs.getMetaData();
			
			 if(rsMetaData.getColumnName(1).equals(clname)) {
				 
				 strclm.add("SUCCESS");
	        	 return strclm ;
	         }
			 else {
				 return null;
			 }
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		}
		
	}
	
	
	
	public  List<String> singlestrcolumn(String clname , String tbname) throws IOException {
	
		
		strclm=new ArrayList<String>();
		
		connection=obj.get_connection();
		
		String query="select " + clname +" from "+ tbname;
		
		try {
			statement=connection.createStatement();
			
			rs=statement.executeQuery(query);
			
			
			
			while(rs.next()) {
				
				System.out.println(rs.getString(1));
				
				strclm.add(rs.getString(1));
			
			}
			
			return strclm;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
			System.out.println(e.getMessage());
			
			return null;
		}
		
	}
	

	
}
