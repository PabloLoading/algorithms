

import java.util.Scanner;

import tadsObli.ItemPrioQueue.*;
import tadsObli.DuoPrioQueue.*;
import tadsObli.Graph.*;

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Graph g = loadData(s);
        int[] vDelete = loadDelete(s);
        primWithPrinting(g, 1, vDelete);
    }

    
    public static void primWithPrinting(Graph g,int vertix,int[] vDelete){
        int vQuant=g.size();
        boolean[] visited= initBool(vQuant+1,false);
        int[] costs = initInt(vQuant+1, Integer.MAX_VALUE);
        int[] previous = initInt(vQuant+1, -1);
        DuoPrioQueue<Integer,Integer> q = new PairHeap<Integer,Integer>(vQuant,false);
        q.push(vertix,0);
        while(!q.isEmpty()){
            int v = q.pop();
            if(!visited[v] && !in(vDelete,v)){
                visited[v]=true;
                for(Edge e : g.edges(v)){
                    int w =e.getDest();
                    int wCost = e.getWeight();
                    if(!visited[w] && wCost<costs[w]){
                        costs[w]=wCost;
                        previous[w]=v;
                        q.push(w,wCost);
                    }     
                }
            }
        }
        printResults(previous,costs,vDelete);
    }

    public static void printResults(int[] previous,int[] costs,int[] vDelete){
        int len=costs.length;
        ItemPrioQueue<Edge> q = new ItemHeap(len,false);
        for (int i = 1; i < vDelete.length; i++) 
            previous[vDelete[i]]=-1;
        for (int i = 1; i < len; i++) {
            if(previous[i]==-1)continue;
            if(previous[i]<=i)q.push(new Edge(previous[i],costs[i],i));
            else q.push(new Edge(i,costs[i],previous[i]));
        }
        System.out.println(q.size());
        while(!q.isEmpty()){
            Edge e = q.pop();
            System.out.println(e.vIn+" "+e.vDest+" "+e.weight);
        }
    }

    public static boolean in(int[] arr, int e){
        for (int i = 0; i < arr.length; i++)
            if(arr[i]==e)return true;
        return false;
    }

    public static Graph loadData(Scanner s){
        int vQuant = s.nextInt();
        Graph g = new MatrixGraph(vQuant, false);
        int edges=s.nextInt();
        for (int i = 0; i < edges; i++) {
            int from=Integer.parseInt(s.next());
            int to=Integer.parseInt(s.next());
            int weight=Integer.parseInt(s.next());
            g.addWeightedEdge(from, to,weight);
        }
        return g;
    }
    public static int[] loadDelete(Scanner s){
        int len= Integer.parseInt(s.next());
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) 
            arr[i]=Integer.parseInt(s.next());
        return arr;
    }

    public static boolean[] initBool(int size,boolean value){
        boolean[] arr=new boolean[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=value;
        }
        return arr;
    }
    public static int[] initInt(int size,int value){
        int[] arr=new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=value;
        }
        return arr;
    }
}
