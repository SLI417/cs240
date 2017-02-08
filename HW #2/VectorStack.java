import java.util.Vector;
public class VectorStack<T> implements StackInterface<T>{
	
	private Vector<T> data;
	private int size;
	
	public VectorStack(){
		this.data = new Vector<T>();
		size = 0;
	}
	public VectorStack(int initSize){
		this.data = new Vector<T>(initSize);
		size = 0;
	}
	public void push(T newEntry){
		data.add(newEntry);
	}
	public T pop(){
		return data.remove(size-1);
	}
	public T peek(){
		return data.get(size-1);
	}
	public boolean isEmpty(){
		return data.isEmpty();
	}
	public void clear(){
		data.removeAllElements();
	}
}
