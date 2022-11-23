
public class MergeSort{
  public static void main(String[] args) {
    int[] arr=new int[10];
    arr[0]=2;
    arr[1]=5;
    arr[2]=8;
    arr[3]=3;
    arr[4]=1;
    arr[5]=12;
    arr[6]=4;
    arr[7]=26;
    arr[8]=6;
    arr[9]=10;
    mergeSort(arr, 0, arr.length-1);
    printArr(arr);
  }
  public static void printArr(int[] arr){
    for (int i = 0; i < arr.length; i++)
      System.out.println(arr[i]);
  }

  public static int[] merge(int[] arr, int start, int mid, int end){
    int[] arrNew = new int[end-start+1];
    int i=start;
    int j=mid+1;
    int cont=0;
    while(i<=mid && j<=end){
      if(arr[i]<arr[j]){
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
} 