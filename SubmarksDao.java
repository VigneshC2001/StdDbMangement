package com.maven.Student;

public class SubmarksDao {
	
	private int stdid;
	private String subid;
	private int submarks;
	
	public SubmarksDao() {
		
	}

	public SubmarksDao(int stdid, String subid, int submarks) {
		super();
		this.stdid = stdid;
		this.subid = subid;
		this.submarks = submarks;
	}

	public int getStdid() {
		return stdid;
	}

	public void setStdid(int stdid) {
		this.stdid = stdid;
	}

	public String getSubid() {
		return subid;
	}

	public void setSubid(String subid) {
		this.subid = subid;
	}

	public int getSubmarks() {
		return submarks;
	}

	public void setSubmarks(int submarks) {
		this.submarks = submarks;
	}


}
