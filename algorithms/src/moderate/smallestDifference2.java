package moderate;

import java.util.Arrays;

public class smallestDifference2 {

	public static void main(String arg[]){
		int[] arr1 = {1,3,15,11,2};
		int[] arr2 = {23,127,235,19,8};
		smallestDifference2 sd = new smallestDifference2();
		long time1  = System.currentTimeMillis();
		int val = sd.findSmallestDiff(arr1, arr2);
		long time2  = System.currentTimeMillis();
		
		System.out.println("diff is :" + val);
		System.out.println("time diff in millisec :"+ (time1 - time2));
		
	}
	
	int findSmallestDiff(int arr1[], int arr2[]){
		
		int a = 0;
		int b = 0;
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		int minDiff = Integer.MAX_VALUE;
		
		while(a < arr1.length && b < arr2.length){
			if(Math.abs(arr1[a] - arr2[b]) < minDiff){
				minDiff = Math.abs(arr1[a] - arr2[b]);
			}
			
			if(arr1[a] < arr2[b]){
				a++;
			}
			else if(arr1[a] > arr2[b]){
				b++;
			}
			
		}
		return minDiff;
		
	}
	
}
