package se.lexicon;

import java.math.BigDecimal;
import java.math.BigInteger;

public class OverloadingDemo {

    public static int add(int a, int b) {
        return a + b;
    }

    public static double add(double a, double b) {
        return a + b;
    }

    public static int add(int... numbers){
        int sum = 0;
        for( int number : numbers){
            sum += number;
            //sum = sum + number;
        }
        return sum;
    }

    public static BigInteger add(BigInteger a, BigInteger b){
        return a.add(b);
    }

    public static BigDecimal add(BigDecimal a, BigDecimal b){
        return a.add(b);
    }

    void main() {
        //int result =  OverloadingDemo.add(10,10,5,4,7);
        //IO.println(result);
        IO.println(Long.MAX_VALUE);

    }

}
