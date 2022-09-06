package com.maven.Student;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path("student")
public class StdResource {
	
	@GET
	@Path("readall")
	@Produces(MediaType.APPLICATION_JSON)
	public List<StdDb>  get_student() throws SQLException, IOException {
		
		Student studentobj=new Student();
		
		studentobj.getstd();
		
		List<StdDb> stddetails=Student.stddetails;
		
		
		return stddetails;
		
	}
	
	@POST
	@Path("insert")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Object insertstd(StdDb stdin) throws IOException, SQLException {
		 
		Student studentobj=new Student();
		Clg clgobj=new Clg();
		String clgname=stdin.getStdclgname();
		
		if(clgobj.clgparticularname(clgname)==null) {
			
			System.out.println("clgname does not exist");
			
			return null;
		}
		else {

			return studentobj.stdpost(stdin.getStdname(),stdin.getStddept(),stdin.getStdyear(),stdin.getStdmobno(),stdin.getStdclgname());
			
			
		}
	}
	
	
	@GET
	@Path("readparticular/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Object get_particular(@PathParam ("id") int id) throws IOException, SQLException {
		
		Student studentobj=new Student();
		
		if(studentobj.stdparticular(id) == null ) {
			
			System.out.println("ID DOES NOT EXIST");
			
			return  null;
		}
		else {
			return  studentobj.stdparticular(id);
		}
		
		
	}
	
	@PUT
	@Path("update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON , MediaType.TEXT_PLAIN})
	public Object  updatestd(StdDb stdobj) throws SQLException, IOException {
		
		Student studentobj=new Student();
		
		int id=stdobj.getStdid();
		
		StdDb stddb=studentobj.stdparticular(id);
		
		if(studentobj.stdparticular(id) == null ) {
			
			
			System.out.println(" Id does not exist ");
			
			return null;
			
		}

		if(!(stdobj.getStdname().isEmpty())) {
			
			stddb.setStdname(stdobj.getStdname());
		}
		if(!(stdobj.getStddept().isEmpty())) {
			
			stddb.setStddept(stdobj.getStddept());
		}
		if(!(stdobj.getStdyear().isEmpty())) {
			
			stddb.setStdyear(stdobj.getStdyear());
		}
		if(!(stdobj.getStdmobno().isEmpty())) {
			
			stddb.setStdmobno(stdobj.getStdmobno());
		}
		if(!(stdobj.getStdclgname().isEmpty())) {
			
			stddb.setStdclgname(stdobj.getStdclgname());
		}
		
		
		
		studentobj.stdupdate(stddb);
		
		return  studentobj.stdparticular(id);
		
//		try {
//			Student studentobj=new Student();
//			studentobj.stdupdate(stdobj);
//			return "UPDATED SUCCESFULLY";
//		}
//		catch(NullPointerException e) {
//			return "ID DOES NOT EXIST";
//		}
	}
	
	@DELETE
	@Path("delete/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON , MediaType.TEXT_PLAIN})
	public Object deletestd(@PathParam ("id")  int id) throws IOException, SQLException {
		
		Student stdobj=new Student();
		
		
		if(stdobj.stdparticular(id) == null ) {
			
			System.out.println(" Id does not exist ");
			
			return null;
			
		}
		else {
			
			StdDb stddb=stdobj.stdparticular(id);
			
			stdobj.stddelete(id);
			
			return  stddb;
		}
		
		
	}
	
	
}













