package hashFunctions;

import obliHashFunctions.HashFun;

public class String1 implements HashFun<String> {

    @Override
    public int hash(String str) {
        int sum=0;
        for(int i=0;i<str.length();i++){
            int c = str.charAt(i);
            sum+=c*(i+1);
        }
        return sum;
    }
    
}
