package com.maven.Student;

public class FullDaoRank {

	
	private String stdname;
	private String stddept;
	private String stdyear;
	private String stdmobno;
	private String stdclgname;
	private int rank;
	
	
	
	
	public FullDaoRank(int rank,String stdname, String stddept ,String stdmobno, String stdyear,  String stdclgname) {
		super();
		this.stdname = stdname;
		this.stddept = stddept;
		this.stdyear = stdyear;
		this.stdmobno = stdmobno;
		this.stdclgname = stdclgname;
		this.rank = rank;
	}




	public FullDaoRank(String stdclgname, int rank) {
		super();
		this.stdclgname = stdclgname;
		this.rank = rank;
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




	public int getRank() {
		return rank;
	}




	public void setRank(int rank) {
		this.rank = rank;
	}




	public FullDaoRank() {
		
	}

}
