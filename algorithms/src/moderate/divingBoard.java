package moderate;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class divingBoard {

	public static void main(String arg[]){
		
		
		
		divingBoard db = new divingBoard();
		HashMap<Integer, Boolean> lens = db.allLengths(4, 4, 5);
		
		Iterator iter = lens.entrySet().iterator() ;
		
		while(iter.hasNext()){
			Map.Entry<Integer, Boolean> pair = (Map.Entry<Integer, Boolean>)iter.next();
			System.out.println(" Lengths of the plank  "+pair.getKey());
		}
		
	}
	HashMap<Integer, Boolean> allLengths(int k, int shorter, int longer){
		
		HashMap<Integer, Boolean> lengths = new HashMap<Integer, Boolean>();
		
		getAllLengths(k, 0 , shorter, longer, lengths);
		
		return lengths;
	}
	 void getAllLengths(int k, int total, int shorter, int longer, HashMap<Integer, Boolean> lengths) {
		
		 if(k == 0){
			 lengths.put(total, true);
			 return;
		 }
		 getAllLengths(k - 1, total + longer, shorter, longer, lengths);
		 getAllLengths(k - 1, total + shorter, shorter, longer, lengths);
		
	}
	
}
