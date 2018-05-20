package Tree_Graphs;

import java.util.ArrayList;
import java.util.List;

class TreeNode{
	
	TreeNode left;
	TreeNode right;
	int val;
	
	public TreeNode(int val){
		this.val = val;
	}
}

public class modeInBST {
	 Integer prev = null;
	    int count = 1;
	    int max = 0;
	    public int[] findMode(TreeNode root) {
	        if (root == null) return new int[0];
	        
	        List<Integer> list = new ArrayList<Integer>();
	        traverse(root, list);
	        
	        int[] res = new int[list.size()];
	        for (int i = 0; i < list.size(); ++i) res[i] = list.get(i);
	        return res;
	    }
	    
	    private void traverse(TreeNode root, List<Integer> list) {
	        if (root == null) return;
	        traverse(root.left, list);
	        if (prev != null) {
	            if (root.val == prev)
	                count++;
	            else
	                count = 1;
	        }
	        if (count > max) {
	            max = count;
	            list.clear();
	            list.add(root.val);
	        } else if (count == max) {
	            list.add(root.val);
	        }
	        prev = root.val;
	        traverse(root.right, list);
	    }

	    public static void main(String args[]){
	    
	    	TreeNode node =  new TreeNode(5);
	    	node.left = new TreeNode(5);
	    	node.right = new TreeNode(6);
	    	node.left.left = new TreeNode(3);
	    	node.left.right = new TreeNode(4);
	    	node.left.left.left = new TreeNode(2);
	    	node.left.left.right = new TreeNode(3);
	    
	    	
	    modeInBST mode = new modeInBST();
	   int [] arr =  mode.findMode(node);
	    for(int i = 0; i < arr.length; i++){
	    	System.out.println(arr[i]);
	    }
	    
	    }
	    
}
