package stack_queue;

import java.util.ArrayList;
import java.util.EmptyStackException;


interface myInterface<T>{
	
	boolean push(T a);
	T pop();
	
}


class Node<T> implements myInterface<T>{
	
	Node above;
	T data;
	Node below;
	
	Node(T data){
		this.above = null;
		this.data = data;
		this.below = null;
		
	}

	public boolean push(T a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T pop() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}

 class Stack1<T> implements myInterface<T> {
	
	private int capacity;
	public Node<T> top , bottom;
	public int size = 0;
	
	public Stack1(int capacity){
		this.capacity = capacity;
	}
	public boolean isFull(){
		
			return size == capacity;
	}
	
	public void join(Node<T> above, Node<T> below){
		
		if(below != null) below.above = above;
		if(above != null) above.below = below;
	}
	
	public boolean push(T data){
		
		if(size >= capacity){
			
		return false;
		}
		size ++;
		
		Node<T> n = new Node<T>(data);
		
		if(size == 1) bottom = n;
		join(n,top);
		top = n;
		return true;
		}
	public T pop(){
		
		Node<T> t = top;
		top = top.below;
		size--;
		return t.data;
		
	}
	public boolean isEmpty(){
		return size == 0;
	}
	public T removeBottom(){
		
		Node<T> b = bottom;
		bottom = bottom.above;
		if(bottom != null)
			bottom.below = null;
		return b.data;
	}
	
	
}

public class stackOfPlates<T> implements myInterface<T>{

	ArrayList<Stack1<T>> stacks = new ArrayList<Stack1<T>>(); 
	int capacity;
	
	public stackOfPlates(int capacity){
		this.capacity = capacity;
	}
	
	public static void main(String args[]){
		
		
	}
	
	public Stack1<T> getLastStack(){
		
		if(stacks.size() == 0) return null;
		return stacks.get(stacks.size() -1);
		
	}
	
	public  boolean push(T data){
		
		Stack1<T> last =  getLastStack();
		if(last != null && !last.isFull()){
			last.push(data);
		}
		else{
			Stack1 stack = new Stack1(capacity);
		    stack.push(data);
		    stacks.add(stack);
		}
		return true;
	}
	public T pop(){
		Stack1<T> last =  getLastStack();
		if(last == null)
		throw new EmptyStackException();
		T v = last.pop();
		if(last.size == 0)
			stacks.remove(stacks.size() -1);
		return v;
	}
	
	public T popAt(int index){
		return leftShift(index, true);
		
	}
	public T leftShift(int index, boolean removeTop){
		
		Stack1 stack = stacks.get(index);
		
		T removed_item;
		if(removeTop) 
			removed_item = (T) stack.pop();
		else 
			removed_item = (T) stack.removeBottom();
		if(stack.isEmpty()){
			stacks.remove(index);
		}
		else if(stacks.size() > index +1){
			T v = leftShift(index +1, false);
			stack.push(v);
		
		}
		return removed_item;
		
	}


	
	
	
	
}
