package edu.cpp.cs240.lab3;
public class ArrayStack<T> implements StackInterface<T>{
	
	private T[] data;
	private int size;
	
	public ArrayStack(){
		this.data = (T[]) new Object[10];
		size = 0;
	}
	public ArrayStack(int initSize){
		this.data = (T[]) new Object[initSize];
		size = 0;
	}
	public void push(T newEntry){
		ensureCapacity();
		data[size] = newEntry;
		size++;
	}
	
	public void ensureCapacity(){
		if ( size == data.length ){
			T[] tempBag = (T[])new Object[size*2];
			for( int i = 0; i < size; i++){
				tempBag[i] = data[i];
			}
			data = tempBag;
		}
	}
	
	public boolean isArrayFull(){
		return size >= data.length;
   }
	public T pop(){
		if(size != 0){
			size--;
			return data[size];
		} else{
			return null;
		}
	}
	public T peek(){
		return data[size-1];
	}	
	public boolean isEmpty(){
		return (size == 0);
	}
	public int size(){
		return size;
	}
	public void clear(){
		data = (T[]) new Object[10]; // to avoid
		size = 0;						  // null pointer exception
	}
}
