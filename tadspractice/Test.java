
import tads.BST.*;
import tads.DuoPrioQueue.*;
import tads.List.*;
import tads.PrioQueue.*;
import tads.Table.*;
import tads.Queue.*;
import hashFunctions.*;


public class Test {
    Object[] tests = new Object[50];
    int index = 0;
    //COLORS:
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";


    static class TestItem{
        String name;
        boolean ok;

        public TestItem(String name, boolean ok) {
            this.name = name;
            this.ok = ok;
        }

        @Override
        public String toString() {
            if (ok) return GREEN + name + " test passed" + RESET;
            else return RED + name + " test failed" + RESET;
        }
    }

    private void addTest(String name, boolean ok) {
        TestItem t = new TestItem(name, ok);
        tests[index] = t;
        index++;
    }

    private void showTests() {
        for (int i = 0; i < tests.length && tests[i] != null; i++) {
            System.out.println(tests[i]);
        }
    }

    // <-------- Created tests -------->

    /* 
    public static String LinkedMultiSetTest(){
    //MultiSet manual unit test
        MultiSet<Integer> m = new LinkedMultiSet<Integer>();
        m.insert(1, 1);
        m.insert(2, 9);
        m.insert(3, 5);
        m.delete(3);
        m.delete(3);
        
        boolean t1 = m.ocurrences(1) == 1;
        boolean t2 = m.ocurrences(2) == 9;
        boolean t3 = m.ocurrences(3) == 3;
        boolean t4 = m.isEmpty() == false;
        boolean t5 = m.size() == 3;
        
        return t1 && t2 && t3 && t4 && t5 ? GREEN + "LinkedMultiSet test passed" +
                RESET : RED + "LinkedMultiSet test failed" + RESET;
 
    }
    
    public static String LinkedMapTest(){
    //MultiSet manual unit test
        Map<Integer> m = new LinkedMap<Integer>();
        m.set(1, 1);
        m.set(2, 4);
        m.set(3, 9);
        m.set(2, 8);
        m.remove(3);
        
        boolean t1 = m.get(1) == 1;
        boolean t2 = m.get(2) == 8;
        boolean t3 = m.containsKey(3) == false;
        boolean t4 = m.isEmpty() == false;
        boolean t5 = m.size() == 2;
        
        return t1 && t2 && t3 && t4 && t5 ? GREEN + "LinkedMap test passed" +
                RESET : RED + "LinkedMap test failed" + RESET;
 
    }
        
    public static String LinkedStackTest(){
    //MultiSet manual unit test
        Stack<Integer> s = new LinkedStack<Integer>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.pop();
        
        boolean t1 = s.top() == 2;
        boolean t2 = s.isEmpty() == false;
        boolean t3 = s.size() == 2;
        s.pop();
        boolean t4 = s.top() == 1;
        s.pop();
        boolean t5 = s.isEmpty() == true;
        
        return t1 && t2 && t3 && t4 && t5 ? GREEN + "LinkedStack test passed" +
                RESET : RED + "LinkedStack test failed" + RESET;
 
    }

    public static String ListTest(){
        //MultiSet manual unit test
            List<Integer> l = new LinkedDoubleList<Integer>();
            l.insert(4, 7);
            l.insert(5, 5);
            l.insert(7, 4);
            l.delete(4);
            l.delete(7);
            
            boolean t1 = l.exists(5);
            boolean t2 = !l.exists(7);
            boolean t3 = l.size() == 1;
            boolean t4 = !l.isEmpty();
            l.delete(5);
            boolean t5 = l.isEmpty();

            return t1 && t2 && t3 && t4 && t5 ? GREEN + "List test passed" +
                    RESET : RED + "List test failed" + RESET;
     
        }
    */
    public static boolean HeapTest(){
        PrioQueue<Integer> pq = new HeapPrioQueue<Integer>(2,true);

        pq.push(2);
        pq.push(1);
        pq.push(2);
        pq.push(5);
        pq.push(8);
        pq.remove(5);

        boolean b1=(int)pq.top()==8;  

        pq.push(2);
        pq.push(3);
        pq.push(0);
        pq.push(12);

        boolean b2=(int)pq.top()==12;

        pq.changePrio(8, 59);
        pq.changePrio(2, 3);

        boolean b3=(int)pq.top()==59;
        pq.pop();
        boolean b4=(int)pq.top()==12;


        //TEST HEAPIFY
        PrioQueue<Integer> pq2 = new HeapPrioQueue<Integer>(2,true);
        Integer[] arrToHeap = {2,5,2,5,7,3,90,23,0,6,45};
        pq2.heapify(arrToHeap);
        
        int sizeH=pq2.size();
        int[] arrHeaped= new int[sizeH];
        int i =0;
        while(!pq2.isEmpty()){
            arrHeaped[i]=pq2.top();
            pq2.pop();
            i++;
        }
        boolean isHeap=true;
        for (int j = 0; j < arrHeaped.length && isHeap; j++) {
            int size=arrHeaped.length;
            if(j*2<size){
                if(arrHeaped[j]<arrHeaped[j*2]){
                    isHeap=false;
                }
            }
            if(j*2+1<size){
                if(arrHeaped[j]<arrHeaped[j*2+1]){
                    isHeap=false;
                }
            }
        }
        boolean b5=isHeap;
        boolean res = b1 && b2 && b3 && b4 && b5;
        return res;
    }

    public static boolean DuoHeapTest(){
        DuoPrioQueue<Integer,Integer> pq = new PairHeap<Integer,Integer>(2,true);

        pq.push(1, 2);
        pq.push(2, 1);
        pq.push(3, 2);
        pq.push(4, 5);
        pq.push(5, 8);
        pq.remove(5);

        boolean b1=(int)pq.top()==4;  

        pq.push(6, 2);
        pq.push(7, 3);
        pq.push(8, 0);
        pq.push(9, 12);

        boolean b2=(int)pq.top()==9;

        pq.changePrio(8, 59);
        pq.changePrio(2, 3);

        boolean b3=(int)pq.top()==8;

        return b1 && b2 && b3;
    }

    public static boolean OpenHashTest(){
            
            HashFun<Integer> h = new IntSquare();
            Table<Integer,Integer> m = new OpenHash<Integer,Integer>(4,h);
            m.insert(1, 1);

            m.insert(2, 4);
            m.insert(3, 9);
            m.insert(2, 8);
            m.remove(3);
            
            boolean t1 = m.get(1) == 1;
            boolean t2 = m.get(2) == 8;
            boolean t3 = m.exists(3) == false;
            boolean t4 = m.isEmpty() == false;
            boolean t5 = m.size() == 2;

            return t1 && t2 && t3 && t4 && t5 ;
     
    }

    public static boolean LinkedQueueTest(){
        Queue<Integer> q = new QueueImp<Integer>();
        q.push(1);
        q.push(2);
        q.push(3);
        q.pop();
        
        boolean t1 = q.top() == 2;
        boolean t2 = q.isEmpty() == false;
        q.pop();
        boolean t3 = q.top() == 3;
        q.pop();
        boolean t4 = q.isEmpty() == true;
        
        return t1 && t2 && t3 && t4 ;
 
    }
    
    public static boolean BSTTest(){

        BST<Integer> b = new AVL<Integer>();
        b.insert(2);
        b.insert(3);
        b.insert(4);
        b.remove(3);
        boolean t1=b.size()==2;
        boolean t2 = b.contains(2);
        boolean t3 = b.contains(3)==false;
        boolean t4 = b.isEmpty()==false;

        b.remove(2);
        b.remove(4);
        boolean t5=b.isEmpty()==true;

        return  t1 && t2 &&  t3 && t4 && t5;
    }
    
    public static boolean ClosedHashTest() {
        HashFun<Integer> h1 = new IntId();
        HashFun<Integer> h2 = new IntSquare();

        Table<Integer, Integer> m = new CloseHash<Integer, Integer>(4, h1, h2);
        m.insert(1, 1);
        m.insert(2, 4);
        m.insert(3, 9);
        m.insert(2, 8);
        m.remove(3);

        boolean t1 = m.get(1)==1;
        boolean t2 = m.get(2) == 8;
        boolean t3 = m.exists(3)==false;
        boolean t4 = m.isEmpty()==false;
        boolean t5 = m.size() == 2;

        return t1 && t2 && t3 && t4 && t5;
     
    }
    
    public static boolean LinkedListTest() {
        List<Integer> l = new LinkedList<Integer>();
        l.add(2);
        l.add(3);
        l.remove(4);

        boolean b1 = !l.isEmpty();
        boolean b2 = l.contains(2);
        l.remove(2);
        boolean b3 = !l.contains(2);


        return b1 && b2 && b3;
    }

    

    public void doTest(){
        addTest("LinkedQueue",LinkedQueueTest());
        addTest("BST", BSTTest());
        addTest("CloseHash", ClosedHashTest());
        addTest("OpenHash", OpenHashTest());
        addTest("DuoHeap", DuoHeapTest());
        addTest("Heap", HeapTest());
        addTest("LinkedList", LinkedListTest());
        showTests();
    }

}