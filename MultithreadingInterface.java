package day3;



//
//class Hey implements Runnable  {
//	
//	public void run() {
//		for(int i=0 ; i<=5 ;i++) {
//			System.out.println("hey");
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				
//				e.printStackTrace();
//			}
//		}
//	}
//	
//}
//
//class Hoo implements Runnable{
//	
//	public void run() {
//		for(int i=0 ; i<=5 ;i++) {
//			System.out.println("hoo");
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				
//				e.printStackTrace();
//			}
//		}
//	}
//	
//}
//
//
//
//public class  MultithreadingInterface {
//	
//	
//
//	public static void main(String[] args) {
//		
//		Hey obj1=new Hey();
//		
//		Hoo obj2=new Hoo();
//		
//		Thread t1=new Thread(obj1);
//		
//		Thread t2=new Thread(obj2);
//		
//		t1.start();
//		try { Thread.sleep(10); } catch (Exception e) {}
//		t2.start();
//		
//
//
//	}
//
//}



//*******************************************************orrrrrrr***********************************************



public class  MultithreadingInterface {
	
	public static void main(String[] args) {
		
		Runnable obj1=() -> {
				for(int i=0 ; i<=5 ;i++) {
					System.out.println("hey");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
				}
		};
		
		Runnable obj2=() ->{                               //also we short by in Thread(obj1); in obj1 we put above runnable obj1
				for(int i=0 ; i<=5 ;i++) {					//by removing Runnable obj2= and adding in tread obj1
					System.out.println("helo");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
				}
		};
		
		Thread t1=new Thread(obj1);
		
		Thread t2=new Thread(obj2);
		
		t1.start();
		
		try { Thread.sleep(10); } catch (Exception e) {}
		
		t2.start();
		
		
		


	}

}

