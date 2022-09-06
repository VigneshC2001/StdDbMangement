package com.maven.Student;

public class FullDao {

	private  int stdid;
	private String stdname;
	private String stddept;
	private String stdyear;
	private String stdmobno;
	private String stdclgname;
	private int clgid;
	private String clglocation;
	private String clgmobno;
	private String subid;
	private String subname;
	private int submarks;

	
	public FullDao(  String stdname, String stddept, String stdyear, String stdmobno, String stdclgname) {
		super();
		this.stdname = stdname;
		this.stddept = stddept;
		this.stdyear = stdyear;
		this.stdmobno = stdmobno;
		this.stdclgname = stdclgname;
	
	}

	public FullDao(int stdid, String stdname, String stddept, String stdyear, String stdmobno, String clgname,
			int clgid, String clglocation, String clgmobno, String subid, String subname, int submarks) {
		super();
		this.stdid = stdid;
		this.stdname = stdname;
		this.stddept = stddept;
		this.stdyear = stdyear;
		this.stdmobno = stdmobno;
		this.stdclgname = clgname;
		this.clgid = clgid;
		this.clglocation = clglocation;
		this.clgmobno = clgmobno;
		this.subid = subid;
		this.subname = subname;
		this.submarks = submarks;
	}
	
	public FullDao(int stdid, String stdname, String stddept, String stdyear, String stdmobno ,String subid, String subname, int submarks,int clgid, String stdclgname) {
		super();
		this.stdid = stdid;
		this.stdname = stdname;
		this.stddept = stddept;
		this.stdyear = stdyear;
		this.stdmobno = stdmobno;
		this.clgid=clgid;
		this.stdclgname = stdclgname;
		this.subid = subid;
		this.subname = subname;
		this.submarks = submarks;
	}
	
	public FullDao(int stdid, String stdname,String stdmobno , String stddept, String stdyear,int clgid , String stdclgname, String subid, String subname, int submarks) {
		super();
		this.stdid = stdid;
		this.stdname = stdname;
		this.stddept = stddept;
		this.stdyear = stdyear;
		this.stdmobno = stdmobno;
		this.clgid=clgid;
		this.stdclgname = stdclgname;
		this.subid = subid;
		this.subname = subname;
		this.submarks = submarks;
	}
	
	
	public FullDao() {
		
	}

	public int getStdid() {
		return stdid;
	}

	public void setStdid(int stdid) {
		this.stdid = stdid;
	}

	public String getStdname() {
		return stdname;
	}

	public void setStdname(String stdname) {
		this.stdname = stdname;
	}

	public String getStddept() {
		return stddept;
	}

	public void setStddept(String stddept) {
		this.stddept = stddept;
	}

	public String getStdyear() {
		return stdyear;
	}

	public void setStdyear(String stdyear) {
		this.stdyear = stdyear;
	}

	public String getStdmobno() {
		return stdmobno;
	}

	public void setStdmobno(String stdmobno) {
		this.stdmobno = stdmobno;
	}

	public String getStdclgname() {
		return stdclgname;
	}

	public void setStdclgname(String stdclgname) {
		this.stdclgname = stdclgname;
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

	public int getSubmarks() {
		return submarks;
	}

	public void setSubmarks(int submarks) {
		this.submarks = submarks;
	}


	
}
