import java.util.Scanner;
import tadsObli.Graph.*;

public class Ejercicio4 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Graph g = loadData(s);
        boolean res=isThreeConnected(g);
        if(res)System.out.println(1);
        else System.out.println(0);
    }

    public static boolean isThreeConnected(Graph g){
        int V = g.size();
        for (int i = 1; i < V; i++) 
            for (int j = 1; j < V; j++) {
                if(i==j)continue;
                if(!stillConnected(g,i,j))return false;
            }
        return true;
    }

    public static boolean stillConnected(Graph g,int v1,int v2){
        int V = g.size();
        boolean[] visited = initBool(V, false);
        visited[v1]=true;
        visited[v2]=true;
        int start= calculateStart(visited);
        
        dfs(g,start,visited);
        for (int i = 1; i < visited.length; i++){ 
            if(!visited[i])
                return false;   
        }
        return true;
    }
    public static int calculateStart(boolean[] visited){
        for (int i = 1; i < visited.length; i++)
           if(!visited[i])return i; 
        return -1;
    }    

    public static void dfs(Graph g,int o, boolean[] visited){
        visited[o]=true;
        for(Edge e : g.edges(o)){
            if(!visited[e.vDest]){
                dfs(g, e.vDest, visited);
            }
        }
    }

    public static boolean[] initBool(int size,boolean value){
        boolean[] arr=new boolean[size];
        for (int i = 0; i < arr.length; i++)
            arr[i]=value;
        return arr;
    }

    public static Graph loadData(Scanner s){
        int vQuant = s.nextInt();
        Graph g = new LinkedGraph(vQuant, false);
        int edges=s.nextInt();
        for (int i = 0; i < edges; i++) {
            int from=Integer.parseInt(s.next());
            int to=Integer.parseInt(s.next());
            int weight=1;
            g.addWeightedEdge(from, to,weight);
        }
        return g;
    }
}
