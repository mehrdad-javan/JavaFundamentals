![Lexicon Logo](https://lexicongruppen.se/media/wi5hphtd/lexicon-logo.svg)

# Java Exercise Solutions

> Solutions use **JDK 25** features: `IO.println()` for output and `IO.readln()` for input — no `Scanner` needed.

---

## Exercise 1 – Profile Card

```java
public class Exercise01 {
    // Store your name, age, and city in variables and print a formatted profile card.
    // Do not hardcode values directly inside println — they must come from variables.
    void main() {
        String name = "Sofia";       // String variable to hold the person's name
        int    age  = 22;            // int variable to hold the age
        String city = "Stockholm";   // String variable to hold the city

        IO.println("====================");   // prints a border line
        IO.println("     My Profile");        // prints the header title
        IO.println("====================");   // prints a border line
        IO.println("Name : " + name);         // concatenates the label with the variable value
        IO.println("Age  : " + age);          // int is automatically converted to String when concatenated
        IO.println("City : " + city);         // prints the city variable
        IO.println("====================");   // prints the closing border
    }
}
```

---

## Exercise 2 – Leap Year

```java
public class Exercise02 {
    // Ask the user to enter a year. Print whether it is a leap year or not.
    // A year is a leap year if divisible by 4, but not by 100 — unless also divisible by 400.
    void main() {
        int year = Integer.parseInt(IO.readln("Enter a year: "));
        // IO.readln() prints the prompt and returns the user's input as a String
        // Integer.parseInt() converts that String to an int

        boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        // year % 4 == 0      → divisible by 4 (basic leap year rule)
        // year % 100 != 0    → but NOT by 100 (century years are excluded)
        // year % 400 == 0    → unless also divisible by 400 (every 400 years counts again)

        if (isLeapYear) {                                  // checks the boolean value
            IO.println(year + " is a leap year.");         // runs when isLeapYear is true
        } else {
            IO.println(year + " is NOT a leap year.");     // runs when isLeapYear is false
        }
    }
}
```

---

## Exercise 3 – Shopping Receipt

```java
public class Exercise03 {
    // A customer buys 3 items. Store name, quantity, and price per unit in variables.
    // Calculate the total for each item and the grand total, then print a formatted receipt.
    void main() {
        String item1 = "Apple"; int qty1 = 2; double price1 = 15.00;  // item 1: name, quantity, unit price
        String item2 = "Milk";  int qty2 = 1; double price2 = 22.50;  // item 2: name, quantity, unit price
        String item3 = "Bread"; int qty3 = 3; double price3 = 18.00;  // item 3: name, quantity, unit price

        double total1     = qty1 * price1;             // 2 × 15.00 = 30.00 (line total for Apple)
        double total2     = qty2 * price2;             // 1 × 22.50 = 22.50 (line total for Milk)
        double total3     = qty3 * price3;             // 3 × 18.00 = 54.00 (line total for Bread)
        double grandTotal = total1 + total2 + total3;  // sum of all three line totals

        IO.println("==============================");  // top border
        IO.println("           Receipt");              // header title
        IO.println("==============================");  // separator after header
        IO.println(String.format("%-12s %d x %.2f = %.2f SEK", item1, qty1, price1, total1));
        // String.format() builds a formatted String — %-12s left-aligns name in 12 chars, %.2f = 2 decimal places
        IO.println(String.format("%-12s %d x %.2f = %.2f SEK", item2, qty2, price2, total2)); // same format for Milk
        IO.println(String.format("%-12s %d x %.2f = %.2f SEK", item3, qty3, price3, total3)); // same format for Bread
        IO.println("------------------------------");  // separator before grand total
        IO.println(String.format("Grand Total:           %.2f SEK", grandTotal)); // total with 2 decimal places
        IO.println("==============================");  // bottom border
    }
}
```

---

## Exercise 4 – Average of Three Numbers

```java
public class Exercise04 {
    // Ask the user to enter three integers. Calculate and print their average
    // making sure the result shows the decimal part.
    void main() {
        int a = Integer.parseInt(IO.readln("Enter first number:  "));  // reads input and converts to int
        int b = Integer.parseInt(IO.readln("Enter second number: "));  // reads input and converts to int
        int c = Integer.parseInt(IO.readln("Enter third number:  "));  // reads input and converts to int

        double average = (a + b + c) / 3.0;    // dividing by 3.0 (not 3) forces a decimal result
        IO.println("Average: " + average);     // prints the average
    }
}
```

---

## Exercise 5 – Greet the User

```java
public class Exercise05 {
    // Ask the user to enter their first name and last name separately.
    // Print a personalised greeting that includes the full name.
    void main() {
        String firstName = IO.readln("Enter first name: ");  // prints prompt and returns input as a String
        String lastName  = IO.readln("Enter last name:  ");  // reads the last name the same way

        IO.println("Hello, " + firstName + " " + lastName + "! Welcome aboard.");
        // + joins both names and the surrounding text into one output line
    }
}
```

---

## Exercise 6 – Arithmetic With User Input

```java
public class Exercise06 {
    // Ask the user to enter two integers.
    // Print the result of addition, subtraction, multiplication, and division.
    void main() {
        int a = Integer.parseInt(IO.readln("Enter first number:  "));  // reads and converts to int
        int b = Integer.parseInt(IO.readln("Enter second number: "));  // reads and converts to int

        IO.println(a + " + " + b + " = " + (a + b));  // parentheses force math before string concatenation
        IO.println(a + " - " + b + " = " + (a - b));  // subtraction
        IO.println(a + " * " + b + " = " + (a * b));  // multiplication
        IO.println(a + " / " + b + " = " + (a / b));  // integer division — decimal part is dropped
    }
}
```

---

## Exercise 7 – Convert Seconds

```java
public class Exercise07 {
    // Ask the user to enter a number of seconds.
    // Convert and print it as hours, minutes, and remaining seconds in HH:MM:SS format.
    void main() {
        int totalSeconds = Integer.parseInt(IO.readln("Enter seconds: ")); // reads and converts to int

        int hours   = totalSeconds / 3600;         // 1 hour = 3600 seconds; integer division gives whole hours
        int minutes = (totalSeconds % 3600) / 60;  // remaining seconds after removing hours, then divide by 60
        int seconds = totalSeconds % 60;           // remaining seconds after removing complete minutes

        IO.println(String.format("%02d:%02d:%02d", hours, minutes, seconds));
        // %02d → prints integer with at least 2 digits, padded with a leading 0 if needed (e.g. 5 → "05")
    }
}
```

---

## Exercise 8 – Guess the Number

```java
import java.util.Random;    // imports Random for generating random numbers

public class Exercise08 {
    // Generate a random number between 1 and 500. Let the user keep guessing until correct.
    // After each wrong guess print if it was too small or too big.
    // When correct, print a congratulation message with the total number of guesses.
    void main() {
        Random random  = new Random();              // creates a Random object for number generation
        int    target  = random.nextInt(500) + 1;  // nextInt(500) gives 0–499; +1 shifts range to 1–500
        int    guesses = 0;                         // counter — tracks how many guesses the user has made

        while (true) {                              // infinite loop — exits only when the correct guess is made
            int guess = Integer.parseInt(IO.readln("Enter your guess: ")); // prompts, reads, and converts to int
            guesses++;                              // increments the counter for every guess

            if (guess == target) {                  // correct guess
                IO.println("Correct! You got it in " + guesses + " guesses.");
                break;                              // exits the while loop
            } else if (guess < target) {            // guess is lower than the target
                IO.println("Too small!");
            } else {                                // guess is higher than the target
                IO.println("Too big!");
            }
        }
    }
}
```

---

## Exercise 9 – Temperature Converter

```java
public class Exercise09 {
    // Ask the user to enter a temperature in Celsius.
    // Convert it to both Fahrenheit and Kelvin and print all three values.
    void main() {
        double celsius = Double.parseDouble(IO.readln("Enter temperature in Celsius: "));
        // IO.readln() returns a String — Double.parseDouble() converts it to a decimal number

        double fahrenheit = celsius * 9.0 / 5 + 32;   // 9.0 (not 9) prevents integer division
        double kelvin     = celsius + 273.15;           // K = °C + 273.15

        IO.println("Celsius:    " + celsius    + " °C"); // prints the original input
        IO.println("Fahrenheit: " + fahrenheit + " °F"); // prints the converted Fahrenheit value
        IO.println("Kelvin:     " + kelvin     + " K");  // prints the converted Kelvin value
    }
}
```

---

## Exercise 10 – Swap Two Values Without a Temp Variable

```java
public class Exercise10 {
    // Swap the values of a and b without declaring a third variable.
    // Solve using only addition and subtraction.
    void main() {
        int a = 15;  // first value to swap
        int b = 42;  // second value to swap

        IO.println("Before: a = " + a + ", b = " + b);  // shows values before swapping

        a = a + b;   // a = 15 + 42 = 57  (a now holds the sum of both original values)
        b = a - b;   // b = 57 - 42 = 15  (subtracting original b recovers original a)
        a = a - b;   // a = 57 - 15 = 42  (subtracting new b recovers original b)

        IO.println("After:  a = " + a + ", b = " + b);  // shows values after swapping
    }
}
```

---

## Exercise 11 – FizzBuzz

```java
public class Exercise11 {
    // Print every integer from 1 to 30, one per line.
    // Divisible by 3 → Fizz, by 5 → Buzz, by both → FizzBuzz, otherwise the number.
    void main() {
        for (int i = 1; i <= 30; i++) {               // loop counter i goes from 1 to 30 inclusive
            if (i % 3 == 0 && i % 5 == 0) {           // check BOTH first — must come before individual checks
                IO.println("FizzBuzz");                // divisible by both 3 and 5 (e.g. 15, 30)
            } else if (i % 3 == 0) {                   // divisible by 3 only
                IO.println("Fizz");
            } else if (i % 5 == 0) {                   // divisible by 5 only
                IO.println("Buzz");
            } else {                                   // not divisible by 3 or 5
                IO.println(i);                         // prints the number itself
            }
        }
    }
}
```

---

## Exercise 12 – Grade Calculator

```java
public class Exercise12 {
    // Ask the user to enter a score between 0 and 100. Print the matching letter grade.
    // If the score is outside that range, print an error message.
    void main() {
        int score = Integer.parseInt(IO.readln("Enter score: ")); // reads and converts to int

        if (score < 0 || score > 100) {             // input guard — rejects anything outside 0–100
            IO.println("Invalid score. Please enter a value between 0 and 100.");
        } else if (score >= 90) {                   // 90–100 → A
            IO.println("Grade: A");
        } else if (score >= 80) {                   // 80–89 → B (score < 90 already guaranteed by the chain)
            IO.println("Grade: B");
        } else if (score >= 70) {                   // 70–79 → C
            IO.println("Grade: C");
        } else if (score >= 60) {                   // 60–69 → D
            IO.println("Grade: D");
        } else {                                    // 0–59 → F
            IO.println("Grade: F");
        }
    }
}
```

---

## Exercise 13 – Weekday or Weekend?

```java
public class Exercise13 {
    // Ask the user to enter a day of the week.
    // Use a switch with arrow syntax to print Weekday, Weekend, or Unknown day.
    void main() {
        String day = IO.readln("Enter day: ");    // prints the prompt and returns the input as a String

        switch (day) {                              // evaluates the value of the day variable
            case "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" ->
                IO.println("Weekday");              // one case covers all five weekdays
            case "Saturday", "Sunday" ->
                IO.println("Weekend");              // one case covers both weekend days
            default ->
                IO.println("Unknown day");          // runs if no case matched
        }
    }
}
```

---

## Exercise 14 – Multiplication Table

```java
public class Exercise14 {
    // Ask the user for a number and print its multiplication table from 1 to 10.
    void main() {
        int n = Integer.parseInt(IO.readln("Enter a number: ")); // reads and converts to int

        for (int i = 1; i <= 10; i++) {             // loop from 1 to 10 inclusive
            IO.println(String.format("%d x %-2d = %d", n, i, n * i));
            // %-2d → left-aligns i in a 2-character field so all rows line up neatly
        }
    }
}
```

---

## Exercise 15 – Reverse a Number

```java
public class Exercise15 {
    // Ask the user for a positive integer and reverse its digits using only arithmetic.
    void main() {
        int number = Integer.parseInt(IO.readln("Enter a number: ")); // reads and converts to int

        int reversed = 0;       // accumulates the reversed result, starts at 0
        int temp     = number;  // working copy so we don't lose the original value

        while (temp != 0) {                           // loop until all digits have been processed
            reversed = reversed * 10 + temp % 10;    // shift result left, then add the last digit of temp
            temp     = temp / 10;                     // remove the last digit from temp
        }
        // Example with 123: step 1 → reversed=3, temp=12 | step 2 → reversed=32, temp=1 | step 3 → reversed=321, temp=0

        IO.println("Reversed: " + reversed);          // prints the final reversed number
    }
}
```

---

## Exercise 16 – Running Total

```java
public class Exercise16 {
    // The user enters integers one at a time. Print running total and count after each entry.
    // Stop when the user enters 0. Print a final summary with the average.
    void main() {
        int total = 0;   // accumulates the sum of all entered numbers
        int count = 0;   // tracks how many numbers have been entered

        while (true) {                              // loop runs until the user enters 0
            int input = Integer.parseInt(IO.readln("Enter a number (0 to stop): ")); // reads and converts to int
            if (input == 0) break;                  // exits the loop immediately when 0 is entered

            total += input;                         // adds current input to the running total
            count++;                                // increments the count
            IO.println("Total: " + total + " | Count: " + count); // prints the current running state
        }

        IO.println("--- Summary ---");
        IO.println("Count:   " + count);            // total numbers entered
        IO.println("Total:   " + total);            // final sum
        IO.println("Average: " + (count > 0 ? (double) total / count : 0.0));
        // (double) total → casts to double so division gives a decimal result
        // count > 0      → prevents division by zero if user entered 0 immediately
    }
}
```

---

## Exercise 17 – Password Strength Checker

```java
public class Exercise17 {
    // Ask the user to enter a password and check three rules:
    // 1. Length >= 8  2. Has at least one uppercase letter  3. Has at least one digit
    // Print how many rules are met and rate the password as Strong, Medium, or Weak.
    void main() {
        String password = IO.readln("Enter password: ");  // reads the full password as a String

        boolean hasUppercase = false;  // flag — set to true when an uppercase letter is found
        boolean hasDigit     = false;  // flag — set to true when a digit is found
        int     rulesMet     = 0;      // counts how many of the three rules are satisfied

        if (password.length() >= 8) rulesMet++;  // rule 1: check the length of the password

        for (int i = 0; i < password.length(); i++) { // loop over every character position
            char ch = password.charAt(i);              // gets the character at index i
            if (ch >= 'A' && ch <= 'Z') hasUppercase = true; // 'A'–'Z' covers all uppercase letters
            if (ch >= '0' && ch <= '9') hasDigit     = true; // '0'–'9' covers all digit characters
        }

        if (hasUppercase) rulesMet++;  // rule 2: at least one uppercase letter found
        if (hasDigit)     rulesMet++;  // rule 3: at least one digit found

        String rating;
        if      (rulesMet == 3) rating = "Strong"; // all three rules satisfied
        else if (rulesMet == 2) rating = "Medium"; // two rules satisfied
        else                    rating = "Weak";   // zero or one rule satisfied

        IO.println("Rules met: " + rulesMet + "/3"); // prints the score out of 3
        IO.println("Rating: " + rating);             // prints the strength rating
    }
}
```

---

## Exercise 18 – Sum of Digits

```java
public class Exercise18 {
    // Write a static method sumOfDigits(int n) that returns the sum of all digits
    // in a positive integer. Test it from main with at least three values.

    public static int sumOfDigits(int n) {   // static: callable without an object; returns an int
        int sum = 0;            // accumulates the digit sum, starts at 0
        while (n != 0) {        // loop until all digits have been extracted
            sum += n % 10;      // n % 10 extracts the last digit (e.g. 1234 % 10 = 4)
            n   /= 10;          // n / 10 removes the last digit (e.g. 1234 / 10 = 123)
        }
        return sum;             // sends the final sum back to the caller
    }

    void main() {
        IO.println("sumOfDigits(1234) = " + sumOfDigits(1234)); // → 10 (1+2+3+4)
        IO.println("sumOfDigits(9)    = " + sumOfDigits(9));    // → 9
        IO.println("sumOfDigits(305)  = " + sumOfDigits(305));  // → 8 (3+0+5)
    }
}
```

---

## Exercise 19 – Count the Vowels

```java
public class Exercise19 {
    // Write a static method countVowels(String s) that returns the number of vowels
    // (a, e, i, o, u — case-insensitive) in the string. Test it from main.

    public static int countVowels(String s) {  // static method; takes a String, returns the vowel count
        int count = 0;              // holds the total number of vowels found
        s = s.toLowerCase();        // convert once so we only need to check lowercase vowels
        for (int i = 0; i < s.length(); i++) { // loop over every character position
            char ch = s.charAt(i);  // gets the character at position i
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') { // checks all five vowels
                count++;            // increments when a vowel is found
            }
        }
        return count;               // sends the total count back to the caller
    }

    void main() {
        IO.println("countVowels(\"Hello World\") = " + countVowels("Hello World")); // → 3
        IO.println("countVowels(\"Java\")        = " + countVowels("Java"));        // → 2
        IO.println("countVowels(\"rhythm\")      = " + countVowels("rhythm"));      // → 0
    }
}
```

---

## Exercise 20 – Find All Prime Numbers

```java
public class Exercise20 {
    // Write a static method isPrime(int n) that returns true if n is prime.
    // Use it in main to print all prime numbers from 2 to 50 on a single line.

    public static boolean isPrime(int n) {   // static method; returns true if n is a prime number
        if (n <= 1) return false;            // 0 and 1 are not prime by definition
        for (int i = 2; i * i <= n; i++) {  // only check divisors up to √n — any larger divisor has a matching smaller one
            if (n % i == 0) return false;   // n is evenly divisible by i → not prime
        }
        return true;                        // no divisors found — n is prime
    }

    void main() {
        StringBuilder result = new StringBuilder();  // builds the output string without creating many temporary strings
        for (int i = 2; i <= 50; i++) {              // checks every number from 2 to 50
            if (isPrime(i)) {
                result.append(i).append(" ");         // appends the prime number followed by a space
            }
        }
        IO.println(result.toString().trim());         // trim() removes the trailing space, then prints the full line
    }
}
```