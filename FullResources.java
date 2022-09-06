package com.maven.Student;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("fulldetails")
public class FullResources {


	@GET
	@Path("readalldetails")
	@Produces(MediaType.APPLICATION_JSON)
	public List<FullDao>  get_fulldetails() throws SQLException, IOException {
		
		FullDetails fulldetails=new FullDetails();
		
		fulldetails.getfulldetails();
		
		List<FullDao> fulldetailslst=FullDetails.fulldetails;
		
		
		return fulldetailslst;
	
	}
	
	
	@GET
	@Path("readparticularstddetails/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<FullDao> get_particularstd(@PathParam ("id") int id) throws IOException, SQLException {
		
		FullDetails fulldetails=new FullDetails();
		
		
		if(fulldetails.fulldetailsparticular(id) == null ) {
			
			System.out.println("ID DOES NOT EXIST");
			
			return null;
		}
		else {
			return  FullDetails.fulldetails;
		}
		
		
	}
	
	@GET
	@Path("readtopmarks")
	@Produces(MediaType.APPLICATION_JSON)
	public List<FullDaoRank>  get_topmarks() throws SQLException, IOException {
		
		FullDetails fulldetails=new FullDetails();
		
		fulldetails.gettopmarks();
		
		
		return  FullDetails.fulldetailsrank;
		
	}

	
	
	@GET
	@Path("readalltopclg")
	@Produces(MediaType.APPLICATION_JSON)
	public List<FullDaoRank>  get_topclg() throws SQLException, IOException {
		
		FullDetails fulldetails=new FullDetails();
		
		fulldetails.gettopclg();
		
//		List<FullDao> topclgdetails=FullDetails.fulldetails;
		
//		return topclgdetails;
		
		return FullDetails.fulldetailsrank;
		
		
	}
	
	@GET
	@Path("readparticularmarks/{subname}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<FullDao>  get_particularsub(@PathParam ("subname") String subname) throws IOException, SQLException {
		
		FullDetails fulldetails=new FullDetails();
		
		if(fulldetails.particularsubmarks(subname) == null ) {
			
			System.out.println("ID DOES NOT EXIST");
			
			return null;
		}
		else {
			return  FullDetails.fulldetails;
		}
		
		
	}
	
}

















