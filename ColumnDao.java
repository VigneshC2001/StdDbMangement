package com.maven.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ColumnDao {
	
	static List<String> student=new ArrayList<String>(Arrays.asList("stdid","stdname","stddept","stdyear","stdclgname","stdmobno"));
	
	static List<String> clg=new ArrayList<String>(Arrays.asList("clgid","clgname","clglocation","clgmobno"));
	
	static List<String> sub=new ArrayList<String>(Arrays.asList("subname","subid"));
	
	static List<String> submarks=new ArrayList<String>(Arrays.asList("submarks"));
	
	
}
