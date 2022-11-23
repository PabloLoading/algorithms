public class Police {
  public static void main(String[] args) {
    testPolice();
  }

  public static int thievesCaptured(char str[],int k){
    int cont =0;
    for (int i = 0; i < str.length; i++){
      for (int j = -k; j<=k && str[i]=='P'; j++){
        if( i+j<0 || i+j>=str.length || str[i+j]!='T') continue;
        str[i]='0';
        str[i+j]='0';
        cont++;
      }
    }
    return cont;
  }
  public static void testPolice(){
    Boolean b1 =thievesCaptured("PPTTTP".toCharArray(), 2)==3;
    Boolean b2 =thievesCaptured("PPTTPT".toCharArray(), 2)==3;
    Boolean b3 =thievesCaptured("TPTTPP".toCharArray(), 2)==3;
    Boolean b4 =thievesCaptured("PTTTPP".toCharArray(), 2)==3;
    boolean res=b1 && b2 && b3 && b4;
    if(res)System.out.println("POLICE TEST PASSED CORRECTLY");
    else System.out.println("POLICE TEST NOT PASSED");
  }

}

