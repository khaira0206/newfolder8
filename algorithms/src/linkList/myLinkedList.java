package linkList;

public class myLinkedList {
	
	public static void main( String[] args){
		
		myLinkedList ml = new myLinkedList();
		ml.add("1");
		ml.add("2");
		ml.add("3");
		ml.add("4");
		ml.add("5");
		
		System.out.println("My LinkedList is :" + ml);
		System.out.println("Get the size of the list :"+ ml.size());
		System.out.println("Get the 2 element :" + ml.get(2));
		System.out.println("Remove 2 element :"+ ml.remove(2));
		System.out.println("Get the size of the list :"+ ml.size());
		
	}
	int counter;
	Node head;
	
	
	public int getCounter() {
		return counter;
	}


	
	public void increamentCounter(){
		counter ++;
	}
    public void decreamentCounter(){
    	counter --;
    }
     public myLinkedList(){
    	 
    	 
     }
     
     public void add(Object data){
    	 
    	 if(head == null){
    		 head = new Node(data);
    	 }
    	 Node mytempNode = new Node(data);
    	 
    	 Node current = head;
    	 if(current != null){
    	 while(current.getNext() != null){
    		 
    		current= current.getNext();
    		 
    	 }
    	 current.setNext(mytempNode)  ;
    	 }
    	 increamentCounter();
    			 
     }
    
    public void add(Object data, int index){
    	
    	if(head == null){
   		 head = new Node(data);
   	 }
   	 Node mytempNode = new Node(data);
   	 
   	 Node current = head;
   	 if( current != null){
   	 for(int i = 0; i < index && current.getNext() != null; i++){
   		 
   		 if(current.getNext() == null)
   		 current = current.getNext();
   	 }
   	 mytempNode.setNext(current.getNext());
   	 current.setNext(mytempNode);
   	 
   	 
   	 }
   	 increamentCounter();
    }
    public Object get(int index){
    	
    	if(index < 0){
    		return null;
    	}
    
    	Node current = null ;
    	if(head != null){
    		current = head.getNext();
    	for(int i=0; i < index; i++){
    		if(current.getNext() == null){
    			return null;
    		}
    		current = current.getNext();
    	}
    	return current.data;
    }
    	return current;
    	}
    
    public boolean remove( int index){
    	
    	if(index < 0 || index > size())
    	{
    		return false;
    	}
    	
    	Node current = head;
    	
    	for(int i = 0 ; i <= index ; i++){
    		current = current.getNext();
    	
    	}
    	current.setNext(current.getNext());
    	decreamentCounter();
    	return true;
    }
    
    public int size(){
    	 return getCounter();
    	
    }
    
    public String toString(){
    	
    	String output = "";
    	
    	Node current;
    	if(head != null){
    	current = head.getNext();
    	while(current != null){
    	
    		output += "[" + current.getData().toString() +"]"; 
    		current = current.getNext();
    		
    	}
    	}
    	return output;
    }
    

	

}

