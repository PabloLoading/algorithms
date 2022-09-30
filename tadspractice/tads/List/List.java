package tads.List;

public interface List<T> extends Iterable<T> {
    public int size();
    public T first();
    public boolean isEmpty();
    public void add(T data);
    public void addFirst(T data);
    public void remove(T data);
    public boolean contains(T data);
}
