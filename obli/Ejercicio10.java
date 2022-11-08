import java.util.Scanner;

public class Ejercicio10 {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int[] arr= getData(s);
    mergeSort(arr, 0, arr.length-1);
    String res="";
    for (int i = 0; i < arr.length; i++)
      res=arr[i]+res;
    System.out.println(res);
  }

  public static boolean lowerThan(int n1,int n2){
    String s1=""+n1;
    String s2=""+n2;
    int i=0;
    while(i<s1.length() && i<s2.length()){
      if(s1.charAt(i) < s2.charAt(i))return true;
      if(s1.charAt(i) > s2.charAt(i)) return false;
      i++;
    }
    while(s1.length()>i){
      char lastS2=s2.charAt(s2.length()-1);
      if(s1.charAt(i) < lastS2) return true;
      if(s1.charAt(i) > lastS2) return false;
      i++;
    }
    while(s2.length()>i){
      char lastS1=s1.charAt(s1.length()-1);
      if(s2.charAt(i) < lastS1) return false;
      if(s2.charAt(i) > lastS1) return true;
      i++;
    }
    return false;
  }


  public static int[] merge(int[] arr, int start, int mid, int end){
    int[] arrNew = new int[end-start+1];
    int i=start;
    int j=mid+1;
    int cont=0;
    while(i<=mid && j<=end){
      if(lowerThan(arr[i],arr[j])){
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

  public static void mergeSort(int[] arr,int start,int end){
    if(start>=end) return;
    int mid=(start+end)/2;
    mergeSort(arr, start, mid);
    mergeSort(arr,mid+1,end); 
    int[] arrNew= merge(arr,start,mid,end);
    for (int i = 0; i < arrNew.length; i++)
      arr[start+i]=arrNew[i];
  }

  public static int[] getData(Scanner s){
    int len = Integer.parseInt(s.next());
    int[] arr = new int[len];
    for (int i = 0; i < arr.length; i++)
      arr[i]=Integer.parseInt(s.next());      
    return arr;
  }

}
