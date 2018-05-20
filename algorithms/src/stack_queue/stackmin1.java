package stack_queue;

import java.util.Stack;

public class stackmin1 extends Stack<stackNode> {

	
	public static void main( String[] arg){
		
		
	}
	
	public void push(int val){
		 int min = Math.min(min(),val);
		
		 this.push(new stackNode(val , min));
	}
	public int min(){
		if(this.isEmpty()){
			return Integer.MAX_VALUE;
		}
		return this.peek().min;
		
	}
	
	
	
}
class stackNode{
	int val;
	int min;
	
	public stackNode(int val , int min){
		this.val = val;
		this.min = min;
		
	}
	
}
