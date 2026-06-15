package se.lexicon;

public class FinalDemo {


    void main() {
        final int maxAttempts = 3;
        // maxAttempts = 5; // COMPILE ERROR: cannot assign a value to final variable

        IO.println("Max login attempts: " + maxAttempts);
    }


}