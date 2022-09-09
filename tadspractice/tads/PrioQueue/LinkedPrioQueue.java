package tads.PrioQueue;

import java.util.LinkedList;

public class LinkedPrioQueue implements PrioQueue {
    private LinkedList<Integer> list;

    public LinkedPrioQueue(){
        list=new LinkedList<>();
    }

    @Override
    public void push(int data) {
        list.add(data);
        
    }

    @Override
    public int pop() {
        if(list.isEmpty()){
            throw new RuntimeException("the priority queue is empty");
        }
        int min=list.get(0);
        for(int data : list){
            if(data<min){
                min=data;
            }
        }
        list.removeFirstOccurrence(min);
        return min;
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
    
}
