package tads.List;

public interface List<T> extends Iterable {
    public int size();
    public boolean isEmpty();
    public void add(T data);
    public void remove(T data);
}
