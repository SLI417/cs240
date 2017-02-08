
public class LinkedStack<T> implements StackInterface<T>{
	
	private Node<T> front;
	private int size;
	
	public LinkedStack(){
	}
	@Override
	public void push(T newEntry) {
		Node<T> newNode = new Node<T>(newEntry);
		newNode.setNext(front);
		size++;
		front = newNode;
	}

	@Override
	public T pop() {
		if(size > 0){
			T tempData = front.getData();
			front = front.getNext();
			size--;
			return tempData;
		}
		return null;
	}

	@Override
	public T peek() {
		return front.getData();
	}

	@Override
	public boolean isEmpty() {
		return (size == 0); // or return front == null;
	}

	@Override
	public void clear() {
		size = 0;
		front = null;
	}

}
