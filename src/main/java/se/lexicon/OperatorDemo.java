package se.lexicon;

public class OperatorDemo {
    void main() {
        // Arithmetic Operators
        int a = 10;
        int b = 3;
        IO.println("-- Arithmetic --");
        IO.println("a + b = " + (a + b));  // 13
        IO.println("a - b = " + (a - b));  // 7
        IO.println("a * b = " + (a * b));  // 30
        IO.println("a / b = " + (a / b));  // 3
        IO.println("a % b = " + (a % b));  // 1

        // Assignment Operators
        int x = 10;
        IO.println("\n-- Assignment --");
        IO.println("start x = " + x); // 10
        x += 5; // 15
        x -= 2; // 13
        x *= 2; // 26
        x /= 2; // 13
        IO.println("final x = " + x); // 13

        // Comparison Operators
        int p = 10;
        int q = 5;
        IO.println("\n-- Comparison --");
        IO.println("p == q -> " + (p == q)); // false
        IO.println("p != q -> " + (p != q)); // true
        IO.println("p > q  -> " + (p > q));  // true
        IO.println("p <= q -> " + (p <= q)); // false

        // Logical Operators
        int n = 10;
        boolean andResult = (n > 5 && n < 20);   // true
        boolean orResult = (n < 5 || n == 10);  // true
        boolean notResult = !(n == 10);          // false
        IO.println("\n-- Logical --");
        IO.println("n > 5 && n < 20 -> " + andResult);
        IO.println("n < 5 || n == 10 -> " + orResult);
        IO.println("!(n == 10) -> " + notResult);
    }
}