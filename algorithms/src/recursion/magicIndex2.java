package recursion;

public class magicIndex2 {

	public static void main(String arg[]){
		
		int[] arr = {1,1,2,3,4,4,7,7,9,10};
		magicIndex2 mi = new magicIndex2();
		System.out.println(mi.magicfast(arr));
		
	}
	
	int magicfast(int[] arr){
		
		return magicfast(arr, 0, arr.length -1);
	}
	
	int magicfast(int[] arr, int start, int end){
		
		if(end < start){
			return -1;
		}
		
		int mid = (start + end)/2;
		int midValue = arr[mid];
		if(arr[mid] == mid){
			return mid;
			
		}
		int leftindex = Math.min(mid -1, midValue);
		
		int left = magicfast(arr, start, leftindex);
		if(left > 0){
			return left;
		}
		
		int rightIndex = Math.max(mid +1, midValue);
		int right = magicfast(arr, rightIndex, end);
		 return right;
	}
	
}
