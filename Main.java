package day3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		int i=8;
		int j=9;
		Integer ii=new Integer(j);
		
		
		System.out.println(ii);
		
		
		ArrayList<String> arrlst=new ArrayList<String>();
		
		arrlst.add("abcd");
		arrlst.add("efgh");
		arrlst.add("ijkl");
		arrlst.add("mnop");
		arrlst.add(1,"change");
//		
//		for(String str:arrlst) {
//			System.out.println(str);
//											//this shows concurrentModification error
//			if(str.equals("abcd")){			//cz we r removing while iterating
////				arrlst.remove(str);			//for this we have use iterator remove method
//			}
//		}
		Iterator<String> itr=arrlst.iterator();
		while(itr.hasNext()) {
			
			String str=itr.next();
			if(str.equals("mnop")) {
				itr.remove();
				System.out.println(arrlst);
			}
			
		}
		
		System.out.println("\n");
		for(String str:arrlst) 
			System.out.println(str);
		
		List<String> str=Collections.unmodifiableList(arrlst);
		
		str.add(2, "hi");
		
		System.out.println(str);
	}

}
