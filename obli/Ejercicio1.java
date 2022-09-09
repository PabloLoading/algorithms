import java.util.Scanner;

import javax.swing.SpinnerDateModel;

import tads.Hash.*;
import hashFunctions.*;

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner cli= new Scanner(System.in);
        HashFun<String> h1 = new String1();
        HashFun<String> h2 = new String2();
        
        int lines=cli.nextInt();
        Hash<String,Integer> h = new CloseHash<String,Integer>(lines,h1,h2);
        for(int i =0;i<lines;i++){
            String str = cli.nextLine();
            h.insert(str, 43);
        }
        int result = h.size();

        
        System.out.println(result);        
    }
}
