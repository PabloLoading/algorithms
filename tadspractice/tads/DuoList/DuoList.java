package tads.DuoList;

public interface DuoList<K,T>{
    public void addFirst(K key, T data);
    public void remove(K key);
    public int size();
    public boolean contains();
    public T get(K key);
}