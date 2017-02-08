
public class LinkedQueue<T> implements QueueInterface<T>{
	
	private Node<T> front;
	private Node<T> back;
	private int size;
	
	public LinkedQueue(){
	}
	@Override
	public void enqueue(T newEntry) {
		Node<T> newNode = new Node<T>(newEntry);
		if(size == 0) {
			front = newNode;
		} else {
			back.setNext(newNode);
		}
		back = newNode;
		size++;
	}
	@Override
	public T dequeue() {
		if (size > 0 ){
			T data = front.getData();
			front = front.getNext();
			size--;
			return data;
		} else {
			throw new RuntimeException("Queue is empty.");		
		}
	}
	@Override
	public T getFront() {
		if (isEmpty()){
			throw new RuntimeException("Queue is empty.");
		} else {
			return front.getData();
		}
	}
	@Override
	public boolean isEmpty() {
		return size == 0;
	}
	@Override
	public void clear() {
		front = null;
		back = null;
		size = 0;
	}

}
