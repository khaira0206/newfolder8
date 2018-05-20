package hard;

public class majorityElement {

	public static void main(String[] arg) {

	}

	int findMajorityElement(int[] arr) {
		for (int x : arr) {
			if (validate(arr, x)) {
				return x;
			}
		}
		return -1;
	}

	boolean validate(int[] arr, int x) {
     int count = 0;
     for(int i = 0; i < arr.length; i++){
    	 if(x == arr[i]){
    		 count++;
    	 }
    	 
     }
     return count >= arr.length +1;
	}
}
