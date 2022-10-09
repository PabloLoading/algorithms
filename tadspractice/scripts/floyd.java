package scripts;

import tads.Graph.*;
import java.util.Scanner;


public class floyd {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Graph g = loadData(s);
        int[][] mat= floydd(g);
        int reqs= Integer.parseInt(s.next());
        for (int i = 0; i < reqs; i++) {
            int from = Integer.parseInt(s.next());
            int to = Integer.parseInt(s.next());
            int cost = mat[from][to];
            if(cost > 214748364) System.out.println(-1);
            else System.out.println(cost);
        }
        s.close();
    }
    

    public static int[][] floydd(Graph g){
        int[][] mat = g.getAdyMatrix();
        for (int i = 0; i < mat.length; i++) {
            mat[i][i]=0;
        }
        for(int k = 1;k<mat.length;k++)
            for (int i = 1; i < mat.length; i++) 
                for (int j = 1; j < mat.length; j++) 
                    mat[i][j]=minCost(mat[i][j],mat[i][k],mat[k][j]);
       return mat;
    }

    public static int minCost(int e1,int e2,int e3){
        if(e2==-1 || e3==-1)return e1;
        if(e1==-1) return e2+e3;

        if(e1<e2+e3)return e1;
        else return e2+e3;
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
    //metodo para debuggin
    public static void printMatrix(int[][] mat){
        for (int i = 1; i < mat.length; i++) {
            for (int j =1; j < mat.length; j++) {
                System.out.print(mat[i][j]+" ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
}
