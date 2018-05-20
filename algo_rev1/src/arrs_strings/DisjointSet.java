package arrs_strings;

class Edge{
	int src, dest;
	
}

public class DisjointSet {

	int V, E;
	Edge edge[];
	public DisjointSet(int V, int E) {
	
		this.V = V;
	    this.E = E;
	    edge = new Edge[E];
	    for(int i = 0; i < E; i++){
	    	edge[i] =  new Edge();	
	    }
	}
	int find(int parent[], int i){
		if(parent[i] == -1)
			return i;
		return find(parent, parent[i]);
	}
	void union(int parent[] ,int x, int y){
		
		int xset = find(parent, x);
		int yset = find(parent, y);
		parent[xset] = yset;
		
	}
	int isCyclic(DisjointSet ds){
		
		int parent[] = new int[ds.V];
		
		for(int i = 0; i < ds.V; i++){
			parent[i] = -1;
		}
		for(int j = 0; j < ds.E; j++){
		int x = ds.find(parent, ds.edge[j].src);
		int y = ds.find(parent, ds.edge[j].dest);
		
		if(x == y){
			return 1;
		}
		union(parent, x, y);
		
		}
		return 0;
	}
	
	public static void main(String arg[]){
		DisjointSet ds = new DisjointSet(4, 3);
		ds.edge[0].src = 0;
		ds.edge[0].dest = 1;
		
		ds.edge[1].src = 1;
		ds.edge[1].dest = 2;
		
		ds.edge[2].src = 2;
		ds.edge[2].dest = 3;
		
		if(ds.isCyclic(ds)== 1){
			System.out.println("Graph contains cycle");
		}
		if(ds.isCyclic(ds)== 0){
			System.out.println("Graph doesn't contains cycle");
		}
	}
	
	
}
