import java.util.Scanner;
public class Ejercicio9 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] arr = getArr(s);
        int[] test = getArr(s);
        for (int i = 0; i < test.length; i++) {
            int res = count(arr,test[i],0,0);
            if(res==Integer.MAX_VALUE)System.out.println(0);
            else System.out.println(res);
        }
    }
    
    
    public static int count(int[] arr,int origen,int sol,int i){
        if(origen==0) return sol;
        if(origen<0 || i>=arr.length) return Integer.MAX_VALUE;

        int res1=count(arr, origen-arr[i],sol+1,i);
        int res2= count(arr, origen, sol, i+1);

        return min(res1,res2);
    }

    public static int min(int n1,int n2){
        if(n1<n2)return n1;
        return n2;
    }

    public static int[] getArr(Scanner s){
        int N = Integer.parseInt(s.next());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++)
          arr[i]=Integer.parseInt(s.next());      
        return arr;
      }
}
