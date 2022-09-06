package day6jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcConnection {

	public static void main(String[] args) {
		Connection con=null;
		
		try {
			Class.forName("org.postgresql.Drive");
			con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/clg","postgres","password");
			if(con!=null) {
				System.out.println("connection ok");
			}
			else {
				System.out.println("connection failed");
			}
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
