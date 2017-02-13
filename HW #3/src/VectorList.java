import java.util.Vector;

public class VectorList<T> implements ListInterface<T>{

	private Vector<T> data;
	@Override
	public boolean add(T newEntry) {
		return data.add(newEntry);
	}

	@Override
	public void add(int index, T newEntry) {
		data.add(index, newEntry);
	}

	@Override
	public T remove(int index) {
		return data.remove(data.size()-1);
	}

	@Override
	public void clear() {
		data.removeAllElements();
	}

	@Override
	public void set(int index, T entry) {
		data.set(index, entry);
	}

	@Override
	public T get(int index) {
		return data.get(index);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] toArray() {
		return (T[]) data.toArray();
	}

	@Override
	public boolean contains(T item) {
		return data.contains(item);
	}

	@Override
	public int size() {
		return data.size();
	}

	@Override
	public boolean isEmpty() {

		return data.size() == 0;
	}

}
