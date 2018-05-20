package hard;

import java.util.HashMap;

public class letters_and_numbers {
	
	public static void main(String arg[]){
		
		
	}
	
	char[] findLongestSubArray(char []arr){
		
		int[] deltas = computeDeltaArray(arr);
		
		int[] match = findLongestMatch(deltas);
		
		return extract(arr, match[0] + 1, match[1]);
		
		
	}
	int[] computeDeltaArray(char[] arr){
		
		int[] deltas = new int[arr.length];
		int delta = 0;
		for(int i = 0; i <= arr.length; i++){
		if(Character.isLetter(arr[i])){
			delta++;
		}else if(Character.isDigit(arr[i])){
			delta--;
		}	
			deltas[i] = delta;
		}
		return deltas;
		
		
	}
	int[] findLongestMatch(int[] deltas){
		
		HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
		hmap.put(0, 1);
		int[] max = new int[2];
		
		return null;
		
			
	}
	char[] extract(char[] arr, int start, int end){
		
		return arr;
	}

}
