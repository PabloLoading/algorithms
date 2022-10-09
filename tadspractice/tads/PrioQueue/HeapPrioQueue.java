package tads.PrioQueue;


public class HeapPrioQueue<E extends Comparable<E>> implements PrioQueue<E> {
    private Object[] arr;
    private int elements;
    private boolean maxHeap;

    public HeapPrioQueue(int expectedSize,boolean maxHeap){
        arr=new Object[expectedSize+1];
        elements=0;
        this.maxHeap=maxHeap;

    }

    private void swap(int pos1, int pos2){
        Object aux=arr[pos1];
        arr[pos1]=arr[pos2];
        arr[pos2]=aux;
    }

    private void siftUp(int pos){
        if(pos==1)return;
        int parentPos=pos/2;
        E child=(E) arr[pos];
        E parent= (E) arr[parentPos];
        
        if(maxHeap && child.compareTo(parent)>0){
            swap(pos,parentPos);
            siftUp(parentPos);
        }
        else if(!maxHeap && child.compareTo(parent)<0){
            swap(pos,parentPos);
            siftUp(parentPos);
        }
    }
    
    @Override
    public String toString(){
        String str="";
        for (int i = 1; i <= elements; i++) {
            str+=arr[i]+" ";
        }
        return str;
    }
    
    private void sink(int pos){
        int priorerChildPos=pos*2;
        int rightPos=pos*2+1;
        if(priorerChildPos>elements)return;
        
        if(rightPos<=elements){
            E rChild=(E) arr[rightPos];
            E lChild=(E) arr[priorerChildPos];
            if(maxHeap&&lChild.compareTo(rChild)<0){
                priorerChildPos=rightPos;
            }
            else if(!maxHeap&&lChild.compareTo(rChild)>0){
                priorerChildPos=rightPos;
            }
        }
        E prioChild=(E) arr[priorerChildPos];
        E parent= (E) arr[pos];
        if(maxHeap&& parent.compareTo(prioChild)<0){
            swap(pos, priorerChildPos);
            sink(priorerChildPos);
        }
        else if(!maxHeap&& parent.compareTo(prioChild)>0){
            swap(pos, priorerChildPos);
            sink(priorerChildPos);
        }
    }
    
    private void reSize(){
        Object[] newArr = new Object[elements*2];
        for (int i = 1; i <= elements; i++) {
            newArr[i]=arr[i];
        }
        arr=newArr;
    }

    @Override
    public void push(E elem) {
        if(elements==arr.length-1){
            reSize();
        }
        elements++;
        arr[elements]=elem;
        siftUp(elements);
    }

    @Override
    public E pop() {
        if(isEmpty()){
            throw new RuntimeException("Error popping from empty queue");
        }
        E top=top();
        arr[1]=arr[elements];
        arr[elements]=null;
        elements--;
        sink(1);

        return top;
    }

    @Override
    public E top() {
        return (E) arr[1];
    }

    @Override
    public boolean isEmpty() {
        return elements==0;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public void remove(E elem) {
        for (int i = 1; i <= elements; i++) {
            E p =(E) arr[i];
            if(p.equals(elem)){
                arr[i]=arr[elements];
                arr[elements]=null;
                elements--;
                sink(i);
            }
        } 
        
    }

    @Override
    public void changePrio(E elem,E elemNew) {
        remove(elem);
        push(elemNew);
    }

    @Override
    public void heapify(E[] arrGiven) {
        elements=arrGiven.length;
        arr=new Object[arrGiven.length+1];
        for (int i = 0; i < arrGiven.length; i++) {
            arr[i+1]=arrGiven[i];
        }

        for (int i = arr.length/2; i >0; i--) {
            sink(i);
        } 
        
    }

    @Override
    public int size() {
        return elements;
    }

}
