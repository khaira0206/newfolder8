package arrs_strings;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class MyDynamicStack {
 
    private int stackSize;
    private int[] stackArr;
    private int top;
 
    /**
     * constructor to create stack with size
     */
    public MyDynamicStack(int size) {
        this.stackSize = size;
        this.stackArr = new int[stackSize];
        this.top = -1;
    }
 
    /**
     * This method adds new entry to the top 
     * of the stack
     */
    public void push(int entry){
        if(this.isStackFull()){
            System.out.println(("Stack is full. Increasing the capacity."));
            this.increaseStackCapacity();
        }
        System.out.println("Adding: "+entry);
        this.stackArr[++top] = entry;
    }
 
    /**
     * This method removes an entry from the 
     * top of the stack.
     */
    public int pop() throws Exception {
    	 int entry = this.stackArr[--top];
         System.out.println("Removed entry: "+entry);
    	if(isQuaterFull()){
       	 System.out.println(("Stack is quater full. decreasing the capacity."));
       	this.decStackCapacity();
       	
       }
        if(this.isStackEmpty()){
            throw new Exception("Stack is empty. Can not remove element.");
        }
        
        
        
       
       
        return entry;
    }
     
    
 
    private void increaseStackCapacity(){
         
        int[] newStack = new int[this.stackSize*2];
        for(int i=0;i<stackSize;i++){
            newStack[i] = this.stackArr[i];
        }
        this.stackArr = newStack;
        this.stackSize = this.stackSize*2;
    }
     
    private void decStackCapacity(){
    	int[] newStack = new int[this.stackSize/2];
    	for(int i=0;i<(stackSize/4);i++){
            newStack[i] = this.stackArr[i];
        }
        this.stackArr = newStack;
        this.stackSize = this.stackSize*(1/2);
    }
    /**
     * This method returns true if the stack is 
     * empty
     */
    public boolean isStackEmpty() {
        return (top == -1);
    }
 
    
    public boolean isQuaterFull() {
        return (top <= (stackSize)/4  );
    }
    /**
     * This method returns true if the stack is full
     */
    public boolean isStackFull() {
        return (top == stackSize-1);
    }
 
    public static void main(String[] args) throws FileNotFoundException {
    	
        MyDynamicStack stack = new MyDynamicStack(2);
        for(int i=1;i<=64;i++){
            stack.push(i);
        }
        for(int i=1;i<=64;i++){
            try {
                stack.pop();
            } catch (Exception e) {
                
                e.printStackTrace();
            }
        }
    }
}