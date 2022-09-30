package tads.Graph;
import java.lang.Iterable;
import java.util.Iterator;

public class MatrixGraph implements Graph{
  int edges;
  int[][] mat;
  boolean directed;

  private boolean posValid(int pos1){
    return pos1>0 && pos1<mat.length;
  }

  public MatrixGraph(int elems,boolean dir){
    mat=new int[elems+1][elems+1];
    directed=dir;
    edges=0;
  }

  @Override
  public int size() {
    return mat.length;
  }

  @Override
  public void addEdge(int v, int w) {
    if(!posValid(v) || !posValid(w)) return;
    mat[v][w]=1;
    edges++;
    if(!directed){
      mat[w][v]=1;
      edges++;
    }
  }

  @Override
  public void addWeightedEdge(int v, int w, int weight) {
    if(!posValid(v) || !posValid(w)) return;
    mat[v][w]=weight;
    edges++;   
    if(!directed){
      mat[w][v]=weight;
      edges++; 
    }
  }

  @Override
  public int edgeCount(int v) {
    if(!posValid(v)) return 0;
    int vEdges =0;
    for(int i =0;i<mat.length;i++) 
      if(mat[v][i]>0)vEdges++;
    return vEdges;
  }

  @Override
  public int edgeCount() {
    return edges;
  }

  @Override
  public boolean hasEdge(int v, int w) {
    return posValid(v) && posValid(w) && mat[v][w]>0;
  }

  @Override
  public int getWeight(int v, int w) {
    if(!posValid(v) || !posValid(w)) return 0;
    return mat[v][w];
  }

  @Override
  public void removeEdge(int v, int w) {
    if(!posValid(v) || !posValid(w)) return;
    mat[v][w]=0;
    edges--;   
    if(!directed) removeEdge(w, v);
  }

  @Override
  public Iterable<Edge> edges(int v) {
    if(!posValid(v)) throw new RuntimeException("Cannot iterate in invalid position");
    return new Iterable<Edge>() {
      public Iterator<Edge> iterator() {
        return new MatrixGraphIterator(mat[v], edgeCount(v));
      }
    };
  }

  @Override
  public int[][] getAdyMatrix() {
    int[][] adyMat = new int[mat.length][mat.length];
    for (int i = 0; i < adyMat.length; i++) {
      for (int j = 0; j < adyMat.length; j++) {
        adyMat[i][j]=mat[i][j];
      }
    }
    return adyMat;
  }
}
  

  class MatrixGraphIterator implements Iterator<Edge> {
    int edgesLeft;
    int pos;
    int[] arr;
    
    public MatrixGraphIterator(int[] arr,int edges){
      pos=1;
      edgesLeft=edges;
      this.arr=arr;
    }

    @Override
    public boolean hasNext() {
      return edgesLeft>0;
    }

    @Override
    public Edge next() {
      for(int i=pos;i<arr.length;i++)
        if(arr[i]>0){
          edgesLeft--;
          pos=i+1;
          return new Edge(i, arr[i]);
        }
      return null;
    }
  } 

