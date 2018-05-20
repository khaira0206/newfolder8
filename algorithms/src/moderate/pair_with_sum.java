package moderate;

import java.util.ArrayList;
import java.util.HashMap;

class Pair{
	
	int a , b;
	Pair(int a, int b){
		this.a = a;
		this.b = b;
	}
}

public class pair_with_sum {

	public static void main(String arg[]){
		int[] arr = {1,2,3,4,5,6,7,-2};
		int i = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int a : arr){
			map.put(i, a);
			i++;
		}
		pair_with_sum pws = new pair_with_sum();
		ArrayList<Pair> pairs = pws.printPairSum(arr, 5, map);
		for(Pair pair : pairs){
			
			System.out.println("Pairs with sum are :"+ pair.a +" "+ pair.b);
			
		}
		
	}
	
	public ArrayList<Pair> printPairSum(int[] arr, int sum, HashMap<Integer, Integer> map){
		
		ArrayList<Pair> result = new ArrayList<Pair>();
		int commplement;
		for(int a : arr){
			commplement = sum - a;
			if(map.containsValue(commplement)){
				result.add(new Pair(a, commplement));
			}
			
		}
		return result;
		
	}
	
}
