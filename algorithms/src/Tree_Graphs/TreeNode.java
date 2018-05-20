package Tree_Graphs;

public class TreeNode {
	
	class TreeNodeWC{
		int val;
		int count;
	    TreeNodeWC left;
	    TreeNodeWC right;
	    public TreeNodeWC(Integer x) {
			val = x;
			count = 1;
		}
	}
	
	public static void main(String[] args){
		TreeNode tn = new TreeNode(6);
		int[] arr = {0,1,2,3,4,5,7,8,9};
		
		for(int i = 0; i < arr.length; i++){
			tn.insertInOrder(arr[i]);
		}
		int val =5;
		System.out.println("Size of node : "+ tn.find(val).data + " is " +tn.find(val).size);
		
		System.out.println(tn.kthSmallest(tn, 5));
	}
	
	public int data;
	TreeNode left, right, parent;
	private int size = 0;

	public TreeNode(Integer val){
		data = val;
		size = 1;
	}
	
	public void insertInOrder(int d){
		
		if(d <= data){
			if(left == null){
				setLeftChild(new TreeNode(d));
			}
			else{
				left.insertInOrder(d);
			}
		}else{
			if(right == null){
				setRightChild(new TreeNode(d));
			}
			else{
				right.insertInOrder(d);
			}
		}
		size++;
	}
	
	public int size(){
		return size;
	}
	
	public TreeNode find(int val){
		if(val == this.data){
			return this;
		}
		else if(val < this.data){
			return left != null ? left.find(val): null;
		}
		else if(val > this.data){
			return right != null ? right.find(val): null;
		}
		
		return null;
	}
	
	public void setLeftChild(TreeNode left){
		
		this.left = left;
		if(left != null){
			left.parent = this;
		}
	}
	public void setRightChild(TreeNode right){
		
		this.right = right;
		if(right != null){
			right.parent = this;
		}
	}
	
	private TreeNodeWC buildTreeWC(TreeNode root){
		if(root == null) return null;
		
		TreeNodeWC rootWC = new TreeNodeWC(root.data);
		rootWC.left = buildTreeWC(root.left);
		rootWC.right = buildTreeWC(root.right);
		if(rootWC.left != null) rootWC.count += rootWC.left.count;
		if(root.right != null) rootWC.count += rootWC.right.count;
		return rootWC;
	}
	public int kthSmallest(TreeNode root, int k){
		TreeNodeWC rootWC = buildTreeWC(root);
		return kthSmallestElement(rootWC, k);
		
	}
	
	private int kthSmallestElement(TreeNodeWC node, int k){

		if(k < 0 || k > node.count) return -1;
		
		if(node.left != null){
			if(node.left.count >= k){
				return kthSmallestElement(node.left, k);
			}
			if(node.left.count == k-1) 
				return node.val;
		
		return kthSmallestElement(node, k - 1 - node.left.count);
		}
		else{
			if(k == 1) return node.val;
			return kthSmallestElement(node.right, k - 1);
		}
	}
	
}
