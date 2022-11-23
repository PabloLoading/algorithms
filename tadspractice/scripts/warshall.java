package scripts;


import java.util.Scanner;

import tadsObli.Graph.Graph;
import tadsObli.Graph.MatrixGraph;
import tadsObliObli.Graph.*;


public class warshall {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Graph g = loadData(s);
        boolean[][] mat= warshal(g);
        int reqs= Integer.parseInt(s.next());
        for (int i = 0; i < reqs; i++) {
            int from = Integer.parseInt(s.next());
            int to = Integer.parseInt(s.next());
            boolean existPath = mat[from][to];
            if(existPath) System.out.println(1);
            else System.out.println(0);
        }
        s.close();
    }
    

    public static boolean[][] warshal(Graph g){
        int[][] matAd = g.getAdyMatrix();
        boolean[][] mat = new boolean[matAd.length][matAd.length];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                if(matAd[i][j]!=-1 || i==j)mat[i][j]=true;
                else mat[i][j]=false;
            }
        }
            

        for(int k = 1;k<mat.length;k++)
            for (int i = 1; i < mat.length; i++) 
                for (int j = 1; j < mat.length; j++) 
                    mat[i][j]=mat[i][j] || (mat[i][k] && mat[k][j]);
       return mat;
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
