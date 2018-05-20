package stack_queue;

interface Stack<K> {
	Stack<K> push(K ele);

	K pop();
}

public class StackArray<K> implements Stack<K> {

	public static void main(String args[]) {

		Stack<String> greeting = new StackArray<>();
		Stack<Integer> greeting1 = new StackArray<>();

		greeting.push("!").push("World").push("Hello, ");
		greeting1.push(1);

		System.out.println(greeting1.pop() +1);
		System.out.println(greeting.pop() + greeting.pop() + greeting.pop() ); // Hello,
																				// World!
	}

	private K[] arr;

	private int total;

	public StackArray() {
		arr = (K[]) new Object[2];
	}

	private void resize(int capacity) {
		K[] tmp = (K[]) new Object[capacity];
		System.arraycopy(arr, 0, tmp, 0, total);
		arr = tmp;
	}

	public StackArray<K> push(K ele) {
		if (arr.length == total)
			resize(arr.length * 2);
		arr[total++] = ele;
		return this;
	}

	public K pop() {
		if (total == 0)
			throw new java.util.NoSuchElementException();
		K ele = arr[--total];
		arr[total] = null;
		if (total > 0 && total == arr.length / 4)
			resize(arr.length / 2);
		return ele;
	}

	@Override
	public String toString() {
		return java.util.Arrays.toString(arr);
	}

}