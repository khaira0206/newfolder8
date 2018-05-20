package arrs_strings;

public class V {
	int id ;
	 String label ;
	 int[] incoming ;
	 int outgoing[] ;
	 double rank;
	
	 public V(
	 int id, // int defining the position of the vertex in an array of vertices
	 String label, // meaningful to humans name given to this node
	 int[] incoming, // set of ids of incoming edges
	 int outgoing[], // set of ids of outgoing edges
	 double rank) // value in 0..1 computed by a ranking algorithm
	 {
		 this.id = id;
		 this.label = label;
		 this.incoming =incoming;
		 this.outgoing = outgoing;
		 this.rank = rank;
				 
	 
	 }
	 
	 public String toString(){
		 String str =" ";
		 String str1 =" ";
		 for(int i = 0; i < incoming.length ; i++)
			  str += incoming[i]+" ";
		 for(int i = 0; i < outgoing.length ; i++)
			  str1 += outgoing[i]+" ";
		 
		 String out = this.id + " " + this.label + str + str1 + this.rank;
		 
		 return out;
	 }
	 
	 public static void main(String arg[]){
		 int[] in = {2,3,4};
		 int[] out = {5,1,7};
		 V ob = new V(1, "A",in , out, 0.34);
		 System.out.println(""+ ob);
	 }
	 
	 }