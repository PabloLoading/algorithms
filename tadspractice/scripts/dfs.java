package scripts;

import java.util.Scanner;

import tads.Graph.Edge;
import tads.Graph.Graph;
import tads.Graph.MatrixGraph;
import tads.Stack.Stack;
import tads.Stack.StackImp;

public class dfs {
 public static void main(String[] args) { 
  Scanner s = new Scanner(System.in);
  Graph g = loadData(s);
  boolean[] visited = initBool(g.size()+1, false);
  printDfs(1,visited,g);
 } 

 public static void printDfs(int origen,boolean[] visited,Graph g){
  visited[origen]=true;
  System.out.println(origen);
  for(Edge e : g.edges(origen)){
    int w = e.getDest();
    if(!visited[w]){
      printDfs(w, visited, g);
    }
  }
 }
 public static void printDfsMyStack(int origen,boolean[] visited,Graph g){
   Stack<Integer> s= new StackImp<Integer>();
   s.push(origen);
   while(!s.isEmpty()){
     s.pop();
     visited[origen]=true;
     System.out.println(origen);
    for(Edge e : g.edges(origen)){
      int w = e.getDest();
      if(!visited[w]) 
        s.push(w);
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
