package se.lexicon;

public class SelectionDemo {
    void main() {
        // Example 1: If-Else (Temperature Check)
        int temperature = 25;
        IO.println("-- Temperature Check --");
        if (temperature > 30) {
            IO.println("It's hot outside!");
        } else if (temperature >= 15) {
            IO.println("The weather is nice.");
        } else {
            IO.println("It's cold outside.");
        }

        // Example 2: Switch (Traffic Light)
        String lightColor = "Green";
        IO.println("\n-- Traffic Light --");
        switch (lightColor) {
            case "Red" -> IO.println("Stop!");
            case "Yellow" -> IO.println("Prepare to stop.");
            case "Green" -> IO.println("Go!");
            default -> IO.println("Invalid light color.");
        }

        // Example 3: If-Else If-Else (Membership Level)
        int points = 150;
        IO.println("\n-- Membership Level --");
        if (points >= 200) {
            IO.println("Status: Gold Member");
        } else if (points >= 100) {
            IO.println("Status: Silver Member");
        } else {
            IO.println("Status: Bronze Member");
        }

        // Example 4: Switch (Day Type)
        String day = "Saturday";
        IO.println("\n-- Day Type --");
        switch (day) {
            case "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" -> IO.println("It's a weekday.");
            case "Saturday", "Sunday" -> IO.println("It's the weekend!");
            default -> IO.println("Invalid day.");
        }
    }
}