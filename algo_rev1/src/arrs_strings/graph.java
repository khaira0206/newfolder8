package arrs_strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class graph{
	int number_V;
	public Map<Integer, List<Integer>> adj_list;
	
	public graph(int number_V){
		this.number_V = number_V;
		adj_list = new HashMap<Integer, List<Integer>>();
		for(int i = 0; i < number_V; i++){
			adj_list.put(i, new LinkedList<Integer>());
		}
		
	}
	public void addEdge(int src, int dest){
		
		if(src > adj_list.size() || dest  > adj_list.size()){
			System.out.println("Vertex entered is not present");
			return;
		}
		List<Integer> slist = adj_list.get(src);
		slist.add(dest);
		adj_list.put(src, slist);
		List<Integer> dlist = adj_list.get(dest);
		dlist.add(src);
		adj_list.put(dest, dlist);
		
	}
	public List<Integer> getEdge(int src){
		
		if(src > adj_list.size()){
			System.out.println("Vertex is not present");
		}
		
		return adj_list.get(src);
	}
	
	boolean isCycle(){
		
		boolean visited[] = new boolean[number_V];
		for(int i = 0; i < number_V; i++){
			visited[i] = false;
		}
		
		for(int u = 0; u < number_V; u++){
			if(!visited[u])
			if(isCycleUtil(u , visited, -1))
				return true;
		}
		return false;
	}
	boolean isCycleUtil(int v , boolean[] visited, int parent){
		
		visited[v] = true;
		Integer i ;
		Iterator<Integer> it = adj_list.get(v).iterator();
		while(it.hasNext()){
			i = it.next();
			if(!visited[i]){
				if(isCycleUtil(i, visited, v));
				return true;
			}
			else if(i != parent){
				return true;
			}
			
		}
		return false;
	}
	
	
	
	public static void main(String arg[]){
		
		graph gp = new graph(5);
		gp.addEdge(1, 0);
		gp.addEdge(0, 2);
		gp.addEdge(2, 1);
		gp.addEdge(0, 3);
		gp.addEdge(3, 4);
		
		if(gp.isCycle()){
			System.out.println("Graph contains cycle");
		}
		else{
			System.out.println("Graph doesn't contains cycle");
		}
	}


	
}
