package se.lexicon;

public class MethodDemo {


    public static void sayHello(String msg){
        IO.println("Hello World!" + msg);
    }

    public static void printSum(int num1, int num2){
        IO.println("The sum is:"+ (num1 + num2));
    }

    public static int add(int num1, int num2){
        return num1 + num2;
    }

}
