package tads.ItemPrioQueue;

public interface ItemPrioQueue <E extends Comparable<E>> {
    public void push(E elem);
    public E pop();
    public E top();
    public boolean isEmpty();
    public boolean isFull();
    //Extended methods
    public void remove(E elem);
    public void changePrio(E elem,E elemNew);
    public void heapify(E[] arr);
    public int size();
    public String toString();
}
