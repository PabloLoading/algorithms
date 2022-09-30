package tads.Stack;

public interface Stack<T> {
    public T top(T key);
    public void push(T key);
    public void pop();
    public int size();
    public boolean isEmpty();
}
