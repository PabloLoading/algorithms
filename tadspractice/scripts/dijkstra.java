package scripts;

import tads.DuoPrioQueue.*;
import tads.Graph.*;
import java.util.Scanner;


public class dijkstra {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Graph g = loadData(s);
        int reqs= Integer.parseInt(s.next());
        for (int i = 0; i < reqs; i++) {
            int from = Integer.parseInt(s.next());
            int to = Integer.parseInt(s.next());
            int cost = dijsktra(g, from, to);
            if(cost > 214748364) System.out.println(-1);
            else System.out.println(cost);
                     
        }
        s.close();
    }

    public static int dijsktra(Graph g,int vertix,int to){
        int vQuant=g.size();
        boolean[] visited= initBool(vQuant+1,false);
        int[] costs = initInt(vQuant+1, Integer.MAX_VALUE);
        int[] previous = initInt(vQuant+1, -1);
        DuoPrioQueue<Integer,Integer> q = new PairHeap<Integer,Integer>(vQuant,false);
        q.push(vertix,0);
        while(!q.isEmpty()){
            int vCost = q.maxPrio();
            int v = q.pop();
            if(!visited[v]){
                visited[v]=true;
                for(Edge e : g.edges(v)){
                    int w =e.getDest();
                    int wCost = vCost+e.getWeight();
                    if(!visited[w] && wCost<costs[w]){
                        costs[w]=wCost;
                        previous[w]=v;
                        q.push(w,wCost);
                    }     
                }
            }
            
        }
        return costs[to];
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
