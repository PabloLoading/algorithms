package scripts;
import java.util.Scanner;

import tads.Queue.Queue;
import tads.Queue.QueueImp;
import tadsObli.Graph.Edge;
import tadsObli.Graph.Graph;
import tadsObli.Graph.MatrixGraph;
import tadsObliObli.Graph.*;

public class bfs {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    Graph g = loadData(s);
    printBfs(1,g);
  }

  public static void printBfs(int origen,Graph g){
    boolean[] queued = initBool(g.size()+1, false);
    Queue<Integer> q = new QueueImp<Integer>();
    q.push(origen);
    queued[origen]=true;
    while(!q.isEmpty()){
      q.pop();
      int v= q.top();
      System.out.println(v);
      for(Edge e : g.edges(v)){
        int w = e.getDest();
        q.push(w);
        queued[w]=true;
      }
    }
  }
  public static boolean[] initBool(int size,boolean value){
    boolean[] arr=new boolean[size];
    for (int i = 0; i < arr.length; i++) {
        arr[i]=value;
    }
    return arr;
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
}
