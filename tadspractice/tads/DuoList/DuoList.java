package tads.DuoList;

public interface DuoList<K,T>{
    public void addFirst(K key, T data);
    public void remove(K key);
    public int size();
    public boolean contains(K key);
    public T get(K key);
}