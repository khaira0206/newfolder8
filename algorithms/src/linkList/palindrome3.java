package linkList;

public class palindrome3 {

	public static void main(String arg[]){
		
		myList ml = new myList();
		ml.add("1");
		ml.add("2");
		ml.add("3");
		ml.add("4");
		ml.add("3");
		ml.add("2");
		ml.add("1");
		
		palindrome3 pal = new palindrome3();
		pal.show(ml.head);
		System.out.println(" List is Palinndrome : "+pal.isPalindrome(ml.head.next));
		
	}
	
	public boolean isPalindrome(Node node){
		int length = length(node);
		Result res = isPalHelper(node, length);
		
		return res.result;
		
	}
	
	public Result isPalHelper(Node head, int len){
		
		if(head == null || len == 0){
			return new Result(head , true);
		}
		else if(len == 1){
			return new Result(head.getNext(), true);
		}
		
		Result res = isPalHelper(head.getNext(), len - 2);
		
		if(!res.result || res.node == null){
			return res;
		}
		
		res.result = (head.data == res.node.data);
		
		res.node = res.node.getNext();
				
		
		
		return res;
	}
	public int length(Node node){
		int len = 0;
		Node current = node;
		while(current != null){
			current = current.getNext();
			len ++;
		}
		
		return len;
	}
	public void show(Node head){
		
		Node current = head.getNext();
		
		if(current != null)
		{
			while(current != null){
				
				System.out.println("["+ current.data+"]");
				current = current.getNext();
			}
		}
	}
	
	class Result{
		
	public Node node;
	public boolean result;	
	
	public Result(Node node, boolean result){
		
		this.node = node;
		this.result = result;
		
	}
	
	}
	
	static class myList{
		Node head;
		
		
		public void add(Object data){
			
			if(head == null)
			{
				head = new Node(data);
				
			}
			
			Node temp = new Node(data);
			Node current = head;
			if(current != null){
			while(current.getNext() != null){
				
				current = current.getNext();
				
			}
			
			}
			current.setNext(temp);
			
			
		}
		
	}
	
	static class Node{
		
	  Object data;
	  Node next;
	  
	  public Node(Object data){
		  this.data = data;
		  this.next = null;
		  
	  }

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
		
	}
}
