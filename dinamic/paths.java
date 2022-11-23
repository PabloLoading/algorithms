
public class paths {
  public static void main(String[] args) {
    int n = Integer.parseInt(args[0]);
    int m = Integer.parseInt(args[1]);
    int res= findPaths(n, m);
    System.out.println(res);
  }

  public static int findPaths(int n, int m){
    int[][] mat = new int[n][m];
    for (int i = 0; i < n; i++)
      mat[i][m-1]=1;
    for (int i = 0; i < m; i++)
      mat[n-1][i]=1;
      
    for (int i = n-2; i >= 0; i--) 
      for (int j = m-2; j >= 0; j--) 
        mat[i][j]=mat[i+1][j]+mat[i][j+1];
    return mat[0][0];
  }

}
