package sortingSearching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

class HashMapList<T , E>{
	
	private HashMap<T , ArrayList<E>> map = new HashMap<T , ArrayList<E>>();
	
	public void put(T key , E item){
		if(!map.containsKey(key)){
			map.put(key, new ArrayList<E>());
		}
		
		map.get(key).add(item);
		
	}
	public void put(T key , ArrayList<E> item){
		
		map.put(key, item);
		
	}
	public ArrayList<E> get(T key){
		
		return map.get(key);
	}
	public boolean containsKey(T key){
		
		return map.containsKey(key);
		
	}
	public boolean containsKeyValue(T key , E item){
		
		ArrayList<E> list = get(key);
		if(list == null) return false;
		return list.contains(item);
	}
	public Set<T> keySet(){
		return map.keySet();
		
	}
	public String toString(){
		return map.toString();
		
	}
	
}

public class groupAnagrams {

	public static void main(String arg[]){
		
		String[] arr = {"race","fcuk","cine","yara","aayr","yraa","fkuc","care","nice","acre"};
		groupAnagrams ga = new groupAnagrams();
		ga.sort(arr);
		
		for(String str : arr){
			System.out.println(str);
		}
		
	}
	
	void sort(String[] arr){
		HashMapList<String , String> mapList = new HashMapList<String , String>();
		
		for(String s : arr){
			
			String key = sortChars(s);
			mapList.put(key, s);
			
		}
		int index = 0;
		for(String key : mapList.keySet()){
			
			ArrayList<String> list = mapList.get(key);
					
			for(String str : list){
				
				arr[index] = str;
				index ++;
			}
			
		}
		
	}
	
	public String sortChars(String str){
		
		char[] content = str.toCharArray();
		Arrays.sort(content);
		return new String(content);
		
	}
	
}
