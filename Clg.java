package com.maven.Student;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Clg {
	
	static ConnectionJdbc obj = new ConnectionJdbc();

	static Connection connection=null;
	
	PreparedStatement ps=null;
	
	ResultSet rs=null;
	
//	static Clg clg=new Clg();
	
	static List<ClgDao> lstclgdao;
	
	public void readall() throws IOException, SQLException {
		
		connection=ConnectionJdbc.get_connection();
		
		String query="select * from clg;";
		
		Statement st=connection.createStatement();
		
		rs=st.executeQuery(query);
		
		lstclgdao=new ArrayList<>();
		
		ClgDao clgdaobj;
		
		while(rs.next()) {
			
			int clgid= Integer.parseInt(rs.getString(2));
			
			clgdaobj=new ClgDao(rs.getString(1),clgid,rs.getString(3),rs.getString(4));
			
			System.out.println(rs.getString(1)+"\t\t"+clgid+"\t\t"+rs.getString(3)+"\t\t"+rs.getString(4));
			
			
			lstclgdao.add(clgdaobj);
		}
		
		
	}

	public ClgDao clgpost(String clgname, int clgid, String clglocation, String clgmobno) throws IOException {
		
		
		connection=obj.get_connection();
		
		String query="insert into clg values ( ? , ?  , ? , ? ) ; ";
		
		try {
			ps=connection.prepareStatement(query);
			ps.setString(1, clgname);
			ps.setInt(2, clgid);
			ps.setString(3, clglocation);
			ps.setString(4, clgmobno);
			
			ps.executeUpdate();
			
			Clg clg=new Clg();
			
			return clg.clgparticular(clgid);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
			return null;
		}
		
		
		
		
	}

	public ClgDao clgparticular(int id) throws SQLException, IOException {
		
		ClgDao clgdaoobj = null;
		
		connection=obj.get_connection();
		
		String query="select * from clg where clgid = ? ;";
		
		ps=connection.prepareStatement(query);
		
		ps.setInt(1, id);
		
		rs=ps.executeQuery();
		
		while(rs.next()) {
			
			int clgid=Integer.parseInt(rs.getString(2));
			
			clgdaoobj=new ClgDao(rs.getString(1) , clgid , rs.getString(3) , rs.getString(4));
			
			
		}
		
		
		return clgdaoobj;
	}

	
	public ClgDao clgparticularname(String clgname) throws SQLException, IOException {
		
		ClgDao clgdaoobj = null;
		
		connection=obj.get_connection();
		
		String query="select * from clg where clgname = ? ;";
		
		ps=connection.prepareStatement(query);
		
		ps.setString(1, clgname);
		
		rs=ps.executeQuery();
		
		while(rs.next()) {
			
			int clgid=Integer.parseInt(rs.getString(2));
			
			clgdaoobj=new ClgDao(rs.getString(1) , clgid , rs.getString(3) , rs.getString(4));
			
			
		}
		
		
		return clgdaoobj;
	}
	
	
	
	
	
	public Object clgdelete(int id) throws IOException, SQLException {
		
		
		connection=obj.get_connection();
		
		String query="delete from clg where clgid = ? ;";
		
		ps=connection.prepareStatement(query);
		
		ps.setInt(1, id);
		
		ps.executeUpdate();
		
		System.out.println("Deleted Succesfully");
		
		return " Deleted Succesfully ";
		
	}
	
	
	public void clgupdate(ClgDao clgdaoobj) throws IOException, SQLException {
		
		connection=obj.get_connection();
		
		String query="update clg set clgname = ? , clglocation = ? , clgmobno = ? where clgid = ? ; ";
		
		ps=connection.prepareStatement(query);
		
		ps.setObject(1, clgdaoobj.getClgname());
		ps.setObject(2, clgdaoobj.getClglocation());
		ps.setObject(3, clgdaoobj.getClgmobno());
		ps.setObject(4, clgdaoobj.getClgid());
		
		ps.executeUpdate();
		
		System.out.println("updated succesfully");
		
	}
	
	

}











































