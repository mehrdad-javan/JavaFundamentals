package se.lexicon;
public class StringDemo {
    void main() {

        String s1 = "Java";
        String s2 = new String("Java");
        IO.println(s1 == s2);      // false (different locations in memory)
        IO.println(s1.equals(s2)); // true (same content)


        String message = "  Welcome to Java Programming!  ";

        IO.println("-- String Inspection --");
        IO.println("Original: [" + message + "]");
        IO.println("Length: " + message.length());
        IO.println("Contains 'Java': " + message.contains("Java"));

        IO.println("\n-- String Manipulation --");
        IO.println("Uppercase: " + message.toUpperCase());
        IO.println("Trimmed: [" + message.trim() + "]"); // Removes leading/trailing spaces
        IO.println("Replace Java with Lexicon: " + message.replace("Java", "Lexicon"));

        IO.println("\n-- Comparison --");
        String name1 = "Erik";
        String name2 = "erik";
        IO.println("Erik equals erik? " + name1.equals(name2)); // false
        IO.println("Erik equalsIgnoreCase erik? " + name1.equalsIgnoreCase(name2)); // true

        IO.println("\n-- Escape Characters --");
        IO.println("Hello\nWorld");          // New line
        IO.println("Tab\tSpace");           // Tab
        IO.println("Quotes: \"Hello\"");     // Double quotes
        IO.println("Backslash: \\");        // Single backslash
    }
}