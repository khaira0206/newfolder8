package recursion;

import java.util.Arrays;

public class tripleStep1 {
	
	public static void main(String arg[]){
		
		tripleStep1 ts1 = new tripleStep1();
		System.out.println(ts1.countway11(100));
	}

	int countway11(int n){
		
		int[] memo = new int[n + 1];
		Arrays.fill(memo, -1);
		return countway1(n , memo);
	}
	
	int countway1( int n , int []memo){
		if( n < 0)
			return 0;
		else if(n == 0){
			return 1;
		}
		else if(memo[n] > -1){
			return memo[n];
			
		}
		else{
			
			memo[n] = countway1(n - 1 , memo) + countway1(n - 2 , memo) + countway1(n - 3 ,memo);
		}
		return memo[n];
		
	}
}
