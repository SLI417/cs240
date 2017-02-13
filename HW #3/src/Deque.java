
public class Deque<T> implements DequeInterface<T> {

	private Node<T> front;
	private Node<T> back;
	private int size;
	
	public Deque(){
	}
	@Override
	public void addToFront(T newEntry) {
		Node<T> newNode = new Node<T>(newEntry);
		if(size == 0){
			back = newNode;
		} else {
			newNode.setNext(front);
			front.setPrev(newNode);
		}
		front = newNode;
		size++;
	}
	@Override
	public void addToBack(T newEntry) {
		Node<T> newNode = new Node<T>(newEntry);
		if(size == 0) {
			front = newNode;
		} else {
			back.setNext(newNode);
			newNode.setPrev(back);
		}
		back = newNode;
		size++;
	}
	@Override
	public T removeFront() {
		if (size > 0 ){
			T data = front.getData();
			front = front.getNext();
			front.setPrev(null);
			size--;
			return data;
		} else {
			throw new RuntimeException("Queue is empty.");		
		}
	}
	@Override
	public T removeBack() {
		if(size > 0){
			T data = back.getData();
			back = back.getPrev();
			back.setNext(null);
			size--;
			return data;
		} else {
			throw new RuntimeException("Queue is empty");
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
	public T getBack() {
		if (isEmpty()){
			throw new RuntimeException("Queue is empty.");
		} else {
			return back.getData();
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
