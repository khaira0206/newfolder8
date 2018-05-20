package moderate;

public class factorialZeros1 {

	public static void main(String arg[]){
		
		factorialZeros1 fz = new factorialZeros1();
		
		System.out.println(fz.countFactZero(10));
		System.out.println(fz.fact(10));
		
	}
	int factorOf5(int num){
		int count = 0;
		while(num % 5 == 0){
			count++;
			num /=5;
		}
		return count;
	}
	int countFactZero(int num){
		int count = 0;
		for(int i = 2; i <= num; i++){
			count += factorOf5(i);
		}
		return count;
	}
	int fact(long num){
		
		int fact = 1;
		for(int i =2; i<=num; i++){
			fact *= i;
		}
		return fact;
	}
	
}
