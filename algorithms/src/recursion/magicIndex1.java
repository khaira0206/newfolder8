package recursion;

public class magicIndex1 {
	
	public static void main(String arg[]){
		
		int arr[] = {0,1,2,3,4,5,6};
		magicIndex1 mi = new magicIndex1();
		mi.magicfast(arr);
		
		System.out.println(mi.magicfast(arr));
	}
	
	int magicfast(int[] arr){
		
		return magicfast(arr , 0, arr.length -1);
		
	}
int magicfast(int[] arr , int start, int end){
	
	if(end < start){
		return -1;
	}
	
	int mid = (start + end) /2;
	if(arr[mid] == mid){
		return mid;	
	}
	else if(arr[mid] > mid){
		return magicfast(arr, start, mid -1);
	}
	else{
		return magicfast(arr, mid +1, end);
	}
}	

}
