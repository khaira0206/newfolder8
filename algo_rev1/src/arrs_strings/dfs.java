package arrs_strings;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class dfs {

	public static void main(String arg[]){
		dfs df = new dfs(3);
		df.addEdge(0, 1);
		df.addEdge(1, 2);
		df.addEdge(2, 0);
		df.DFS(0);
		
	}
	
	int num_V;
	Map<Integer, List<Integer>> adj_List;
	
	public dfs(int V){
		num_V = V;
		adj_List = new HashMap<Integer, List<Integer>>();
		
		for(int i = 0; i < num_V; i++){
			adj_List.put(i, new LinkedList<Integer>());
		}	
	}
	public void addEdge(int u, int v){
	  List<Integer> list = adj_List.get(u);
	  list.add(v);
	  adj_List.put(u, list);
	}
	
	public void DFS(int v){
		boolean[] visited = new boolean[num_V];
		
		DFSUtil(v,visited,adj_List);
	}
	public void DFSUtil(int v, boolean[] visited, Map<Integer, List<Integer>> list){
		
		visited[v] = true;
		Integer i;
		System.out.println(v+" ");
		Iterator<Integer> it = list.get(v).iterator();
		while(it.hasNext()){
			i = it.next();
			if(!visited[i]){
			DFSUtil(i, visited, list);
		}
		}
		
	}
	
	
}
