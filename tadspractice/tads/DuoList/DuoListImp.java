package tads.DuoList;

public class DuoListImp<K,T> implements DuoList<K,T>{
    class Node {
        K key;
        T data;
        Node next;
    }
    private int elements;
    private Node head;
    
    @Override
    public void addFirst(K key, T data) {
        Node n = new Node();
        n.data = data;
        n.key = key;
        n.next = this.head;
        elements++;
    }

    @Override
    public void remove(K key) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public int size() {
        return elements;
    }

    @Override
    public boolean contains(K key){
        return false;
    }

    public DuoListImp(){
        Node head = null;
        int elements= 0;
    }

    @Override
    public T get(K key) {
        // TODO Auto-generated method stub
        return null;
    }
}