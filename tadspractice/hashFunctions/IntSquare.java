package hashFunctions;

import obliHashFunctions.HashFun;

public class IntSquare implements HashFun<Integer> {

    @Override
    public int hash(Integer data) {
        int num=(int)data;
        return num*num;
    }
    
}
