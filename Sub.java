package com.maven.Student;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Sub {

	
	
	static ConnectionJdbc obj=new ConnectionJdbc();
	
	static Connection connection=null;
	
	Statement statement=null;
	
	ResultSet rs=null;
	
	PreparedStatement ps=null;
	
	static List<SubDao> subdetails;
	
	public void getsub() throws IOException, SQLException {
		
		connection=ConnectionJdbc.get_connection();
		
		String query="select * from sub";
		
		statement=connection.createStatement();
		
		rs=statement.executeQuery(query);
		
		subdetails=new ArrayList<>();
		
		SubDao subdao;
		
		while(rs.next()) {
			
			System.out.println(rs.getString(1)+"\t"+rs.getString(2));
			
			subdao=new SubDao(rs.getString(1),rs.getString(2));
			
			subdetails.add(subdao);
			
		}
		
		
	}

	public Object subpost(String subid, String subname) throws IOException {
		
		connection=obj.get_connection();
		
		String query="insert into sub values ( ? , ? ) ;";
		
		try {
			ps=connection.prepareStatement(query);
			ps.setString(1, subid);
			ps.setString(2, subname);
			
			ps.executeUpdate();
			
			System.out.println("Value inserted succesfully");
			Sub subobj=new Sub();
			return subobj.subparticular(subid);
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		}
		
		
	}

	public SubDao  subparticular(String subid) throws IOException{
		
		SubDao subdaoobj = null;
		
		connection=obj.get_connection();
		
		String query="select * from sub where subid = ? ;";
		
		try {
			ps=connection.prepareStatement(query);
			ps.setString(1, subid);
			
			rs=ps.executeQuery();
			
			while(rs.next()) {
				
				subdaoobj=new SubDao(rs.getString(1),rs.getString(2));
				
			}
			
			return subdaoobj;
		} catch (SQLException e) {
			
			e.printStackTrace();
			
			return null;
		}
		
		
	}

	public void subdelete(String id) throws IOException, SQLException {
		
		connection=obj.get_connection();
		
		String query="delete from sub where subid = ? ;";
		
		ps=connection.prepareStatement(query);
		
		ps.setString(1, id);
		
		ps.executeUpdate();
		
		System.out.println("Deleted Succesfully");
		
	}

}









