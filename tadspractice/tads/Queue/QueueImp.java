

package tads.Queue;

import java.util.Iterator;

public class QueueImp<T> implements Queue<T> {

    class Node{
        T data;
        Node next;
        
        public Node(T e){
            this.data=e;
            this.next=null;
        }
    }
    int elements;
    Node front;
    Node back; 
    
    public QueueImp(){
        this.elements=0;
        this.front=null;
        this.back=null;
    }
    
    @Override
    public boolean isEmpty(){
        return elements==0;
    }
    @Override
    public boolean isFull(){
        return false;
    }
    @Override
    public int size(){
        return this.elements;
    }
    @Override
    public T top(){
        return this.front.data;
    }
    @Override
    public void push(T e){
        Node newNode= new Node(e);
        if(this.isEmpty()){
            this.front=newNode;
            this.back=newNode;
        }
        else{
            this.back.next=newNode;
            this.back=this.back.next;
        }
        this.elements++;
    }
    @Override
    public void pop(){
        if(!isEmpty()){
            if(this.elements==1){
                this.front=null;
                this.back=null;
            }
            else{
                this.front=this.front.next;
            }
            elements--;
        }
    }

    @Override
    public Iterator<T> iterator() {
        // TODO Auto-generated method stub
        return null;
    }
    
    
}
