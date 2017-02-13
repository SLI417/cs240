
public interface ListInterface<T> {
	public boolean add(T newEntry);
	public void add(int index, T newEntry);
	public T remove(int index);
	public void clear();
	public void set(int index, T entry );
	public T get(int index);
	public T[] toArray();
	public boolean contains(T item);
	public int size();
	public boolean isEmpty();
}
