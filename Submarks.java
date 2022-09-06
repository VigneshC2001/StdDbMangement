package com.maven.Student;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Submarks {

	
	static ConnectionJdbc obj=new ConnectionJdbc();
	
	static Connection connection=null;
	
	Statement statement=null;
	
	ResultSet rs=null;
	
	PreparedStatement ps=null;
	
	static List<SubmarksDao> submarksdetails;
	
	public void getsubmarks() throws IOException, SQLException {
		
		connection=ConnectionJdbc.get_connection();
		
		String query="select * from submarks";
		
		statement=connection.createStatement();
		
		rs=statement.executeQuery(query);
		
		submarksdetails=new ArrayList<>();
		
		SubmarksDao submarksdao;
		
		while(rs.next()) {
			
			int stdid=Integer.parseInt(rs.getString(1));
			
			int submarks=Integer.parseInt(rs.getString(3));
			
			submarksdao=new SubmarksDao(stdid,rs.getString(2),submarks);
			
			System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
			
			submarksdetails.add(submarksdao);
			
		}
		
	}

	public void submarkspost(int stdid, String subid, int submarks) throws IOException, SQLException {
		
		connection=obj.get_connection();
		
		String query="insert into submarks values  ( ? , ? , ? ) ; ";
		
		ps=connection.prepareStatement(query);
		
		ps.setInt(1, stdid);
		ps.setString(2, subid);
		ps.setInt(3, submarks);
		
		ps.executeUpdate();
		
		System.out.println("value inserted succesfully");
		
	}

	public List<SubmarksDao> submarksparticular(int id) throws IOException, SQLException {
		
		SubmarksDao submarksdaoobj=null;
		
		connection=obj.get_connection();
		
		String query="select * from submarks where stdid = ? ;";
		
		ps=connection.prepareStatement(query);
		
		ps.setInt(1, id);
		
		rs=ps.executeQuery();
		
		submarksdetails=new ArrayList<>();
		
		while(rs.next()) {
			
			int stdid=Integer.parseInt(rs.getString(1));
			int submarks=Integer.parseInt(rs.getString(3));
			
			submarksdaoobj=new SubmarksDao(stdid,rs.getString(2),submarks);
			
			submarksdetails.add(submarksdaoobj);
			
			System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
		}
		
		return submarksdetails;
	}
	public SubmarksDao submarkparticularstdsub(int studentdid , String subid) throws IOException {
		
		
		connection=obj.get_connection();
		
		String query="select * from submarks where stdid = ? and subid = ? ; ";
		
		try {
			ps=connection.prepareStatement(query);
			ps.setInt(1, studentdid);
			ps.setString(2, subid);
			rs=ps.executeQuery();
			
			SubmarksDao submarksdaoobj=null;
			
			while(rs.next()) {
				
				int stdid=Integer.parseInt(rs.getString(1));
				int submarks=Integer.parseInt(rs.getString(3));
				
				submarksdaoobj=new SubmarksDao(stdid,rs.getString(2),submarks);
				
				System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
			}
			
			return submarksdaoobj;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
			return null;
		}
		
		
	
	}
	

	public void submarksdelete(int stdid , String subid) throws IOException, SQLException {
		
		
		connection=obj.get_connection();
		
		String query="delete from submarks where stdid = ? and subid = ? ; ";
		
		ps=connection.prepareStatement(query);
		
		ps.setInt(1, stdid);
		ps.setString(2, subid);
		
		ps.executeUpdate();
		
		System.out.println("Deleted Succesfully");
		
	}
	
	
	public void submarksupdate(SubmarksDao submarksobj) throws SQLException, IOException {
		
		connection=obj.get_connection();
		
		String query="update submarks set   submarks = ?  where stdid = ? and subid = ?  ;";
		
		ps=connection.prepareStatement(query);
		
		ps.setObject(1, submarksobj.getSubmarks());
		
		ps.setObject(2, submarksobj.getStdid());
		
		ps.setObject(3, submarksobj.getSubid());
		
		ps.executeUpdate();
		
		System.out.println("updated succesfully");
	}

}

















