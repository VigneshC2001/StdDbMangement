//package com.maven.Student;
//
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.List;
//
//public class Multithreading {
//	public Multithreading() {
//		
//	}
//
//	public static void main(String[] args) throws InterruptedException {
//	
//		
//		Particularsubmarks t1=new Particularsubmarks();
//		Deleteparticularid t2=new Deleteparticularid();
//	    Dltsubmparticular  t3=new  Dltsubmparticular();
//		
//		t1.start();
//		t2.start();
//		t3.start();
//		
//
//	}
//
//}
//class Particularsubmarks extends Thread{
//	
//	public void run() {
//		
//		Submarks submarksobj=new Submarks();
//		
//		Student studentobj=new Student();
//		
//		Sub subobj=new Sub();
//		
//		try {
//			if(studentobj.stdparticular(43,"t1") == null || subobj.subparticular("m111") == null ) {
//				
//				System.out.println(" SUBID OR STDID does not exist ");
//				
//			}
//			else {
//				
//				try {
//					
//					submarksobj.submarkspost(43,"m111", 99);
//				} catch (IOException | SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		} catch (IOException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//}
//
//
//
//class Deleteparticularid extends Thread{
//	
//	public void run() {
//		Student stdobj=new Student();
//		
//		
//		try {
//			if(stdobj.stdparticular(43,"t2") == null ) {
//				
//				System.out.println(" Id does not exist ");
//				
//			}
//			else {
//				
//				stdobj.stddelete(43);
//			}
//		} catch (IOException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
//	
//}
//
//class Dltsubmparticular extends Thread{
//	
//	public void run() {
//		Submarks submarksobj=new Submarks();
//		
//		
//		Student studentobj=new Student();
//		
//		Sub subobj=new Sub();
//		
//		try {
//			if(studentobj.stdparticular(43,"st") == null || subobj.subparticular("m111") == null ) {
//				
//				
//				System.out.println(" Id does not exist ");
//				
//			}
//			else {
//				
//				try {
//					
//					submarksobj.submarksdelete(43 , "m111");
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				
//			}
//		} catch (IOException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//	}
//	
//	
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
