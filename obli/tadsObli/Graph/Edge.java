package tadsObli.Graph;

public class Edge implements Comparable<Edge>{
  public int vDest;
  public int weight;
  public int vIn;

  public Edge(int v, int weight){
    vDest=v;
    this.weight=weight;
  }

  public Edge(int vIn, int weight,int vDest){
    this.vIn=vIn;
    this.vDest=vDest;
    this.weight=weight;
  }
  @Override
  public boolean equals(Object o){
    Edge other = (Edge) o;
    return this.vDest==other.vDest;
  }
  public int getDest(){
    return vDest;
  }
  public int getWeight(){
    return weight;
  }

  @Override
  public int compareTo(Edge e) {
    int c1=Integer.compare(e.vIn,this.vIn);
    if(c1==0) c1 = Integer.compare(e.vDest,this.vDest);
    return c1;
  }
}
