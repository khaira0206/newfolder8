package moderate;

import java.util.HashSet;

public class divingBoard1 {

	public static void main(String arg[]){
		
		divingBoard1 db = new divingBoard1();
	}
	
	HashSet<Integer> allLengths(int k , int shorter, int longer){
		
		HashSet<Integer> lengths = new HashSet<Integer>();
		HashSet<String> visited = new HashSet<String>();
		
		getAllLengths(k, 0, shorter, longer, lengths, visited);
		
		return null;	
	}
	void getAllLengths(int k, int total, int shorter, int longer, HashSet<Integer> lengths, HashSet<String> visited){
		
		if(k == 0){
			lengths.add(total);
		}
		String key = k + " " + total;
		if(visited.contains(key)){
			return;
			
		}
		getAllLengths(k - 1, total + shorter, shorter, longer, lengths, visited);
		getAllLengths(k - 1, total + longer, shorter, longer, lengths, visited);
	
		visited.add(key);
		
	}
	
	
}
