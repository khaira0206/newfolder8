package linkList;

import linkList.partitionList.myList;

public class sumList {

	public static void main(String arg[]) {
		sumList sl = new sumList();

		myList ml1 = new myList();
		ml1.add("7");
		ml1.add("1");
		ml1.add("6");

		myList ml2 = new myList();

		ml2.add("5");
		ml2.add("9");
		ml2.add("2");
		sl.show(ml1.head);
		sl.show(ml2.head);
		
		sl.show(sl.addLists(ml1.head.next, ml2.head.next, 0));

	}

	Node addLists(Node list1, Node list2, int carry) {

		if (list1 == null && list2 == null && carry == 0) {
			return null;

		}
		Node result = new Node();

		int val = carry;

		if (list1 != null) {
			val += Integer.parseInt((String) list1.data);

		}

		if (list2 != null) {
			val += Integer.parseInt((String) list2.data);

		}

		result.data = val % 10;
		
		System.out.println(result.data);
		if (list1 != null || list2 != null) {

			Node more = addLists(list1 == null ? null : list1.getNext(), list2 == null ? null : list2.getNext(), val >= 10 ? 1 : 0);
			result.setNext(more);
		}

		return result;

	}

	public void show(Node list) {

		Node current = list;

		if (current != null) {

			while (current != null) {

				System.out.println("List after sum is :" + current.data);
				current = current.getNext();

			}
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
				while (current.getNext() != null) {

					current = current.getNext();

				}
				current.setNext(temp);
			}

		}

	}

	static class Node {

		Object data;
		Node next;

		public Node() {

		}

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
