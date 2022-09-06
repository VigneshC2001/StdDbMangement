package com.maven.Student;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Student {
	
	static ConnectionJdbc obj=new ConnectionJdbc();
	
	static Connection connection=null;
	
	Statement statement=null;
	
	ResultSet rs=null;
	
	PreparedStatement ps=null;
	
	static List<StdDb> stddetails;
	
	
	
	public void getstd() throws SQLException, IOException {
		
		connection=ConnectionJdbc.get_connection();
		
		String query="select * from student";
		
		statement=connection.createStatement();
		
		rs=statement.executeQuery(query);
		
		stddetails=new ArrayList<>();
		
		StdDb stddb;
				
		while(rs.next()) {
			
			int stdid=Integer.parseInt(rs.getString(1));
			
			stddb=new StdDb(stdid,rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
			
			System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+" \t"+rs.getString(6));
			
			stddetails.add(stddb);
		}
	}
	

	public StdDb stdpost( String stdname, String stddept, String stdyear, String stdmobno , String stdclgname) throws IOException {
		
		connection=obj.get_connection();
		
		
		String query="insert into student"+"(stdname,stddept,stdyear,stdmobno,stdclgname) values"+ "(?,?,?,?,?);";
		
		try {
			
			ps=connection.prepareStatement(query);
			
			ps.setString(1, stdname);
			ps.setString(2, stddept);
			ps.setString(3, stdyear);
			ps.setString(4, stdmobno);
			ps.setString(5, stdclgname);
			
			ps.executeUpdate();
			
			System.out.println("value inserted succesfully");
			
			Student std=new Student();
			
			return  std.stdparticularmobno(stdmobno);
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			
			e.printStackTrace();
			
			return null;
//			return e.getMessage();
		}
		
	}
public  StdDb stdparticularmobno(String mobno) throws IOException {
		
		StdDb stddbobj = null;
		
		connection=obj.get_connection();
		
		String query="select * from student where stdmobno = ? ;";
		
		try {
			ps=connection.prepareStatement(query);
			
			ps.setString(1, mobno);
			
			rs=ps.executeQuery();
			
			while(rs.next()) {
				
				int stdid=Integer.parseInt(rs.getString(1));
				
				
				stddbobj=new StdDb(stdid,rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
			
			
			}
			return stddbobj;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
			System.out.println(e.getMessage());
			
			return null;
		}
		
		
	}
	
	public  StdDb stdparticular(int index) throws IOException {
		
		StdDb stddbobj = null;
		
		connection=obj.get_connection();
		
		String query="select * from student where stdid = ? ;";
		
		try {
			ps=connection.prepareStatement(query);
			
			ps.setInt(1, index);
			
			rs=ps.executeQuery();
			
			while(rs.next()) {
				
				int stdid=Integer.parseInt(rs.getString(1));
				
				stddbobj=new StdDb(stdid,rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
			
			
			}
			return stddbobj;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
			System.out.println(e.getMessage());
			
			return null;
		}
		
		
	}
	
	public void stdupdate(StdDb stdobj) throws SQLException, IOException {
		
			connection=obj.get_connection();
			
			String query="update student set stdname = ? , stddept = ? , stdyear = ? , stdmobno = ? , stdclgname = ? where stdid = ? ;";
			
			ps=connection.prepareStatement(query);
			
			ps.setObject(1, stdobj.getStdname());
			
			ps.setObject(2, stdobj.getStddept());
			
			ps.setObject(3, stdobj.getStdyear());
			
			ps.setObject(4,stdobj.getStdmobno());

			ps.setObject(5, stdobj.getStdclgname());
			
			ps.setInt(6,stdobj.getStdid() );
			
			ps.executeUpdate();
			
			System.out.println("updated succesfully");
			
		
	}
	
	public Object stddelete(int id) throws IOException, SQLException {
		
		connection=obj.get_connection();
		
		String query="delete from student where stdid = ? ;";
		
		ps=connection.prepareStatement(query);
		
		ps.setInt(1, id);
		
		ps.executeUpdate();
		
		System.out.println("'STUDENT DATA' Deleted Succesfully");
		
		return "'STUDENT DATA' Deleted Succesfully";
		
	}
	
	
		
}









