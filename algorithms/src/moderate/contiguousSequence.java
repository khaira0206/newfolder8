package moderate;

class result{
	int max, start, end;
}

public class contiguousSequence {

	public static void main(String arg[]){
		int[] arr = {2 ,-8, 3, -2, 4, -1,11,-1,5};
		contiguousSequence cs = new contiguousSequence();
		result r = cs.getMax(arr);
		System.out.println("max sum is :" + r.max + " Starts at : " + r.start+ " Ends at :" +r.end);
		for(int i = r.start; i <= r.end; i++){
			System.out.println(arr[i]);
		}
	}
	
	result getMax(int[] arr){
		
		int max = 0;
		int sum = 0;
		result r = new result() ;
		for(int i = 0; i < arr.length ; i++){
			
			sum += arr[i];
			
			if(sum > max){
				
				max = sum;
				r.max = max;
				if(sum == arr[i])
				r.start = i;
				r.end = i;
			}
			else if(sum < 0){
				sum = 0;
			}
		}
		
		return r;
	}
	
}
