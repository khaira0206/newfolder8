package moderate;

public class smallestDifference1 {

	public static void main(String arg[]){
		
		int[] arr1 = {1,3,15,11,2};
		int[] arr2 = {23,127,235,19,8};
		smallestDifference1 sd = new smallestDifference1();
		long time1  = System.currentTimeMillis();
		int val = sd.findSmallestDiff(arr1, arr2);
		long time2  = System.currentTimeMillis();
		
		System.out.println("diff is :" + val);
		System.out.println("time diff in millisec :"+ (time1 - time2));
	}
	
	int findSmallestDiff(int[] arr1, int[] arr2){
		
		if(arr1.length == 0 || arr2.length == 0)
			return -1;
		int min = Integer.MAX_VALUE;
		
		for(int i = 0; i <arr1.length; i++){
			for(int j = 0; j < arr2.length; j++){
				if(Math.abs(arr1[i] - arr2[j]) < min){
					min = Math.abs(arr1[i] - arr2[j]);
				}
			}
		}
		return min;
		
	}
}
