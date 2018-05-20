package hard;

import java.util.Arrays;
import java.util.HashMap;


public class longestWord {

	public static void main(String arg[]){
		
		
	}
	
	String printLongestWord(String arr[]){
		
		HashMap<String, Boolean> map = new HashMap<String, Boolean>();
		for(String ele : arr){
			map.put(ele, true);	
		}
		Arrays.sort(arr);
		
		return arr[0];
	}
}
