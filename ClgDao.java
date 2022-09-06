package com.maven.Student;

public class ClgDao {
	
	
	private String clgname;
	private int clgid;
	private String clglocation;
	private String clgmobno;

	public ClgDao(String clgname, int clgid, String clglocation, String clgmobno) {
		super();
		this.clgname = clgname;
		this.clgid = clgid;
		this.clglocation = clglocation;
		this.clgmobno = clgmobno;
	}
	

	public String getClgname() {
		return clgname;
	}

	public void setClgname(String clgname) {
		this.clgname = clgname;
	}

	public int getClgid() {
		return clgid;
	}

	public void setClgid(int clgid) {
		this.clgid = clgid;
	}

	public String getClglocation() {
		return clglocation;
	}

	public void setClglocation(String clglocation) {
		this.clglocation = clglocation;
	}

	public String getClgmobno() {
		return clgmobno;
	}

	public void setClgmobno(String clgmobno) {
		this.clgmobno = clgmobno;
	}

	public ClgDao() {
		
	}

}
