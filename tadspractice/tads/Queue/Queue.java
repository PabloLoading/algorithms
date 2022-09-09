package tads.Queue;

public interface Queue<T> extends Iterable<T> {
    
    public int size();
    public void push(T data);
    public T top();
    public void pop();
    public boolean isFull();
    public boolean isEmpty();

}
