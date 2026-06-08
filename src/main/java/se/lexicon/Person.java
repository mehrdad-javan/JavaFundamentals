package se.lexicon;

public class Person {

    String firstName;
    String lastName;
    int age;


    void introduce(){
        IO.println("Hello, my name is " + firstName + " " + lastName);
    }
}
