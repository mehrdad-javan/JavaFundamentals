package se.lexicon;

public class StringBuilderDemo {
    void main() {
        // 1. Creation
        // StringBuilder sb = new StringBuilder();
        StringBuilder sb = new StringBuilder("Hello");

        // 2. Appending
        sb.append(" World");
        sb.append("!");
        IO.println("After append: " + sb); // "Hello World!"

        // 3. Inserting
        sb.insert(6, "Java ");
        IO.println("After insert: " + sb); // "Hello Java World!"

        // 4. Deleting
        sb.delete(11, 17);
        IO.println("After delete: " + sb); // "Hello Java!"

        // 5. Reversing
        sb.reverse();
        IO.println("After reverse: " + sb); // "!avaJ olleH"

        // 6. Converting back to String
        String finalResult = sb.toString();
    }
}