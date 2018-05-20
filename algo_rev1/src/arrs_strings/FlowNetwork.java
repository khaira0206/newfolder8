package arrs_strings;

import java.util.LinkedList;
import java.util.Random;

public class FlowNetwork {
    private final int V;
    private int E;
    private LinkedList<FlowEdge>[] adj;
    Random random = new Random();
    // empty graph with V vertices
    @SuppressWarnings("unchecked")
	public FlowNetwork(int V) {
        this.V = V;
        this.E = 0;
        adj = (LinkedList<FlowEdge>[]) new LinkedList[V];
        for (int v = 0; v < V; v++)
            adj[v] = new LinkedList<FlowEdge>();
    }

    // random graph with V vertices and E edges
    public FlowNetwork(int V, int E) {
        this(V);
        for (int i = 0; i < E; i++) {
        	
            int v = random.nextInt(V);
            int w = random.nextInt(V);
            double capacity = random.nextInt(100);
            addEdge(new FlowEdge(v, w, capacity));
        }
    }

   

    // number of vertices and edges
    public int V() { return V; }
    public int E() { return E; }

    // add edge e in both v's and w's adjacency lists
    public void addEdge(FlowEdge e) {
        E++;
        int v = e.from();
        int w = e.to();
        adj[v].add(e);
        adj[w].add(e);
    }

    // return list of edges incident to  v
    public Iterable<FlowEdge> adj(int v) {
        return adj[v];
    }

    // return list of all edges - excludes self loops
    public Iterable<FlowEdge> edges() {
    	LinkedList<FlowEdge> list = new LinkedList<FlowEdge>();
        for (int v = 0; v < V; v++)
            for (FlowEdge e : adj(v)) {
                if (e.to() != v)
                    list.add(e);
            }
        return list;
    }


    // string representation of Graph (excludes self loops) - takes quadratic time
    public String toString() {
        String NEWLINE = System.getProperty("line.separator");
        StringBuilder s = new StringBuilder();
        s.append(V + " " + E + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(v + ":  ");
            for (FlowEdge e : adj[v]) {
                if (e.to() != v) s.append(e + "  ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }

   
   

}
