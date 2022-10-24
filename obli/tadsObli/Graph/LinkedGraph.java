package tadsObli.Graph;

import java.util.Iterator;
import tadsObli.List.*;

public class LinkedGraph implements Graph {

  private Object[] graph;
  private int edges;
  private boolean directed;

  private boolean posValid(int pos){
    return pos>0 && pos<graph.length;
  }
  @Override
  public int size() {
    return graph.length;
  }
  public LinkedGraph(int elems, boolean directed){
    this.graph = new Object[elems+1];
    for (int i=1; i<graph.length; i++){
      graph[i]= new LinkedList<Edge>();
    }
    this.directed = directed;
    this.edges = 0; 
  }

  @Override
  public void addEdge(int v, int w) {
    if (!posValid(v) || !posValid(w)) return;
    List<Edge> l = (List)graph[v];
    l.addFirst(new Edge(w,1));
    graph[v]=l;
    edges++;
    if(!directed){
      List<Edge> l1 = (List)graph[w];
      l1.addFirst(new Edge(v,1));
      edges++;
      graph[w]=l; 
    }

  }

  @Override
  public void addWeightedEdge(int v, int w, int weight) {
    if (!posValid(v) || !posValid(w)) return;
    List<Edge> l = (List)graph[v];
    l.addFirst(new Edge(w, weight));
    graph[v]=l;
    edges++;
    if(!directed){
      List<Edge> l1 = (List)graph[w];
      l1.addFirst(new Edge(v, weight));
      graph[w]=l1;
      edges++; 
    }
  }

  @Override
  public int edgeCount(int v) {
    if (!posValid(v)) return 0;
    List<Edge> l = (List)graph[v];
    return l.size();
  }

  @Override
  public int edgeCount() {
    return edges;
  }

  @Override
  public boolean hasEdge(int v, int w) {
    if(!posValid(v) || !posValid(w))return false;
    List<Edge> l = (List)graph[v];
    return l.contains(new  Edge(w, 1));
  }

  @Override
  public int getWeight(int v, int w) {
    if (!posValid(v) || posValid(w)) return 0;
    List<Edge> l = (List)graph[v];
    for(Edge e: l)
      if(e.vDest==w) return e.weight;
    return -1;
  }

  @Override
  public void removeEdge(int v, int w) {
    if (!posValid(v) || posValid(w)) return;
    List<Edge> l = (List)graph[v];
    if (this.hasEdge(v,w)) {
      l.remove(new Edge(w,1));
      edges--;
      if (!directed){
        removeEdge(w, v);
        edges--;
      } 
        
    }    
  }

  @Override
  public int[][] getAdyMatrix() {
    return null;
  }
  
  @Override
  public Iterable<Edge> edges(int v) {
    return new Iterable<Edge>() {
      public Iterator<Edge> iterator() {
        return ((List) graph[v]).iterator();
      }
    };
  }
}

