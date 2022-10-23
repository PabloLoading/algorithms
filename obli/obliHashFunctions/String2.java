package obliHashFunctions;


public class String2 implements HashFun<String> {

    @Override
    public int hash(String str) {
        int sum=0;
        for(int i=0;i<str.length();i++){
            int c = str.charAt(i);
            sum+=c*Math.pow(2,i);
        }
        return sum;
    }
    
}
