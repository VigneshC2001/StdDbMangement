package com.maven.Student;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public class FullDetails {
	
	
	static ConnectionJdbc obj=new ConnectionJdbc();
	
	static Connection connection=null;
	
	Statement statement=null;
	
	ResultSet rs=null;
	
	PreparedStatement ps=null;
	
	static List<FullDao> fulldetails;
	
	static List<FullDaoRank> fulldetailsrank;
	
	public void getfulldetails() throws IOException, SQLException {
		
		
		connection=ConnectionJdbc.get_connection();
		
		String query="select student.stdid,student.stdname,student.stddept,student.stdyear,student.stdmobno,sub.subid,sub.subname,submarks.submarks,clg.clgid,student.stdclgname from ((student inner join submarks on student.stdid=submarks.stdid) inner join sub on sub.subid=submarks.subid )inner join clg on clg.clgname=student.stdclgname ; ";
		
		statement=connection.createStatement();
		
		rs=statement.executeQuery(query);
		
		fulldetails=new ArrayList<>();
		
		FullDao fulldao;
		
		while(rs.next()) {
			
			int stdid=Integer.parseInt(rs.getString(1));
			
			int clgid=Integer.parseInt(rs.getString(8));
			
			int submarks=Integer.parseInt(rs.getString(9));
			
			System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6)+"\t"+rs.getString(7)+"\t"+rs.getString(8)+"\t"+rs.getString(9)+"\t"+rs.getString(10));
			
			fulldao=new FullDao(stdid,rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),clgid, submarks ,rs.getString(10));
			
			fulldetails.add(fulldao);
		}
		
	}


	public List<FullDao> fulldetailsparticular(int id) throws IOException, SQLException {
		
		connection=obj.get_connection();
		
		String query="select student.stdid,student.stdname,student.stddept,student.stdyear,student.stdmobno,sub.subid,sub.subname,submarks.submarks,clg.clgid,student.stdclgname from ((student inner join submarks on student.stdid=submarks.stdid) inner join sub on sub.subid=submarks.subid )inner join clg on clg.clgname=student.stdclgname where student.stdid =  ? ; ";
		
		ps=connection.prepareStatement(query);
		
		ps.setInt(1, id);
		
		rs=ps.executeQuery();
		
		fulldetails=new ArrayList<>();
		
		FullDao fulldao;
		
		while(rs.next()) {
			
			int stdid=Integer.parseInt(rs.getString(1));
			
			int clgid=Integer.parseInt(rs.getString(9));
			
			int submarks=Integer.parseInt(rs.getString(8));
			
			System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6)+"\t"+rs.getString(7)+"\t"+rs.getString(8)+"\t"+rs.getString(9)+"\t"+rs.getString(10));
			
			fulldao=new FullDao(stdid,rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7), submarks ,clgid,rs.getString(10));
			
			fulldetails.add(fulldao);
		}
		
		return fulldetails;
	}


	public void gettopmarks() throws IOException, SQLException {
		
		connection=ConnectionJdbc.get_connection();
		
		String query="select sum (submarks.submarks) as rank, student.stdname ,student.stddept,student.stdmobno,student.stdyear , student.stdclgname from (student inner join submarks on student.stdid=submarks.stdid) inner join sub on submarks.subid=sub.subid group by student.stdname , student.stdclgname ,student.stddept,student.stdmobno,student.stdyear  order by rank desc ; ";
		
		statement=connection.createStatement();
		
		rs=statement.executeQuery(query);
		
		fulldetailsrank=new ArrayList<>();
		
//		FullDao fulldao;
		FullDaoRank fulldaorank;
		
		while(rs.next()) {
			
			int rank=Integer.parseInt(rs.getString(1));
			
//			fulldao=new FullDao(rank ,rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
		
			fulldaorank=new FullDaoRank(rank, rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
			
			System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6));
			
			fulldetailsrank.add(fulldaorank);
			
//			fulldetails.add(fulldao);
		}
	}


	public void gettopclg() throws SQLException, IOException {
		
		connection=ConnectionJdbc.get_connection();
		
		String query="select  stdclgname ,max(total_marks) as total_marks from (select sum (submarks.submarks) as total_marks,student.stdclgname from (student inner join submarks on student.stdid=submarks.stdid) inner join sub on submarks.subid=sub.subid group by student.stdname , student.stdclgname  order by total_marks desc) as x group by stdclgname order by total_marks desc;";
		
		statement=connection.createStatement();
		
		rs=statement.executeQuery(query);
		
		fulldetailsrank=new ArrayList<>();
		
		FullDaoRank fulldao;
		
		while(rs.next()) {
			
			int rank=Integer.parseInt(rs.getString(2));
			
			fulldao=new FullDaoRank(rs.getString(1),rank);
			
			System.out.println(rs.getString(1)+"\t"+rs.getString(2));
			
			fulldetailsrank.add(fulldao);
		}
		
		
	}


	public List<FullDao> particularsubmarks(String subname) throws IOException, SQLException {
		
		connection=obj.get_connection();
		
		String query="select student.stdid,student.stdname,student.stdmobno,student.stddept,student.stdyear,clg.clgid,student.stdclgname ,sub.subid,sub.subname,submarks.submarks from ((student inner join submarks on student.stdid=submarks.stdid) inner join sub on submarks.subid=sub.subid)inner join clg on clg.clgname=student.stdclgname where   submarks.submarks=(select max(submarks.submarks) from submarks inner join sub on sub.subid=submarks.subid where sub.subname = ? ) and sub.subname = ? ;";
		
		ps=connection.prepareStatement(query);
		
		ps.setString(1, subname);
		ps.setString(2, subname);
		
		rs=ps.executeQuery();
		
		fulldetails=new ArrayList<>();
		
		FullDao fulldao;
		
		while(rs.next()) {
			
			int stdid=Integer.parseInt(rs.getString(1));
			
			int clgid=Integer.parseInt(rs.getString(6));
			
			int submarks=Integer.parseInt(rs.getString(10));
			
			System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6)+"\t"+rs.getString(7)+"\t"+rs.getString(8)+"\t"+rs.getString(9)+"\t"+rs.getString(10));
			
			fulldao=new FullDao(stdid,rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),clgid,rs.getString(7),rs.getString(8) ,rs.getString(9), submarks);
			
			fulldetails.add(fulldao);
		}
		
		return fulldetails;
	}
	
	


	
		
	
	
	
}










