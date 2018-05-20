package recursion;

public class recMultiply1 {
	
	public static void main(String arg[]){
		
		recMultiply1 rm = new recMultiply1();
		System.out.println(rm.minProduct(1234125687,1673476374));
	}
	
	int minProduct(int a , int b){
		int smaller = a > b ? b : a;
		int bigger =  a > b ? a : b;
		
		int[] memo = new int[smaller +1];
		
		return minProduct(smaller, bigger, memo);
	}
	
	int minProduct(int smaller, int bigger, int[] memo){
		
		if(smaller == 0){
			return 0;
		}
		if(smaller == 1){
			return bigger;
			
		}
		if(memo[smaller] > 0){
			
			return memo[smaller];
		}
		
		int s = smaller >> 1;
		
		int side1 = minProduct(s, bigger , memo);
		
		int side2 = side1;
		if(smaller % 2 == 1){
			side2 = minProduct(smaller - s, bigger, memo);
		}
		
		memo[smaller] = side1 + side2;
		return memo[smaller];
		
	}

}
