import tads.Graph.*;
import java.util.Scanner;
import tads.DuoPrioQueue.*;

public class Runner {
    public static void main(String[] args) {
        Graph g = loadData();
        int[] costs=dijsktra(g,10);
        showArr(costs);
    }
    
    public static int[] dijsktra(Graph g,int vertix){
        int vQuant=g.size();
        boolean[] visited= initBool(vQuant,false);
        int[] costs = initInt(vQuant, Integer.MAX_VALUE);
        int[] previous = initInt(vQuant, -1);
        DuoPrioQueue<Integer,Integer> q = new PairHeap<Integer,Integer>(vQuant);
        q.push(vertix,0);
        while(!q.isEmpty()){
            int vCost = q.maxPrio();
            int v = q.pop();
            visited[v]=true;
            for(Edge e : g.edges(v)){
                int w =e.getDest();
                int dist=e.getWeight();
                int wCost = vCost+dist;
                if(!visited[w] && wCost<costs[w]){
                    costs[w]=wCost;
                    previous[w]=v;
                    q.push(w,wCost);
                }     
            }
        }
        return costs;
    }
    public static Graph loadData(){
        Scanner s = new Scanner(System.in);
        int vQuant = s.nextInt();
        Graph g = new MatrixGraph(vQuant, true);
        int edges=s.nextInt();
        for (int i = 0; i < edges; i++) {
            int from=Integer.parseInt(s.next());
            int to=Integer.parseInt(s.next());
            g.addEdge(from, to);
        }
        s.close();
        return g;
    }
    public static void showArr(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]<10){
                System.out.println("Cost to "+(i+1)+" is "+arr[i]);
            }
            else System.out.println("Cost to "+(i+1)+" is UNREACHABLE");
        }
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
