
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
		if(isArrayFull()){
			throw new RuntimeException("Stack is full");
		} else{
			data[size] = newEntry;
			size++;
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
	public void clear(){
		data = (T[]) new Object[10]; // to avoid
		size = 0;						  // null pointer exception
	}
}
