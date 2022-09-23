package tads.Graph;
import tads.DuoList.*;

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
      graph[i]= new DuoListImp<Integer,Integer>();
    }
    this.directed = directed;
    this.edges = 0; 
  }

  @Override
  public void addEdge(int v, int w) {
    if (!posValid(v) || !posValid(w)) return;
    DuoList<Integer,Integer> l = (DuoList)graph[v];
    l.addFirst(w, 1);
    edges++;
    if(!directed){
      DuoList<Integer,Integer> l1 = (DuoList)graph[w];
      l.addFirst(v, 1);
      edges++; 
    }

  }

  @Override
  public void addWeightedEdge(int v, int w, int weight) {
    if (!posValid(v) || !posValid(w)) return;
    DuoList<Integer,Integer> l = (DuoList)graph[v];
    l.addFirst(w, weight);
    edges++;
    if(!directed){
      DuoList<Integer,Integer> l1 = (DuoList)graph[w];
      l.addFirst(v, weight);
      edges++; 
    }
  }

  @Override
  public int edgeCount(int v) {
    if (!posValid(v)) return 0;
    DuoList<Integer,Integer> l = (DuoList)graph[v];
    return l.size();
  }

  @Override
  public int edgeCount() {
    return edges;
  }

  @Override
  public Iterable<Edge> edges(int v) {
    return null;
  }

  @Override
  public boolean hasEdge(int v, int w) {
    DuoList<Integer,Integer> l = (DuoList)graph[v];
    return posValid(v) && posValid(w) && l.size()>0;
  }

  @Override
  public int getWeight(int v, int w) {
    if (!posValid(v) || posValid(w)) return 0;
    DuoList<Integer,Integer> l = (DuoList)graph[v];
    return l.get(w);
  }

  @Override
  public void removeEdge(int v, int w) {
    if (!posValid(v) || posValid(w)) return;
    DuoList<Integer,Integer> l = (DuoList)graph[v];
    if (l.contains(w)) {
      l.remove(w);
      edges--;
      if (!directed) removeEdge(w, v);
    }    
  }

  @Override
  public int[][] getAdyMatrix() {
    int[][] mat = new int[graph.length+1][graph.length+1];


    return null;
  }
  
}
