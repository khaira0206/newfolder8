package moderate;

public class nummberSwapper {

	public static void main(String arg[]){
		
		
		
		nummberSwapper ns = new nummberSwapper();
	    ns.swapper(9 , 0);
		
	 
		
	}
	
	void swapper(int a, int b){
		
		a = a + b;
		b = a - b;
		a = a - b;
		
		System.out.println("a is: " +a + " b is :" + b);
	}
	
}
