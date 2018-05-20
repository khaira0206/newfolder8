package moderate;

import java.util.HashSet;

public class divingBoard2 {

	public static void main(String arg[]){
		
		divingBoard2 db = new divingBoard2();
		HashSet<Integer> lens = db.allLength(4, 4, 5);
		int i = 0;
		for(Integer len : lens){
			i++;
			System.out.println(" Lengths of the "+i +"th plank  "+len);
			
		}
		
	}

	HashSet<Integer> allLength( int k, int shorter, int longer){
		
		HashSet<Integer> lengths = new HashSet<Integer>();
		
		for(int nShorter = 0; nShorter <= k; nShorter++){
			
			int nLonger = k - nShorter;
			int length = nShorter * shorter + nLonger * longer;
			lengths.add(length);
		}
		return lengths;
	}
}
