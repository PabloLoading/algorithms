import java.util.Scanner;

public class Ejercicio6 {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int[] arr= getData(s);
    int res= getAlone(arr,0,arr.length-1);
    System.out.println(res);
  }

  public static int getAlone(int[] arr,int start,int end){
    if(end==start) return arr[start];
    if(end-start==2){
      if(arr[start]!=arr[start+1])return arr[start];
      else return arr[start+2];
    }
    
    int mid = (end+start)/2;
    if(arr[mid+1]==arr[mid])mid++;
    int cantElemsM2=end-mid;

    if(cantElemsM2 %2==0) return getAlone(arr, start,mid);
    else return getAlone(arr,mid+1,end);
  }

  public static int[] getData(Scanner s){
    int len = Integer.parseInt(s.next());
    int[] arr = new int[len];
    for (int i = 0; i < arr.length; i++)
      arr[i]=Integer.parseInt(s.next());      
    return arr;
  }
}
