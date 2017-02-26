package edu.cpp.cs240.lab3;

public class ArrayQueue<T> implements QueueInterface<T>{
	
	private T[] data;
	private int front;
	private int back;
	
	private static final int DEFAULT_CAPACITY = 10;
	
	public ArrayQueue(){
		this(DEFAULT_CAPACITY);
	}
	public ArrayQueue(int initSize){
		this.data = (T[]) new Object[initSize + 1];
		front = 0;
		back = initSize;
	}
	@Override
	public void enqueue(T newEntry) {
		if (front == ((back + 2) % data.length)){
			throw new RuntimeException("Queue is full.");
		}
		back = (back + 1) % data.length;
		data[back] = newEntry;
	}

	@Override
	public T dequeue() {
		if(isEmpty()){
			throw new RuntimeException("Queue is empty.");
		}
		T temp = data[front];
		data[front] = null;
		front = (front + 1) % data.length;
		return temp;
	}

	@Override
	public T getFront() {
		if(isEmpty()){
			throw new RuntimeException("Queue is empty.");
		}
		return data[front];
	}
	@Override
	public boolean isEmpty() {
		return front == (back + 1) % data.length;
	}

	@Override
	public void clear() {
		this.data = (T[]) new Object[data.length];
		front = 0;
		back = data.length - 1;
		
	}

}
