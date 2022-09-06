package com.maven.Student;

import java.io.IOException;
import java.lang.invoke.MethodType;
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


@Path("clg")
public class ClgResources {
	
	@GET
	@Path("readallclg")
	@Produces(MediaType.APPLICATION_JSON)
	
	public List<ClgDao> getall() throws IOException, SQLException {
		
		
		Clg obj=new Clg();
		
		obj.readall();
		
		List<ClgDao> clgdetails=Clg.lstclgdao;
		
		return  clgdetails;
	}

	
	
	@POST
	@Path("insertclg")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ClgDao insertstd(ClgDao clgdao) throws IOException, SQLException {
		
		Clg clgobj=new Clg();
		
		int id=clgdao.getClgid();
		String clgname=clgdao.getClgname();
		
		
		
		return clgobj.clgpost( clgdao.getClgname(),clgdao.getClgid(),clgdao.getClglocation(),clgdao.getClgmobno());
		
	}
	
	@GET
	@Path("readparticularclg/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ClgDao get_particular(@PathParam ("id") int id) throws IOException, SQLException {
		
		Clg clgobj=new Clg();
		
		if(clgobj.clgparticular(id) == null ) {
			
			System.out.println("ID DOES NOT EXIST");
			
			return null;
		}
		
		return  clgobj.clgparticular(id);
		
	}
	
	@DELETE
	@Path("deleteclg/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces({MediaType.APPLICATION_JSON , MediaType.TEXT_PLAIN})
	public Object deletestd(@PathParam ("id")  int id) throws IOException, SQLException {
		
		Clg clgobj=new Clg();
		
		
		if(clgobj.clgparticular(id) == null ) {
			
			System.out.println(" Id does not exist ");
			
			return null;
		}
		else {
			ClgDao clgdao=clgobj.clgparticular(id);
			clgobj.clgdelete(id);
			return clgdao;
		}	
	}
	
	
	
	@PUT
	@Path("updateclg")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON , MediaType.TEXT_PLAIN})
	public Object  updateclg(ClgDao clgdaoobj) throws SQLException, IOException {
		
		Clg clgobj=new Clg();
		
		int id=clgdaoobj.getClgid();
		
		ClgDao clgdao=clgobj.clgparticular(id);
		
		if(clgobj.clgparticular(id) == null ) {
			
			
			System.out.println(" Id does not exist ");
			
			return null;
			
		}
		System.out.println("pp"+ !(clgdaoobj.getClglocation().isEmpty())+"uu");
		
		if(!(clgdaoobj.getClgname().isEmpty())) {
			
			clgdao.setClgname(clgdaoobj.getClgname());
		}
		if(!(clgdaoobj.getClgmobno().isEmpty())) {
			
			clgdao.setClgmobno(clgdaoobj.getClgmobno());
		}
		if(!(clgdaoobj.getClglocation().isEmpty())) {
			
			clgdao.setClglocation(clgdaoobj.getClglocation());
		}
		
		
		clgobj.clgupdate(clgdao);
		
		return clgobj.clgparticular(id);
		
	}
	

}














