package tads.Stack;
import java.util.Iterator;

import tads.List.List;
public class StackImp<T> implements Stack<T> {

    private int elements;
    private List<T> head;


    @Override
    public T top(T key) {
        return (T)head.first();
    }

    @Override
    public void push(T key) {
        head.add(key);
        elements++;
    }
    @Override
    public int size() {
        return elements;
    }
    @Override
    public void pop() {
        head.remove(head.first());
        elements--;
    }
    @Override
    public boolean isEmpty() {
        return elements==0;
    }

    public class StackIterator implements Iterator<T>{
        @Override
        public boolean hasNext() {
            return head!=null;
        }

        @Override
        public T next() {
            
            return null;
        }

    }
}
