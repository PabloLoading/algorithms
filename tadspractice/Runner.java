import java.util.Scanner;

import tads.BST.*;
import tads.Graph.*;

public class Runner {
    public static void main(String[] args) {
        //runEj1();
        System.out.println("Compiled!!");
        Test t = new Test();
        t.doTest();
    }


    public static void runEj1(){
        Scanner s = new Scanner(System.in);
        int vQuant= s.nextInt();
        int edges= s.nextInt();
        Graph g = new MatrixGraph(vQuant, true);
        for(int i =0;i<edges;i++){
            int  v= Integer.parseInt(s.next());
            int  w= Integer.parseInt(s.next());
            g.addEdge(v, w);
        }
        for(int v= 1;v<=vQuant;v++){
            for(Edge e : g.edges(v)){
                System.out.println("From: "+v+" to "+e.vDest);
            }
        }
        
            /* 
        int reqs= s.nextInt();
        for (int i = 0; i < reqs; i++) {
            int  v= Integer.parseInt(s.next());
            int  w= Integer.parseInt(s.next());

            if(g.hasEdge(v, w)) System.out.println(1);
            else System.out.println(0);
        }
        */
    }

}
