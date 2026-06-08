package se.lexicon;

public class TypeCastingDemo {

    void main() {
        // 1. Widening Casting (Automatic)
        // Converting a smaller type to a larger type size:
        // byte -> short -> char -> int -> long -> float -> double
        int myInt = 9;
        double myDouble = myInt; // Automatic casting: int to double

        IO.println("-- Widening Casting --");
        IO.println("Int value: " + myInt);       // 9
        IO.println("Double value: " + myDouble); // 9.0

        // 2. Narrowing Casting (Manual)
        // Converting a larger type to a smaller size type:
        // double -> float -> long -> int -> char -> short -> byte
        double d = 9.78;
        int i = (int) d; // Manual casting: double to int

        IO.println("\n-- Narrowing Casting --");
        IO.println("Double value: " + d); // 9.78
        IO.println("Int value: " + i);    // 9 (decimal part is lost)

        // 3. Potential for Data Loss (Overflow)
        int largeInt = 130;
        byte smallByte = (byte) largeInt;

        IO.println("\n-- Data Loss (Overflow) --");
        IO.println("Large Int: " + largeInt);   // 130
        IO.println("Small Byte: " + smallByte); // -126 (Wait, what happened? Overflow!)
    }
}