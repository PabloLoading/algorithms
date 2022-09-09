package tads.Table;
import hashFunctions.HashFun;

public class CloseHash<K,T> implements Table<K,T> {

    private Object[] table;
    private int elements=0;
    private HashFun<K> h;
    private HashFun<K> h2;

    public CloseHash(int expected,HashFun<K> hash1,HashFun<K> hash2){
        this.table= new Object[2*expected-1];
        h=hash1;
        h2=hash2;
    }

    class Pair{
        K key;
        T value;
        boolean isDeleted=false;
        Pair(K key,T value){
            this.key=key;
            this.value=value;
        }
        Pair(K key){
            this.key=key;
        }
        @Override
        public boolean equals(Object obj){
            K otherKey=((Pair) obj).key;
            boolean otherIsDeleted=((Pair) obj).isDeleted;
            return  this.key.equals(otherKey) && !(otherIsDeleted|| this.isDeleted);
        }
    }

    @Override
    public T get(K key) {
        Pair p = new Pair(key);
        int i =0;
        while(true){
            int pos=(h.hash(key)+i+h2.hash(key))%table.length;
            i++;

            if(table[pos]==null){
                return null;
            }
            Pair arrPair = (Pair) table[pos];
            if(arrPair!=null && p.equals(arrPair)){
                return arrPair.value;
            }
            //cycle complete
            if(pos== h.hash(key)% table.length){
                return null;
            }
        }
    }

    @Override
    public void remove(K key) {
        Pair p = new Pair(key);
        int i =0;
        while(true){
            int pos=(h.hash(key)+i+h2.hash(key))%table.length;
            i++;

            if(table[pos]==null){
                return;
            }
            Pair arrPair = (Pair) table[pos];
            if(arrPair!=null && p.equals(arrPair)){
                arrPair.isDeleted = true;
                elements--;

            }
            //cycle complete
            if(pos== h.hash(key)% table.length){
                return;
            }
        }
    }

    @Override
    public void insert(K key, T data) {
        if(exists(key)){
            Pair p = new Pair(key);
            int i =0;
            while(true){
                int pos=(h.hash(key)+i+h2.hash(key))%table.length;
                i++;
                if(table[pos]!=null){
                    Pair arrPair = (Pair) table[pos];
                    if(p.equals(arrPair)){
                        arrPair.value=data;
                        return;
                    }
                }
            }
        }
        else{
            Pair p = new Pair(key,data);
            int i =0;
            while(true){
                int pos=(h.hash(key)+i+h2.hash(key))%table.length;
                i++;

                if(table[pos]==null){
                    table[pos]=p;
                    elements++;
                    return;
                }
                //cycle complete
                if(pos== h.hash(key)% table.length){
                    return;
                }
            }
        }
        
    }


    @Override
    public boolean exists(K key) {
        Pair p = new Pair(key);
        int i =0;
        while(true){
            int pos=(h.hash(key)+i+h2.hash(key))%table.length;
            i++;

            if(table[pos]==null){
                return false;
            }
            Pair arrPair = (Pair) table[pos];
            if(p.equals(arrPair)){
                return true;
            }
            //cycle complete
            if(pos== h.hash(key)% table.length){
                return false;
            }
        }
    }
    @Override
    public int size(){
        return elements;
    }
    @Override
    public boolean isEmpty(){
        return elements==0;
    }
}
