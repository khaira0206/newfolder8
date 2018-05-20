package linkList;

import linkList.sumList.myList;

public class sumList2 {

	public static void main(String args[]){
		
		sumList2 sl = new sumList2();

		mylist ml1 = new mylist();
		ml1.add("7");
		ml1.add("1");
		ml1.add("6");

		mylist ml2 = new mylist();

		ml2.add("5");
		ml2.add("9");
		ml2.add("2");
	
		sl.show(sl.addLists(ml1.head.next, ml2.head.next));
		
	}
	public Node addLists(Node l1, Node l2){
		
		int len1 = length(l1);
		int len2 = length(l2);
		
		if(len1 < len2){
			l1 = padList(l1, len2-len1);
		}else{
			l2 = padList(l2, len1 -len2);
		}
		
		Result sum = addHelper(l1,l2);
		
		if(sum.carry == 0){
			
			return sum.sum;
		}
		else{
			
			return insertBefore(sum.sum, sum.carry);
		}
		
	}
	
public Result addHelper(Node l1, Node l2){
		if(l1 == null && l2 == null){
			Result sum = new Result();
			return sum;
		}
		Result sum = addHelper(l1.next, l2.next);
		int val = sum.carry + Integer.parseInt((String)l1.data) + Integer.parseInt((String)l2.data);
		Node full_result = insertBefore(sum.sum, val % 10);
		sum.sum = full_result;
		sum.carry = val/10;
		return sum;
		
		
	}
	
	public int length(Node l1){
		Node current = l1;
		int length = 0;
		if(current != null){
		while(current != null){
			current = current.getNext();
           length ++;			
		}
		}
		return length;
		
	}
	
	public void show(Node head){
		Node current = head;
		
		if(current != null)
			while(current != null){
				System.out.print("[" + current.data + "]  ");
				current = current.getNext();
			}
		
	}
	public Node padList(Node list, int padding){
		
		Node head = list;
		for(int i = 0; i < padding; i++){
			
			head = insertBefore(head , 0);
		}
		return head;
	}
	
	Node insertBefore(Node list, Object data){
		
		Node node = new Node(data);
		
		if(list != null)
		{
			node.setNext(list);
		}
		return node;
	}
	
	
	
	class Result{
		
		Node sum = null;
		int carry = 0;
		
		
	}
	
	
	static class mylist{
		Node head;
		
		
		public mylist()
		{
			
		}
		public void add(Object data){
			Node current;
			
			if(head == null){
				
				head = new Node(data);
			}
			
			Node temp = new Node(data);
			
			current  = head;
			
			while(current.getNext() != null){
				
				current = current.getNext();
				
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
