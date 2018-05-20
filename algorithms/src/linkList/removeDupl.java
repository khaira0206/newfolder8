package linkList;

import java.util.HashSet;

public class removeDupl {

	HashSet<Object> set = new HashSet<Object>();
	Node head;

	public Node dupl(myLinkedList list) {

		Node pre = new Node();
		Node udList = pre;
		Node current = list.head;

		while (current != null) {

			if (set.contains(current.getData())) {
				pre.setNext(current.getNext());
			} else {
				set.add(current.getData());
				pre.setNext(current);
			}
			current = current.getNext();

		}
		return udList;
	}

	public String toString() {

		String output = "";

		Node current;
		if (head != null) {
			current = head.getNext();
			while (current != null) {

				output += "[" + current.getData().toString() + "]";
				current = current.getNext();

			}
		}
		return output;
	}

	public void show(Node list) {
		Node current = list;

		while (current != null) {

			System.out.println("" + current.data);
			current = current.next;
		}
	}

	public static void main(String args[]) {
		removeDupl rd = new removeDupl();
		myLinkedList ml = new myLinkedList();
		ml.add("1");
		ml.add("2");
		ml.add("3");
		ml.add("4");
		ml.add("4");
		ml.add("5");
		removeDupl rd1 = new removeDupl();
		rd1.show(rd.dupl(ml));
		System.out.println("My link list is: " + ml);

	}
}
