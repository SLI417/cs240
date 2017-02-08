
public class CircularLinkedQueue<T> implements QueueInterface<T> {

	private Node<T> freeNode;
	private Node<T> queueNode;
	private int size;
	
	public CircularLinkedQueue(){
		freeNode = new Node<T>(null, null);
		freeNode.setNext(freeNode);
		queueNode = freeNode;
		size = 0;
	}
	@Override
	public void enqueue(T newEntry) {
		if(size < 10){
			freeNode.setData(newEntry);
			if(isChainFull()){
				Node<T> newNode = new Node<T>(null, freeNode.getNext());
				freeNode.setNext(newNode);
			}
			freeNode = freeNode.getNext();
			size++;
		} else{
			throw new RuntimeException("Queue is full.");
		}
	}
	private boolean isChainFull() {
		return queueNode == freeNode.getNext();
	}
	@Override
	public T dequeue() {
		if(isEmpty()){
			throw new RuntimeException("Queue is empty.");
		}
		T front = getFront();
		queueNode.setData(null);
		queueNode = queueNode.getNext();
		size--;
		return front;
	}
	@Override
	public T getFront() {
		if(isEmpty()){
			throw new RuntimeException("Queue is empty.");
		}
		return queueNode.getData();
	}
	@Override
	public boolean isEmpty() {
		return queueNode == freeNode;
	}
	@Override
	public void clear() {
		while(!isEmpty()){
			dequeue();
		}	
	}

}
