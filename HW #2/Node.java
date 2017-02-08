
public class Node<T> {
	
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
