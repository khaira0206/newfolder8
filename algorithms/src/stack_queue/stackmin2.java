package stack_queue;

import java.util.Stack;

public class stackmin2 extends Stack<Integer>{

public static void main(String arg[]){
		
		
	}
	
	Stack<Integer> s2;
	
	public  stackmin2(){
		s2 = new Stack<Integer>();
		
	}
	
	public void push(int value){
		
		if(value < min()){
			s2.push(value);
		}
		super.push(value);
		
		
	}
	
	public Integer pop(){
		int value =super.pop();
		if(value == min()){
			s2.pop();
			
		}
		return value;
	}
	
	public Integer min(){
		if(s2.isEmpty()){
			
			return Integer.MAX_VALUE;
		}
		
		return s2.peek();
	}
	
	
	
}
