package tads.DuoPrioQueue;

public interface DuoPrioQueue<E,P extends Comparable<P>> {
    public void push(E elem,P prio);
    public E pop();
    public E top();
    public P maxPrio();
    public boolean isEmpty();
    public boolean isFull();
    //Extended methods
    public void remove(E elem);
    public void changePrio(E elem,P prio);
    public void heapify(E[] arr);
    public String toString();
}
