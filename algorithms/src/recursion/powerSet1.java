package recursion;

import java.util.ArrayList;

interface myInterface<T> {
	
    <T>  ArrayList<ArrayList<T>> getSubsets(ArrayList<T> b, int a);
	
}

public class powerSet1<T> implements myInterface<T>{

	public static void main(String arg[]){
		
		ArrayList<Integer> al = new ArrayList<>();
		al.add(1);
		al.add(2);
		al.add(3);
		
		powerSet1 ps = new powerSet1();
		System.out.println(ps.getSubsets(al, 0));
		
		ArrayList<String> als = new ArrayList<String>();
		als.add("a");
		als.add("b");
		als.add("c");
		
		System.out.println(ps.getSubsets(als, 0));
	}
	 public <T> ArrayList<ArrayList<T>> getSubsets(ArrayList<T> set , int index){
		
		ArrayList<ArrayList<T>> allsubsets;
		if(set.size() == index){
			
			allsubsets = new ArrayList<ArrayList<T>>();
			allsubsets.add(new ArrayList<T>());
		}
		
		else{
			allsubsets = getSubsets(set, index +1);
			Object item = set.get(index);
					
			ArrayList<ArrayList<T>> moreSubsets = new ArrayList<ArrayList<T>>();
			
			for(ArrayList<T> subset : allsubsets){
				
				ArrayList<T> newSubset = new ArrayList<T>();
				newSubset.addAll(subset);
				newSubset.add((T) item);
				moreSubsets.add(newSubset);
				
			}
			allsubsets.addAll(moreSubsets);
			
		}
		
		return allsubsets;
	}
	

		
}
