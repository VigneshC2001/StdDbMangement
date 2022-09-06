package com.maven.Student;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class StdDb {
	
	private  int stdid;
	private String stdname;
	private String stddept;
	private String stdyear;
	private String stdmobno;
	private String stdclgname;
	
	public StdDb() {
		
	}
	
	
	public StdDb(int stdid, String stdname, String stddept, String stdyear, String stdmobno , String stdclgname ) {
		super();
		this.stdid = stdid;
		this.stdname = stdname;
		this.stddept = stddept;
		this.stdyear = stdyear;
		this.stdmobno = stdmobno;
		this.stdclgname=stdclgname;
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

	
	
}
