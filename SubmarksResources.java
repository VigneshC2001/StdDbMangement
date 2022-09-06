package com.maven.Student;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("submarks")
public class SubmarksResources {

	@GET
	@Path("readallsubmarks")
	@Produces(MediaType.APPLICATION_JSON)
	public List<SubmarksDao>  get_student() throws SQLException, IOException {
		
		Submarks submarksobj=new Submarks();
		
		submarksobj.getsubmarks();
		
		List<SubmarksDao> submarksdetails=Submarks.submarksdetails;
		
		
		return submarksdetails;
		
	}
	
	
	@POST
	@Path("insertsubmarks")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Object insertsubmarks(SubmarksDao submarksin) throws IOException, SQLException {
		
		Submarks submarksobj=new Submarks();
		
		Student studentobj=new Student();
		
		Sub subobj=new Sub();
		
		int stdid=submarksin.getStdid();
		String subid=submarksin.getSubid();
		
		if(studentobj.stdparticular(stdid) == null || subobj.subparticular(subid) == null ) {
			
			
			System.out.println(" SUBID OR STDID does not exist ");
			
			return null;
			
		}
		else {
			
			if(submarksobj.submarkparticularstdsub(stdid, subid) == null ) {
				
				
				submarksobj.submarkspost(submarksin.getStdid(),submarksin.getSubid(),submarksin.getSubmarks());
				
				return submarksin;
				
			}
			else {
				
				return null;
			}
			
		}
		
	}
	
	
	@GET
	@Path("readparticularsubmarks/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<SubmarksDao> get_particularsubmarks(@PathParam ("id") int id) throws IOException, SQLException {
		
		Submarks submarksobj=new Submarks();
		
		if(submarksobj.submarksparticular(id) == null ) {
			
			System.out.println("ID DOES NOT EXIST");
			
			return null;
		}
		else {

			submarksobj.submarksparticular(id);
			
			return  Submarks.submarksdetails;
		}
		
	}
	
	
	@DELETE
	@Path("deletesubmarks/{stdid}/{subid}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON , MediaType.TEXT_PLAIN})
	public Object deletesubmarks(@PathParam ("stdid")  int stdid , @PathParam ("subid") String subid ) throws IOException, SQLException {
		
		Submarks submarksobj=new Submarks();
		
		
		Student studentobj=new Student();
		
		Sub subobj=new Sub();
		
		if(studentobj.stdparticular(stdid) == null || subobj.subparticular(subid) == null ) {
			
			
			System.out.println(" Id does not exist ");
			
			return null;
			
		}
		else {
			
			SubmarksDao submarksdao=submarksobj.submarkparticularstdsub(stdid, subid);
			
			submarksobj.submarksdelete(stdid , subid);
			
			return submarksdao;
		}
	}
	
	@PUT
	@Path("updatesubmarks")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON )
	public Object  updatesubmarks(SubmarksDao submarksdaoobj) throws SQLException, IOException {
		
		Submarks submarksobj=new Submarks();
		
		int id=submarksdaoobj.getStdid();
		
		String subid=submarksdaoobj.getSubid();
		
		Student studentobj=new Student();
		
		Sub subobj=new Sub();
		System.out.println(id);
		
		if(studentobj.stdparticular(id) == null || subobj.subparticular(subid) == null ) {
			
			
			System.out.println(" Id does not exist ");
			
			return null;
			
		}
		else {
			
			submarksobj.submarksupdate(submarksdaoobj);
			
			
			return submarksobj.submarksparticular(id);
		}
	
	}
	
	
}




