package com.maven.Student;

public class SubDao {
	
	private String subid;
	private String subname;

	public SubDao(String subid, String subname) {
		super();
		this.subid = subid;
		this.subname = subname;
	}

	public String getSubid() {
		return subid;
	}

	public void setSubid(String subid) {
		this.subid = subid;
	}

	public String getSubname() {
		return subname;
	}

	public void setSubname(String subname) {
		this.subname = subname;
	}

	public SubDao() {
		
	}

}
