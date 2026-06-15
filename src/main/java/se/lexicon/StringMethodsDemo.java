package se.lexicon;

public class StringMethodsDemo {
    void main() {
        String message = "Java Programming is Fun!";

        // 1. indexOf() Examples (Overloaded)
        IO.println("-- indexOf() --");
        int firstP = message.indexOf('P');          // 5 (Finds character 'P')
        int firstGram = message.indexOf("gram");    // 8 (Finds substring "gram")
        int secondA = message.indexOf('a', 2);      // 3 (Finds 'a' starting from index 2)
        int missing = message.indexOf("Python");    // -1 (Not found)

        IO.println("First 'P': " + firstP);
        IO.println("First 'gram': " + firstGram);
        IO.println("Second 'a': " + secondA);
        IO.println("Missing: " + missing);

        // 2. substring() Examples (Overloaded)
        IO.println("\n-- substring() --");
        String language = message.substring(0, 4);      // "Java" (0 to 3, 4 is exclusive)
        String topic = message.substring(5, 16);        // "Programming" (5 to 15, 16 is exclusive)
        String remainder = message.substring(17);       // "is Fun!" (17 to the very end)

        IO.println("Language: " + language);
        IO.println("Topic: " + topic);
        IO.println("Remainder: " + remainder);


        String oldWay = "This is the old way.\n" +
                "It requires concatenation\n" +
                "and manual newline characters.";

        String sqlQuery = """
                Select * from users
                where id = 1 and name = 'John';
                """;


    }
}