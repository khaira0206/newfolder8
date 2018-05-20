package Tree_Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PrintBT {

	public static void main(String[] arg){
		
	}
	
	public void prettyPrint(TreeNode root){
		WidthBT wb = new WidthBT();
    int h = getHeight(root);
	int w = wb.widthBT(root);	
	List<String> list = new ArrayList<String>();
	List<List<String>> grid = new LinkedList<>();
	for(int i = 0; i < w; i++){
		list.add(".");
	}
	for(int i = 0; i < h; i++){
		grid.add(new ArrayList<>(list));
	}
	helper(root, grid, 0, h, 0, w - 1);
	for(List<String> l1: grid){
		System.out.println("");
		for(String l2 : l1){
			System.out.print("-"+l2 +"-");
		}
		
	}
	
	}
	
	public void helper(TreeNode root, List<List<String>> grid, int row,int totalRows, int i, int j){
		
		if(row == totalRows || root == null) return;
		
		int m = (i + j)/2;
		grid.get(row).set(m, Integer.toString(root.data));
		helper(root.left, grid, row + 1,totalRows, i, (i + j)/2 - 1);
		helper(root.right, grid, row + 1,totalRows, (i + j)/2 + 1, j);
		
	}
	
	public int getHeight(TreeNode root){
		if(root == null) return 0;
		
		return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
	}
}
