package com.maven.Student;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;




@Path("multicolumn")
public class MultiColumnResources {

	@GET
	@Path("singleclmn/{clname}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<String>  get_singleclmn(@PathParam ("clname")  String clname  ) throws SQLException, IOException {
		
		MultColumn multcolumn=new MultColumn();
		
		int count=0;
		List<String> clmlst=new ArrayList<String>();
		
		String[] columnname=clname.trim().split(",");
		
		for(int i=0 ; i<columnname.length ; i++ ) {
			
			String str=columnname[i].trim();
			
			if(ColumnDao.clg.contains(str)) {
				multcolumn.singlestrcolumn(str,"clg");
			}
			else if(ColumnDao.student.contains(str)) {
				multcolumn.singlestrcolumn(str,"student");
			}
			else if(ColumnDao.sub.contains(str)) {
				multcolumn.singlestrcolumn(str,"sub");
			}
			else if(ColumnDao.submarks.contains(str)) {
				multcolumn.singlestrcolumn(str,"submarks");
			}
			else {
				count=1;
				break;
			}
			clmlst.addAll(MultColumn.strclm);
		}
		if(count == 0) {
			return clmlst;
		}
		else {
			return null;
		}
		
		
	}
	
}















//for(int i=0 ; i<tablename.size() ; i++) {
//	
//	if(multcolumn.singlestrcolumn(clname,tablename.get(i)) == null) {
//		
//		continue;
//	}
//	else {
//		tbname=tablename.get(i);
//		break;
//	}
//}