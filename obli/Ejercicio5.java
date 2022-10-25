import java.util.Scanner;

public class Ejercicio5 {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    Object[] nodes= loadData(s);
    mergeSort(nodes, 1, nodes.length-1);
    for (int i = 1; i < nodes.length; i++) {
      Node n = (Node) nodes[i];
      System.out.println(n.v+" "+n.edges);
    }
    

  }

  public static Object[] loadData(Scanner s){
    int V = Integer.parseInt(s.next());
    Object[] nodes = new Object[V+1];
    for (int i = 1; i <= V; i++)
      nodes[i]=new Node(i);
    int A = Integer.parseInt(s.next());
    for (int i = 0; i < A; i++) {
      int v = Integer.parseInt(s.next());
      int w = Integer.parseInt(s.next());
      ((Node) nodes[w]).sumEdge();
    }
    return nodes;
  }

  public static Object[] merge(Object[] arr, int start, int mid, int end){
    Object[] arrNew = new Object[end-start+1];
    int i=start;
    int j=mid+1;
    int cont=0;
    while(i<=mid && j<=end){
      if(((Node)arr[i]).compareTo(arr[j])<0){
        arrNew[cont]=arr[i];
        cont++;
        i++;
      }
      else{
        arrNew[cont]=arr[j];
        cont++;
        j++;
      }
    }
    while(i<=mid){
      arrNew[cont]=arr[i];
      i++;
      cont++;
    }
    while(j<=end){
      arrNew[cont]=arr[j];
      j++;
      cont++;
    }
    
    return arrNew;
  }

  public static void mergeSort(Object[] arr,int start,int end){
    if(start>=end) return;
    int mid=(start+end)/2;
    mergeSort(arr, start, mid);
    mergeSort(arr,mid+1,end); 
    Object[] arrNew= merge(arr,start,mid,end);
    for (int i = 0; i < arrNew.length; i++)
      arr[start+i]=arrNew[i];
  }

  static class Node implements Comparable<Object> {
    int v;
    int edges;

    public Node(int v){
      this.v=v;
      edges=0;
    }
    public void sumEdge(){
      edges++;
    }
    @Override
    public int compareTo(Object o) {
      int c1=Integer.compare(((Node)o).edges,this.edges);
      if(c1==0) c1 = Integer.compare(((Node)o).v,this.v);
      return c1;
    }
  }
}
