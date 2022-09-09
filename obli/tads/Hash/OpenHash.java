package tads.Hash;

import hashFunctions.HashFun;

public class OpenHash<K,T> implements Hash<K,T> {
    HashFun<K> h;
    int elements=0;
    Object[] arr;

    public OpenHash(int expected,HashFun<K> h){
        arr=new Object[2*expected-1];
        this.h=h;
    }
    class Node{
        K key;
        T data;
        Node next;
        
        public Node(K key,T e){
            this.key=key;
            this.data=e;
            this.next=null;
        }
    }

    @Override
    public T get(K key) {
        int pos = h.hash(key)%arr.length;
        return getNode(key,arr[pos]);
    }

    @Override
    public void remove(K key) {
        int pos = h.hash(key)%arr.length;
        arr[pos]=removeNode(key,arr[pos]);
        
    }

    @Override
    public void insert(K key, T data) {
        int pos = h.hash(key)%arr.length;
        arr[pos]=insertNode(key,data,arr[pos]);
    }

    @Override
    public boolean exists(K key) {
        int pos = h.hash(key)%arr.length;
        return existsNode(key,arr[pos]);
    }

    @Override
    public int size() {
        return elements;
    }

    @Override
    public boolean isEmpty() {
        return elements==0;
    }

    // <-------- PRIVATE FUNCTIONS -------->

    private T getNode(K key,Object o){
        if(o==null)return null;
        Node n = (Node) o;
        while(n!=null){
            if(n.key==key)return n.data;
            n=n.next;
        }
        return null;
    }
    private Node removeNode(K key,Object o){
        if(o==null)return null;

        Node n =(Node) o;
        if(n.key==key){
            elements--;
            return null;
        }

        Node aux=n;
        while(aux.next!=null){
            if(aux.next.key==key){
                aux.next=aux.next.next;
                elements--;
                return n;
            }
        }
        return n;
    }
    private boolean existsNode(K key,Object o){
        if(o==null)return false;
        Node n=(Node)o;
        while(n!=null){
            if(n.key==key)return true;
            n=n.next;
        }
        return false;
    }
    private Node insertNode(K key,T e,Object o){
        if(o==null){
            elements++;
            return new Node(key,e);
        }
        
        Node n = (Node) o;
        if(n.key==key){
            n.data=e;
            return n;
        }

        Node aux = n;
        while(aux.next!=null){
            if(aux.key==key){
                aux.data=e;
                return n;
            }
            aux=aux.next;
        }
        aux.next=new Node(key,e);
        elements++;
        return n;
    }
}
