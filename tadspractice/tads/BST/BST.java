package tads.BST;

public interface BST<T extends Comparable<T>> extends Iterable<T> {
    public boolean contains(T data);
    public boolean isEmpty();
    public void insert(T data);
    public void remove(T data);
    public int height();
    public int size();
}
