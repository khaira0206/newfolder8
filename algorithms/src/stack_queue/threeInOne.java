package stack_queue;

import java.util.EmptyStackException;


public class threeInOne {

	int numberOfStacks = 3;
	int[] sizes;
	int capacity;
	int[] values;
	
	public threeInOne(int capacity){
		
		values = new int[capacity * numberOfStacks];
		sizes = new int[numberOfStacks];
		this.capacity = capacity;
	}
	
	
	public static void main(String arg[]) throws Exception{
		threeInOne tio = new threeInOne(10);
			tio.push(0, 12);
			tio.push(0, 125);
			tio.push(0, 52);
			tio.push(0, 72);
			
			tio.push(1, 45);
			tio.push(1, 75);
			tio.push(1, 95);
			tio.push(1, 85);
			
			tio.push(2, 54);
			tio.push(2, 56);
			tio.push(2, 58);
			tio.push(2, 51);
			
			System.out.println(tio.peek(0));
			System.out.println(tio.peek(1));
			System.out.println(tio.peek(2));

	}
	
	public void push(int stacknum, int value) throws Exception{
		
		if(isFull(stacknum)){
			
			throw new Exception();
		}
		sizes[stacknum]++;
		values[indexOfTop(stacknum)]= value;
	}
	
	public int pop(int stacknum){
		
		if(isEmpty(stacknum)){
			throw new EmptyStackException();
		}
		
		
		int value = values[indexOfTop(stacknum)];
		sizes[stacknum]--;
		return value;
	}
	public int peek(int stacknum){
		
		if(isEmpty(stacknum)){
			throw new EmptyStackException();
		}
		
		return values[indexOfTop(stacknum)];
		
	}
	public boolean isFull(int stacknum){
		
		return sizes[stacknum] == capacity;
		
	}
	public boolean isEmpty(int stacknum){
		return sizes[stacknum] == 0;
		
	}
	public int indexOfTop(int stacknum){
		int offset = stacknum * capacity;
		int size = sizes[stacknum];
		return offset + size -1;
	}
	
	
}
