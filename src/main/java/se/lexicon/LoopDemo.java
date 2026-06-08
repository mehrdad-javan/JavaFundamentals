package se.lexicon;

public class LoopDemo {

    void main() {
        for (int i = 0; i < 5; i++) {
            IO.println("Iteration: " + i);
        }

        int coffeeCups = 0;
        while (coffeeCups < 3) {
            coffeeCups++;
            IO.println("Drinking cup #" + coffeeCups);
        }

        IO.println("\n-- Break & Continue --");
        for (int j = 1; j <= 5; j++) {
            if (j == 2) continue; // Skip number 2
            if (j == 4) break;    // Stop completely at 4
            IO.println("Value: " + j);
        }

    }
}
