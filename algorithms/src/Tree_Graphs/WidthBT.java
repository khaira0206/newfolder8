package Tree_Graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class WidthBT {

	public static void main(String[] arg){
		
	}
	
	public int widthBT(TreeNode root){
		Map<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		map.put(root, 1);
		queue.add(root);
		int curW = 0;
		int maxW = 0;
		while(!queue.isEmpty()){
			int size = queue.size();
			int start = 0;
			int end = 0;
			for(int i = 0; i < size; i++){
				
				TreeNode node = queue.poll();
				if(i == 0) start = map.get(node);
				if(i == size - 1) end = map.get(node);
				if(node.left != null){
					map.put(node.left, map.get(node) * 2);
					queue.offer(node.left);
					
				}
				if(node.right != null){
					map.put(node.right, map.get(node) * 2 + 1);
					queue.offer(node.right);
					
				}
			}
			curW = end-start + 1;
			maxW = Math.max(maxW, curW);
		}
		return maxW;
	}
	
	
	
}
