package com.maven.Student;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Students{
	static List<String> student=new ArrayList<String>(Arrays.asList("stdid","stdname","stddept","stdyear","stdclgname","stdmobno"));
	String stdname=null;
}

public class RoughWork {



	public static void main(String[] args) throws IOException, SQLException {
		
		Students std=new Students();
	
		File file = new File("C:\\Users\\Mohan\\eclipse-workspace\\Student\\student.txt");
	    Scanner sc = new Scanner(file);
	    while (sc.hasNextLine())
	        System.out.println(sc.nextLine().equals("stdid"));
	    

	 
		System.out.println(Students.student.contains("stdid"));
		
		
		
		String clname="stdid ,stdname,stdlocation ";
		String[] columnname=clname.trim().split(",");
		System.out.println(Arrays.toString(columnname));
		for(int i=0; i<columnname.length ;i++) {
			
			String str=columnname[i].trim();
			
			
		}
		
		

	}

}
