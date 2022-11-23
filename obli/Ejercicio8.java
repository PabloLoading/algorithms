import java.util.Scanner;

public class Ejercicio8 {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int[] arr=getArr(s);
    int M =Integer.parseInt(s.next());
    int[] memo = new int[M+1];
    for (int i = 0; i < memo.length; i++)
      memo[i]=-1;
    int[] test=getArr(s);
    for (int i = 0; i < test.length; i++) {
      int res = existSub(memo, arr, test[i]);
      System.out.println(res);
    }

  }

  public static int existSub(int[] memo,int[] arr,int m){
    if(m<=0 || m>= memo.length)return -1;
    if(memo[m]==1)return 1;
    if(memo[m]==0)return 0;

    for (int i = 0; i < arr.length; i++) {
      if(arr[i]==m){
        memo[m]=1;
        return 1;
      }
      int res = existSub(memo, arr, m-arr[i]);
      if(res==1){
        memo[m]=1;
        return 1;
      }
    }
    memo[m]=0;
    return 0;
  }

  public static int[] getArr(Scanner s){
    int N = Integer.parseInt(s.next());
    int[] arr = new int[N];
    for (int i = 0; i < N; i++)
      arr[i]=Integer.parseInt(s.next());      
    return arr;
  }
}
