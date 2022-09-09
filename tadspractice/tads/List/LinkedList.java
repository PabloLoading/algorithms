package tads.List;

import java.util.Iterator;

public class LinkedList<T> implements List<T> {
    class Node{
        T data;
        Node next;
        
        public Node(T e){
            this.data=e;
            this.next=null;
        }
    }

    Node head;
    Node tail;
    int elements;


    public LinkedList(){
        this.tail=null;
        this.head=null;
        this.elements=0;
    }

    @Override
    public int size() {
        return elements;
    }

    @Override
    public boolean isEmpty() {
        return elements==0;
    }

    

    @Override
    public void add(T data) {
        Node newNode= new Node(data);
        if(head==null){
            head=newNode;
            tail=newNode;
        }
        else{
            tail.next=newNode;
            tail=tail.next;
        }
        elements++;
    }

    @Override
    public void remove(T data) {
        if(head!=null){
            if(head.data==data && head.data==tail.data){
                head=null;
                tail=null;
                elements--;
            }
            else if(true){
                this.head=remove(head,data);
                tail=head;
                while(tail.next!=null){
                    tail=tail.next;
                }
                elements--;
            }
        }
    }

    /*
     * PRIVATE FUNCTIONS:
     */
    private Node remove(Node root,T data){
        if(root==null) return null;

        if(root.data==data){
            return root.next;
        }
        else{
            root.next=remove(root.next,data);
            return root;
        }
    }

    @Override
    public Iterator iterator() {
        return new LinkedListIterator(head);
    }
    class LinkedListIterator implements Iterator<T>{
        Node curr;

        public LinkedListIterator(Node start){
            curr=start;
        }

        @Override
        public boolean hasNext() {
            return curr!=null;
        }

        @Override
        public T next() {
            T data = curr.data;
            curr=curr.next;
            return data;
        }
    }

}