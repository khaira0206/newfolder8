package recursion;

import java.util.ArrayList;

public class powerSet {
	
	public static void main(String arg[]){
		
		ArrayList<Integer> al = new ArrayList<>();
		al.add(1);
		al.add(2);
		al.add(3);
		
		powerSet ps = new powerSet();
		System.out.println(ps.getSubsets(al, 0));
		
		
	}
 ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set , int index){
	 
	 ArrayList<ArrayList<Integer>> allsubsets;
	 
	 if(set.size() == index){
		 allsubsets = new ArrayList<ArrayList<Integer>>();
		 allsubsets.add(new ArrayList<Integer>());
	 }
	 else{
	 allsubsets = getSubsets(set, index +1);
	
	 int item = set.get(index);
	 ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<ArrayList<Integer>>();
	 
	 for(ArrayList<Integer> subset : allsubsets){
		 
		 ArrayList<Integer> newsubset = new ArrayList<>();
		 newsubset.addAll(subset);
		 newsubset.add(item);
		 moresubsets.add(newsubset);
		 
	 }
	 allsubsets.addAll(moresubsets);
	 }
	 return allsubsets;
 }
	
}
