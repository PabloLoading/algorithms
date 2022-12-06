import java.util.Scanner;

public class Ejercicio7 {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    
    int[] s1 = new int[s.nextInt()];
    int sum1 = fillAndGetSum(s1,s);

    int[] s2 = new int[s.nextInt()];
    int sum2 = fillAndGetSum(s2,s);

    int[] s3 = new int[s.nextInt()];
    int sum3 = fillAndGetSum(s3,s);

    int ret = maxSum(s1,s2,s3,sum1,sum2,sum3);
    System.out.println(ret);
  }

  public static int maxSum(int[] s1, int[] s2, int[] s3, int sum1, int sum2, int sum3){
    int pos1 = 0;
    int pos2= 0;
    int pos3= 0;
    if (sum1 != sum2 && sum2 != sum3) {
      while (!(sum1 == sum2 && sum2 == sum3)){
        int max = max(sum1,sum2,sum3);
        if (max == sum1) {
          sum1=sum1-s1[pos1];
          pos1++;
        } else if (max == sum2) {
          sum2= sum2-s2[pos2];
          pos2++;
        }else if (max == sum3) {
          sum3= sum3 - s3[pos3];
          pos3++;
        }
      }
      return sum1;
    }
    return sum1;
  }

  public static int max(int a,int b, int c){
    if(a>=b && a>=c) return a;
    if(b>=a && b>=c) return b;
    return c;
  }
  
  public static int fillAndGetSum(int[] arr,Scanner s){
    int sum=0;
    for (int i = 0; i < arr.length; i++){
      arr[i]=Integer.parseInt(s.next());      
      sum+=arr[i];
    }
    return sum;
  }
}
