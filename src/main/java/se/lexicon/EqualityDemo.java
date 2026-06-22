package se.lexicon;

public class EqualityDemo {
    void main() {

        Person person1 = new Person();
        person1.id = 1; // true
        person1.name = "Mehrdad"; // true
        person1.email = "mehrdad.javan@lexicon.se"; // true


        Person person2 = new Person();
        person2.id = 1;
        person2.name = "Mehrdad";
        person2.email = "mehrdad.javan@lexicon.se";


        IO.println(person1.equals(person2));// TRUE

        IO.println(person1.hashCode());
        IO.println(person2.hashCode());

        IO.println("--------------------");


        String test1 = "TEST";
        String test2 = "TEST";
        IO.println(test1.equals(test2));
    }
}
