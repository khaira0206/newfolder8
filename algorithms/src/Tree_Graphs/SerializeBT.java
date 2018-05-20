package Tree_Graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SerializeBT {

	public static final String SEP = "," ;
	public static final String NULL = null ;
	StringBuilder sb = new StringBuilder();
	public static void main(String[] arg){
		TreeNode tn = new TreeNode(6);
		int[] arr = {17,0,1,2,21,25,29,33,3,4,5,7,10,11,12,15,8,9,17,19,20};
		
		for(int i = 0; i < arr.length; i++){
			tn.insertInOrder(arr[i]);
		}
		SerializeBT sb = new SerializeBT();
		PrintBT pb = new PrintBT();
		
		pb.prettyPrint(tn);
		StringBuilder sb1 = new StringBuilder();
		sb.serialize(tn, sb1);
		
		pb.prettyPrint(sb.deserialize(sb.serialize1(tn)));
	}
	
	public void print(TreeNode node){
		
		if(node == null) return;
		System.out.println(node.data);
		
		if(node.left != null)
			print(node.left);
		if(node.right != null)
			print(node.right);
			
		
	}
	public String serialize(TreeNode root, StringBuilder sb){
		
		if(root == null)
			return NULL;
		sb.append(root.data).append(SEP);
		
		if(root.left != null)
		serialize(root.left, sb);
		if(root.right != null)
		serialize(root.right, sb);
		return sb.toString();
		
	}
	public String serialize1(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) return NULL;
        //traverse it recursively if you want to, I am doing it iteratively here
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while (!st.empty()) {
            root = st.pop();
            sb.append(root.data).append(SEP);
            if (root.right != null) st.push(root.right);
            if (root.left != null) st.push(root.left);
        }
        return sb.toString();
    }
	
	public TreeNode deserialize(String str){
		
		String[] arr = str.split(SEP);
		
		Queue<Integer> queue = new LinkedList<Integer>();
		for(String string: arr){
			queue.add(Integer.parseInt(string));
		}
		
		return getNode(queue);
		
	}
	
	private TreeNode getNode(Queue<Integer> q){
		
		if(q.isEmpty()) return null;
		
		TreeNode root = new TreeNode(q.poll());
		Queue<Integer> smallerQueue = new LinkedList<>();
		while(!q.isEmpty() && q.peek() < root.data){
			smallerQueue.offer(q.poll());
		}
		root.left = getNode(smallerQueue);
		root.right = getNode(q);
		return root;
	}
}
