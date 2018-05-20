package linkList;

import java.util.Stack;

import linkList.palindrome3.myList;

public class palindrome1 {

	public static void main(String arg[]){
		myList ml = new myList();
		ml.add("1");
		ml.add("2");
		ml.add("3");
		ml.add("4");
		ml.add("3");
		ml.add("2");
		ml.add("1");
		
		palindrome1 pal = new palindrome1();
		pal.show(ml.head);
		System.out.println(" List is Palinndrome : "+pal.isPalindrome(ml.head.next));
		
	}
	
	public boolean isPalindrome(Node head){
		
		Node slow = head;
		Node fast = head;
		
		Stack<Object> stack = new Stack<Object>();
		
		while(fast != null && fast.next != null){
			stack.push(slow.data);
			slow = slow.getNext();
			fast = fast.getNext().getNext();
			
		}
		
		if(fast != null){
			slow = slow.getNext();
		}
		
		while(slow != null){
			Object top = stack.pop();
			
			if(top != slow.data){
				return false;
			}
			slow = slow.getNext();
			
		}
		return true;
		
	}
	
	public void show(Node head){
		Node current = head.getNext();
		while(current != null){
			
			System.out.println("["+ current.data+"]");
			current = current.getNext();
		}
		
	}
	
	static class myList{
		
		Node head;
		
		public void add(Object data){
			
			if(head == null){
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
