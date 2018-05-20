package linkList;

import linkList.kthElement.myllist;

public class partitionList {

	public Node partition(Node list, int k){
		
		Node head = list;
		Node tail = list;
		list  = list.next;
		while(list != null){
			
		Node next = list.next;
		
			if(	Integer.parseInt((String) list.data) < k){
				list.next = head;
				head = list;
			}
			else{
				tail.next = list;
				tail = list;
				
			}
			list = next;
			
		}
		tail.next = null;
		return head;
	}
	
	public void show(Node list){
		
		Node current = list.getNext();
		
		while(current != null){
			System.out.println(current.data);
			current = current.getNext();
		}
		
		
	} 
	
	
	public static void main(String ag[]){
		partitionList pl = new partitionList();
		myList ml = new myList();
		ml.add("1");
		ml.add("22");
		ml.add("5");
		ml.add("4");
		ml.add("11");
		ml.add("2");
	    //pl.show(ml.head);
		pl.show(pl.partition(ml.head, 5 ));
		
	}
	
	 static  class myList{
		
		Node head;
		
		public void add( Object data){
			
			if(head == null){
				head = new Node(data);
			}
			
			Node temp = new Node(data);
			Node current = head ;
			if(current != null){
			while(current.getNext() != null){
				
			current = current.getNext();
				
			}
			current.setNext(temp);
			}
			
			
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
