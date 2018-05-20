package linkList;
interface myInter<T>{
	
	void add(T a);
	myNode<T> kthToLast(T b, int c , index d);
}


class index {
	int val = 0 ;
	
}
class myNode<T> implements myInter<T>{
	T data;
	myNode next;
	
public myNode(T data){
	this.data = data;
	this.next = null;
}

public myNode getNext() {
	return next;
}

public void setNext(myNode next) {
	this.next = next;
}

@Override
public void add(T a) {
	// TODO Auto-generated method stub
	
}

@Override
public myNode<T> kthToLast(T b, int c, index d) {
	// TODO Auto-generated method stub
	return null;
}




}


public class kthElement<T> implements myInter<T>{
	
	public  myNode<T>  kthToLast(myNode<T> head, int k){
		
	index idx = new index();
	return kthToLast(head, k, idx);
		
	}
	
	public myNode<T> kthToLast(myNode<T> head, int k, index idx ){
		if(head == null){
			return null;
		}
		myNode<T> node = kthToLast(head.next, k, idx);
		idx.val = idx.val +1;
		
		if(idx.val == k){
			return head;
		}
		
		return node;
	}
	public void show( myNode<T> head){
		myNode<T> current = head.getNext();
		while(current != null)
		{
		System.out.println(current.data);
		current = current.getNext();
		}
	}
	
	public static void main(String arg[]){
		kthElement kt = new kthElement();
		myllist ml = new myllist();
		ml.add("1");
		ml.add("2");
		ml.add("5");
		ml.add("4");
		ml.add("6");
		kt.show(ml.head);
		myllist ml1 = new myllist();
		ml1.add("helo");
		ml1.add("world");
		
		myllist<Integer> ml3 = new myllist();
		ml3.add(1);
		kthElement<Integer> kt2 = new kthElement();
		//System.out.println(kt2.kthToLast(ml3.head,2).data + 34);
		
		System.out.println(kt.kthToLast(ml.head,2).data + "hdsj") ;
	System.out.println(kt.kthToLast(ml.head,2).data );
		
	}
	
	
	
 static class myllist<T> implements myInter<T>{
		
	 myNode head;
		
		public void add(T data){
			
			if(head == null){
				head = new myNode(data);
			}
			myNode<T> temp = new myNode<T>(data);
							
			myNode<T> current = head;
			if(current != null){
			while(current.getNext() != null){
				
				current = current.getNext();
			}
			current.setNext(temp);
			}
		}

		@Override
		public myNode<T> kthToLast(T b, int c, index d) {
			// TODO Auto-generated method stub
			return null;
		}

		
		
		
	}
 @Override
 public myNode<T> kthToLast(T b, int c, index d) {
 	// TODO Auto-generated method stub
 	return null;
 }

 @Override
 public void add(T a) {
 	// TODO Auto-generated method stub
 	
 }

}


