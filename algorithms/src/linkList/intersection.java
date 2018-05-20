package linkList;

import linkList.palindrome1.myList;

public class intersection {

	public static void main(String arg[]) {
		myList ml = new myList();
		myList ml1 = new myList();
		ml.add("1");
		ml.add("2");
		ml.add("3");
		ml.add("4");
		ml.add("3");
		ml.add("2");
		ml.add("1");
		
		ml1.add("11");
		ml1.add("22");
		ml1.add("33");
		ml1.add("4");
		ml1.add("3");
		ml1.add("2");
		ml1.add("1");
		
		intersection inter = new intersection();
		inter.show(ml1.head.next);
		
		Node nd = inter.intersectingNode(ml.head.next, ml1.head.next);
	System.out.println("Intersecting node is : " +nd.data);
	}

	public Node intersectingNode(Node list1, Node list2) {

		if (list1 == null || list2 == null) {
			return null;
		}

		Result res1 = getTailSize(list1);
		Result res2 = getTailSize(list2);

		if (res1.tail != res2.tail) {
			return null;
		}
		Node longer = res1.size > res2.size ? list1 : list2;
		Node shorter = res1.size > res2.size ? list2 : list1;

		longer = getKthNode(longer, Math.abs(res1.size - res2.size));

		while (shorter != longer) {

			shorter = shorter.getNext();
			longer = longer.getNext();
		}
		return shorter;

	}

	Node getKthNode(Node head, int k) {
		Node current = head;
		while (k > 0 && current != null) {

			current = current.getNext();
			k--;
		}
		return current;

	}

	public void show(Node head) {
		Node current = head;

		while (current != null) {
			System.out.println(" Linked List is  :" + current.data);
			current = current.getNext();
		}

	}

	public Result getTailSize(Node head) {

		Node current = head;
		int size = 0;
		while (current != null) {
			current = current.getNext();
			size++;
		}
		return new Result(current, size);

	}

	class Result {
		Node tail;
		int size;

		public Result(Node tail, int size) {
			this.tail = tail;
			this.size = size;

		}

	}

	static class myList {
		Node head;

		public void add(Object data) {

			if (head == null) {
				head = new Node(data);
			}

			Node temp = new Node(data);
			Node current = head;

			if (current != null) {
				while (current.getNext()
						!= null) {
					current = current.getNext();

				}
				current.setNext(temp);
			}

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
