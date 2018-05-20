package arrs_strings;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class topologicalSort {

	public static void main(String arg[]){
		
		topologicalSort tpls = new topologicalSort(6);
		tpls.addEdge(5, 2);
		tpls.addEdge(5, 0);
		tpls.addEdge(4, 0);
		tpls.addEdge(4, 1);
		tpls.addEdge(2, 3);
		tpls.addEdge(3, 1);
		tpls.tplSort();
		
	}
	int num_V;
	Map<Integer, List<Integer>> adj_List;
	
	public topologicalSort(int V){
		num_V = V;
		adj_List = new HashMap<Integer, List<Integer>>();
		
		for(int i = 0; i < num_V; i++){
			adj_List.put(i, new LinkedList<Integer>());
		}
		
	}
	public void addEdge(int u, int v){
		
	List<Integer> list =	adj_List.get(u);
	list.add(v);
	adj_List.put(u, list);
	}
	
	public void tplSort(){
		Stack stack = new Stack<Integer>();
		
		boolean visited[] = new boolean[num_V];
		for(int i = 0; i < num_V; i++){
			visited[i] = false;
		}
		for(int j = 0; j < 3; j++){
			if(visited[j] == false){
		tplSortUtil(j, visited, stack);
			}
		}
		while(stack.empty() == false){
			System.out.println(stack.pop() + " ");
		}
		
	}
	public void tplSortUtil(int i, boolean visited[], Stack stack){
		
		visited[i] = true;
		Integer k;
		
		Iterator<Integer> it = adj_List.get(i).iterator();
		
		while(it.hasNext()){
			k = it.next();
			if(!visited[k]){
				tplSortUtil(k, visited, stack);
			}
		}
		stack.push(i);
	}
	
	
}
