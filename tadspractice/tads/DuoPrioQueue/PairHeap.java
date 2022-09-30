package tads.DuoPrioQueue;

public class PairHeap<E,P extends Comparable<P>> implements DuoPrioQueue<E,P> {
    private Object[] arr;
    private int elements;

    

    public PairHeap(int expectedSize){
        arr=new Object[expectedSize+1];
        elements=0;
    }

    class Pair{
        E element;
        P prio;

        public Pair(E elem,P prio){
            element=elem;
            this.prio=prio;
        }
        @Override
        public String toString() {
            return element+":"+prio;
        }

    }
    private void swap(int pos1, int pos2){
        Object aux=arr[pos1];
        arr[pos1]=arr[pos2];
        arr[pos2]=aux;
    }
    @Override
    public String toString() {
        String str="";
        for (int i = 1; i <= elements; i++) {
            Pair p =(Pair) arr[i];
            str+="["+p.element+":"+p.prio+"] ";
        }
        return str;
    }
    
    private void siftUp(int pos){
        if(pos==1)return;
        int parentPos=pos/2;
        Pair child=(Pair) arr[pos];
        Pair parent= (Pair) arr[parentPos];
        if(child.prio.compareTo(parent.prio)>0){
            swap(pos,parentPos);
            siftUp(parentPos);
        }
    }
    private void sink(int pos){
        int priorerChildPos=pos*2;
        int rightPos=pos*2+1;
        if(priorerChildPos>elements)return;
        
        if(rightPos<=elements){
            Pair lChild=(Pair) arr[priorerChildPos];
            Pair rChild=(Pair) arr[rightPos];
            if(lChild.prio.compareTo(rChild.prio)<0){
                priorerChildPos=rightPos;
            }
        }
        Pair prioChild=(Pair) arr[priorerChildPos];
        Pair parent= (Pair) arr[pos];
        if(parent.prio.compareTo(prioChild.prio)<0){
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
    public void push(E elem, P prio) {
        Pair newPair=new Pair(elem,prio);        
        if(elements==arr.length-1){
            reSize();
        }
        elements++;
        arr[elements]=newPair;
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
        return (E) ((Pair) arr[1]).element;
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
            Pair p =(Pair) arr[i];
            if(p.element.equals(elem)){
                arr[i]=arr[elements];
                arr[elements]=null;
                elements--;
                sink(i);
            }
        }        
    }

    @Override
    public void changePrio(E elem, P prio) {
        remove(elem);
        push(elem, prio);        
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
    public P maxPrio() {
        return (P) ((Pair) arr[1]).prio;
    }
    
}
