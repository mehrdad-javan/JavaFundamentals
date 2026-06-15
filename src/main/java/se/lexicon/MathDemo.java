package se.lexicon;

public class MathDemo {
    void main() {
        // 1. Absolute value
        IO.println(Math.abs(-42));       // 42

        // 2. Max and Min
        IO.println(Math.max(100, 250));  // 250
        IO.println(Math.min(100, 250));  // 100

        // 3. Power and Square Root
        IO.println(Math.pow(2, 8));      // 256.0
        IO.println(Math.sqrt(256));      // 16.0

        // 4. Rounding
        IO.println(Math.round(4.4));     // 4
        IO.println(Math.round(4.5));     // 5
        IO.println(Math.floor(4.9));     // 4.0
        IO.println(Math.ceil(4.1));      // 5.0

        // 5. Random number between 1 and 100
        int random = (int) (Math.random() * 100) + 1;
        IO.println("Random (1-100): " + random);

        // 6. Circle area using Math.PI
        double radius = 5.0;
        double area = Math.PI * Math.pow(radius, 2);
        IO.println("Circle area: " + area); // 78.539...
    }
}