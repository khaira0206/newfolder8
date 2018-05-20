package hard;

import java.util.ArrayList;
import java.util.Collections;

class HtWt implements Comparable<HtWt>{
	
	private int height;
	private int weight;
	
	public HtWt(int h, int w){
		height = h;
		weight = w;
		
	}
	public int compareTo(HtWt second){
		
		if(this.height != second.height){
			return ((Integer)this.height).compareTo(second.height);	
		}
		else{
			return ((Integer)this.weight).compareTo(second.weight);
		}
		
	}
	public boolean isBefore(HtWt other){
		if(height < other.height && weight < other.weight){
			return true;
		}else{
			return false;
		}
			
	}
	
}

public class circusTower{

	public static void main(String arg[]){
		
		
		
	}
	
	ArrayList<HtWt> longestIncreasingSeq(ArrayList<HtWt> items){
		Collections.sort(items);
		return bestSeqAtIndex(items, new ArrayList<HtWt>(), 0);
	}
	
	ArrayList<HtWt> bestSeqAtIndex(ArrayList<HtWt> array, ArrayList<HtWt> sequence, int index){
		if(index >= array.size())
			return sequence;
		
		HtWt value = array.get(index);
		
		ArrayList<HtWt> bestWith = null;
		if(canAppend(sequence, value)){
			ArrayList<HtWt> sequenceWith = (ArrayList<HtWt>) sequence.clone();
			sequenceWith.add(value);
			bestWith = bestSeqAtIndex(array, sequenceWith, index + 1);
		}
		
		ArrayList<HtWt> bestWithout = bestSeqAtIndex(array, sequence, index + 1);
		return max(bestWith, bestWithout);
		
	}
	ArrayList<HtWt> max(ArrayList<HtWt> seq1, ArrayList<HtWt> seq2){
		if(seq1 == null){
		return seq2;
		}else if(seq2 == null){
			return seq1;
		}
		return seq1.size() > seq2.size() ? seq1 : seq2;
		
	}
	
	boolean canAppend(ArrayList<HtWt> solution, HtWt value){
		if(solution == null) return false;
		if(solution.size() == 0) return true;
		
		HtWt last = solution.get(solution.size() - 1);
		return last.isBefore(value);
		
	}
	
}
