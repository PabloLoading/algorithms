package tadsObli.Hash;

public interface Hash<K,T> {
    public T get(K key);
    public void remove(K key);
    public void insert(K key,T data);
    public boolean exists(K key);
    public int size();
    public boolean isEmpty();
}
