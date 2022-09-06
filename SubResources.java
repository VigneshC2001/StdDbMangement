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

@Path("sub")
public class SubResources {
	
	@GET
	@Path("readallsub")
	@Produces(MediaType.APPLICATION_JSON)
	public List<SubDao>  get_student() throws SQLException, IOException {
		
		Sub subobj=new Sub();
		
		subobj.getsub();
		
		List<SubDao> subdetails=Sub.subdetails;
		
		
		return subdetails;
		
	}
	
	@POST
	@Path("insertsub")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Object insertstd(SubDao subin) throws IOException, SQLException {
		
		Sub subobj=new Sub();
		String subid=subin.getSubid();
		String subname=subin.getSubname();
		
		System.out.println("t"+subid+"t");
		if(subobj.subparticular(subid) == null ) {
			
			if(subid.isEmpty() || subname.isEmpty()) {
				return "";
			}
			else {
				return subobj.subpost(subin.getSubid(),subin.getSubname()); 

			}
					}
		else {
			System.out.println("ID DOES NOT EXIST");
			
			return null;
		}
		
	}

	
	
	@GET
	@Path("readparticularsub/{subid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Object get_particular(@PathParam ("subid") String subid) throws IOException, SQLException {
		
		Sub subobj=new Sub();
		
		if(subobj.subparticular(subid) == null ) {
			
			System.out.println("ID DOES NOT EXIST");
			
			return null;
		}
		
		return  subobj.subparticular(subid);
		
	}
	
	
	
	
	@DELETE
	@Path("deletesub/{subid}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON , MediaType.TEXT_PLAIN})
	public Object deletesub(@PathParam ("subid")  String subid) throws IOException, SQLException {
		
		Sub subobj=new Sub();
		
		
		if(subobj.subparticular(subid) == null ) {
			
			System.out.println(" Id does not exist ");
			
			return null;
			
		}
		else {
			
			SubDao subdao=subobj.subparticular(subid);
			
			subobj.subdelete(subid);
			
			return subdao;
		}
	}
//	@PUT
//	@Path("updatesub")
//	@Produces(MediaType.APPLICATION_JSON)
//	public String updatesub(SubDao subdao) throws IOException, SQLException {
//		
//		Sub subobj=new Sub();
//		
//		if(subobj.subparticular(subdao.getSubid()) == null ) {
//			
//			System.out.println("ID DOES NOT EXIST");
//			
//			return null;
//		}
//		
//	}
	
	
}























