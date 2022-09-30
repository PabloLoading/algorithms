package tads.Graph;
import java.lang.Iterable;

public interface Graph{
  public int size();
  public void addEdge(int v, int w);
  public void addWeightedEdge(int v, int w, int weight);
  public int edgeCount(int v);
  public int edgeCount();
  public Iterable<Edge> edges(int v);
  public boolean hasEdge(int v, int w);
  public int getWeight(int v, int w);
  public void removeEdge(int v, int w);

  public int[][] getAdyMatrix();
}