public class LinkedList<T> implements ListInterface<T> {
	public class Node<T>{
		private T data;
		private Node<T> nextNode;

		public Node(){
		}
		public Node(T value){
			this.setData(data);
		}
		public Node(T data, Node<T> nextNode){
			this.data = data;
			this.nextNode = nextNode;
		}
		public T getData(){
			return data;
		}
		public void setData(T data){
			this.data = data;
		}
		public Node<T> getNext(){
			return nextNode;
		}
		public void setNext(Node<T> nextNode){
			this.nextNode = nextNode;
		}
	}

	private Node<T> front;
	private Node<T> back;
	private int size;

	@Override
	public boolean add(T newEntry) {
		Node<T> newNode = new Node<T>(newEntry);
		if(size == 0) {
			front = newNode;
		} else {
			back.setNext(newNode);
		}
		back = newNode;
		size++;
		return true;
	}

	@Override
	public void add(int index, T newEntry) {
		if(size <= index){
			Node<T> newNode = new Node<T>(newEntry);
			if(size == 0) {
				front = newNode;
			} else {
				Node<T> counter = front;
				for (int i=1; i<index; i++){
					counter = counter.getNext();
				}
				newNode.setNext(counter.getNext());
				counter.setNext(newNode);
			}
			size++;
		}
	}
	@Override
	public T remove(int index) {
		if (index < size()) {
			// check if it is the first element to remove
			T result;
			if (index == 0) {
				result = front.getData();
				front = front.getNext();
				if (front == null) {
					back = null;
				}
			} else {
				Node<T> prev = front;
				for(int i = 1; i < index; i++) {
					prev = prev.getNext();
				}
				result = prev.getNext().getData();
				prev.setNext(prev.getNext().getNext());

				if (index == size() - 1) {
					back = prev;
				}
			}
			size--;
			return result;
		} else {
			throw new RuntimeException("Index out of bound.");
		}
	}

	@Override
	public void clear() {
		front = null;
		back = null;
		size = 0;
	}

	@Override
	public void set(int index, T entry) {
		if (index < size()) {
			Node<T> cursor = front;
			for(int i = 0 ; i < index; i++) {
				cursor = cursor.getNext();
			}
			cursor.setData(entry);
		} else {
			throw new RuntimeException("Index out of bound.");
		}
	}

	@Override
	public T get(int index) {
		if (index < size()) {
			Node<T> cursor = front;
			for(int i = 0 ; i < index; i++) {
				cursor = cursor.getNext();
			}
			return cursor.getData();
		} else {
			throw new RuntimeException("Index out of bound.");
		}
	}

	@Override
	public T[] toArray() {
		T[] array = (T[]) new Object[size];
		Node<T> cursor = front;
		for ( int i = 0; cursor != null; i++){
			array[i] = cursor.getData();
			cursor = cursor.getNext();
		}
		return array;
	}

	@Override
	public boolean contains(T item) {
		boolean result = false;
		Node<T> cursor = front;
		while ( cursor != null){
			cursor = cursor.getNext();
			if ( cursor.getData().equals(item)){
				result = true;
			}
		}
		return result;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size==0;
	}

}