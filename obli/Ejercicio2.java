import java.util.Scanner;

import tadsObli.ItemPrioQueue.*;

public class Ejercicio2 {
    public static void main(String[] args) {
        
        //GET input
        Scanner s= new Scanner(System.in);
        int lines=s.nextInt();
        Integer[] arr = new Integer[lines];
        for(int i =0;i<lines;i++){
            arr[i]=s.nextInt();
        }
        //SEND output
        ItemPrioQueue<Integer> minPq = new ItemHeap<Integer>(lines,true);
        minPq.heapify(arr);
        while(!minPq.isEmpty()){
            System.out.println(minPq.top());
            minPq.pop();
        }
    }

}
