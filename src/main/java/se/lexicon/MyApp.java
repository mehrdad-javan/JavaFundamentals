package se.lexicon;

public class MyApp {


    // psvm + Tab
    static void main() {
        // sout + Tab
        System.out.println("Hello World!");

        //MethodDemo.printSum(10, 20);


      Person p1 = new Person();
      p1.firstName = "Erik";
      p1.lastName = "Lindholm";
      p1.age = 25;

      Person p2 = new Person();
      p2.firstName = "Sofia";
      p2.lastName = "Karlsson";
      p2.age = 30;

      Person p3 = new Person();
      p3.firstName = "Lisa";
      p3.lastName = "Andersson";
      p3.age = 22;

      p1.introduce();
      p2.introduce();
      p3.introduce();
    }
}
