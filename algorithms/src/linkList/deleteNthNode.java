package linkList;

public class deleteNthNode {

	public boolean deleteNode(Node list, int n) {

		int k = 1;
		Node current = list.getNext();
		while(k < n && current != null){
			k++;
			current = current.getNext();
		}
		if(current != null || current.next != null){
		Node next = current.next;
		current.data = next.data;
		current.next = next.next;
		return true;
		}
		return false;
		
	}
	
	public void show( Node head){
		Node current = head.getNext();
		while(current != null)
		{
		System.out.println(current.data);
		current = current.getNext();
		}
	}

	public static void main(String arg[]) {

		
		deleteNthNode dn = new deleteNthNode();
		myList ml = new myList();
		ml.add("1");
		ml.add("2");
		ml.add("3");
		ml.add("4");
		ml.add("5");
		ml.add("6");
		ml.add("7");
		
		dn.deleteNode(ml.head, 4);
		dn.show(ml.head);
		
	}

	static class myList {

		Node head;

		

		public void add(Object data) {

			if (head == null) {

				head = new Node(data);

			}
			Node temp = new Node(data);
			Node current = head;

			while (current.getNext() != null) {

				current = current.getNext();

			}
			current.setNext(temp);

		}
	}

	static class Node {
		Object data;
		Node next;

		public Node(Object data) {
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
