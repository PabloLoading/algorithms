package obliHashFunctions;


public class IntId implements HashFun<Integer> {
    @Override
    public int hash(Integer e){
        return (int)e;
    }

}
