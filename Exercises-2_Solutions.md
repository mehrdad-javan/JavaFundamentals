![Lexicon Logo](https://lexicongruppen.se/media/wi5hphtd/lexicon-logo.svg)

# Java Exercise Solutions – Part 2

---

## Exercise 1 – Word Reverser

```java
public class Exercise01 {
    // Ask the user to enter a word. Reverse it using StringBuilder and print the result.
    void main() {
        String word = IO.readln("Enter a word: ");          // reads the word from the user

        StringBuilder sb = new StringBuilder(word);         // initialises StringBuilder with the word
        sb.reverse();                                        // reverses the character sequence in-place

        IO.println("Reversed: " + sb);                      // sb.toString() is called automatically in concatenation
    }
}
```

---

## Exercise 2 – Email Slicer

```java
public class Exercise02 {
    // Ask the user to enter an email address.
    // Use indexOf() and substring() to extract the username and domain separately.
    void main() {
        String email = IO.readln("Enter email: ");       // reads the full email address

        int atIndex = email.indexOf('@');               // finds the position of the @ symbol

        String username = email.substring(0, atIndex);      // extracts everything before @
        String domain = email.substring(atIndex + 1);     // extracts everything after @ (atIndex + 1 skips @)

        IO.println("Username: " + username);
        IO.println("Domain  : " + domain);
    }
}
```

---

## Exercise 3 – String Stats

```java
public class Exercise03 {
    // Ask the user to enter a sentence.
    // Loop through every character and count vowels, consonants, digits, and spaces.
    void main() {
        String sentence = IO.readln("Enter a sentence: ");   // reads the full sentence
        String lower = sentence.toLowerCase();             // convert once so vowel check only needs lowercase

        int vowels = 0;   // accumulates the vowel count
        int consonants = 0;   // accumulates the consonant count
        int digits = 0;   // accumulates the digit count
        int spaces = 0;   // accumulates the space count

        for (int i = 0; i < lower.length(); i++) {           // iterates over every character position
            char ch = lower.charAt(i);                        // gets the character at index i

            if (ch == ' ') {                                                                    // space check first
                spaces++;
            } else if (ch >= '0' && ch <= '9') {                                               // digit: between '0' and '9'
                digits++;
            } else if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {       // one of the five vowels
                vowels++;
            } else if (ch >= 'a' && ch <= 'z') {                                               // remaining letters are consonants
                consonants++;
            }
        }

        IO.println("Vowels    : " + vowels);
        IO.println("Consonants: " + consonants);
        IO.println("Digits    : " + digits);
        IO.println("Spaces    : " + spaces);
    }
}
```

---

## Exercise 4 – Initials Generator

```java
public class Exercise04 {
    // Ask the user to enter their full name (first, optional middle, last).
    // Print the initials in dot notation, all uppercase.
    void main() {
        String name = IO.readln("Enter full name: ").trim();  // trim removes any leading/trailing spaces

        StringBuilder initials = new StringBuilder();          // will hold the final initials string

        // the very first character is always the first initial
        initials.append(Character.toUpperCase(name.charAt(0))).append('.'); // appends first letter + dot

        for (int i = 1; i < name.length(); i++) {              // start at 1 — index 0 is already handled
            if (name.charAt(i) == ' ' && i + 1 < name.length()) {  // a space means the next char starts a new word
                char nextLetter = name.charAt(i + 1);               // the letter right after the space
                initials.append(Character.toUpperCase(nextLetter)).append('.'); // appends initial + dot
            }
        }

        IO.println("Initials: " + initials);
    }
}
```

---

## Exercise 5 – Palindrome Checker

```java
public class Exercise05 {
    // Ask the user to enter a word.
    // Check whether it is a palindrome (same forwards and backwards) ignoring case.
    void main() {
        String word = IO.readln("Enter a word: ");              // reads the word from the user
        String lower = word.toLowerCase();                        // normalise case so "Racecar" == "racecar"

        String reversed = new StringBuilder(lower).reverse().toString(); // reverses the lowercase version

        if (lower.equals(reversed)) {                                // palindrome: original equals its reverse
            IO.println(word + " is a palindrome.");
        } else {
            IO.println(word + " is NOT a palindrome.");
        }
    }
}
```

---

## Exercise 6 – Word Counter

```java
public class Exercise06 {
    // Ask the user to enter a sentence and a word to search for.
    // Count total words and how many times the search word appears (case-insensitive).
    void main() {
        String sentence = IO.readln("Enter a sentence  : ");           // reads the full sentence
        String target = IO.readln("Enter word to find: ").toLowerCase(); // normalises search word to lowercase
        String lower = sentence.toLowerCase();                       // normalises sentence for case-insensitive search

        // --- count total words by counting spaces + 1 ---
        int wordCount = 1;                                              // at least one word if the string is non-empty
        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) == ' ') wordCount++;                // each space separates two words
        }

        // --- count occurrences using indexOf in a loop ---
        int occurrences = 0;
        int fromIndex = 0;                                           // tracks where to start the next search
        while (true) {
            int pos = lower.indexOf(target, fromIndex);                // finds next match starting from fromIndex
            if (pos == -1) break;                                      // -1 means no more occurrences found
            occurrences++;
            fromIndex = pos + target.length();                         // advance past the current match
        }

        IO.println("Total words : " + wordCount);
        IO.println("\"" + target + "\" appears: " + occurrences + " times");
    }
}
```

---

## Exercise 7 – Circle Calculator

```java
public class Exercise07 {
    // Ask the user to enter a circle radius.
    // Calculate and print the area and circumference, rounded to two decimal places.
    void main() {
        double radius = Double.parseDouble(IO.readln("Enter radius: ")); // reads radius as a double

        double area = Math.PI * Math.pow(radius, 2);       // area = π × r²
        double circumference = 2 * Math.PI * radius;                // circumference = 2 × π × r

        // Math.round(x * 100) / 100.0 rounds to two decimal places
        // dividing by 100.0 (not 100) keeps the result as a double
        double roundedArea = Math.round(area * 100) / 100.0;
        double roundedCirc = Math.round(circumference * 100) / 100.0;

        IO.println("Area         : " + roundedArea);
        IO.println("Circumference: " + roundedCirc);
    }
}
```

---

## Exercise 8 – Power Table

```java
public class Exercise08 {
    // Ask the user to enter a base number.
    // Print its powers from 1 to 10 using Math.pow.
    void main() {
        int base = Integer.parseInt(IO.readln("Enter base: "));  // reads the base as an integer

        for (int exp = 1; exp <= 10; exp++) {                    // loops exponent from 1 to 10
            double result = Math.pow(base, exp);                 // raises base to the power of exp
            IO.println(base + " ^ " + exp + " = " + result);    // prints base ^ exp = result
        }
    }
}
```

---

## Exercise 9 – Right Triangle Checker

```java
public class Exercise09 {
    // Ask the user to enter three sides of a triangle.
    // Determine the longest side and check whether it forms a right triangle
    // using the Pythagorean theorem (a² + b² = c²).
    void main() {
        double a = Double.parseDouble(IO.readln("Enter side a: ")); // reads first side
        double b = Double.parseDouble(IO.readln("Enter side b: ")); // reads second side
        double c = Double.parseDouble(IO.readln("Enter side c: ")); // reads third side

        double longest = Math.max(a, Math.max(b, c));             // finds the largest side (hypotenuse candidate)
        double hypSq = Math.pow(longest, 2);                    // square of the longest side
        double legsSq = Math.pow(a, 2) + Math.pow(b, 2) + Math.pow(c, 2) - hypSq; // sum of squares of the other two

        // floating-point arithmetic can have tiny rounding errors, so compare within a small tolerance
        boolean isRight = Math.abs(hypSq - legsSq) < 0.0001;

        IO.println("Longest side: " + longest);

        if (isRight) {
            IO.println("This IS a right triangle.");
        } else {
            IO.println("This is NOT a right triangle.");
        }
    }
}
```

---

## Exercise 10 – Number Cruncher

```java
public class Exercise10 {
    // Write static methods findMax, findMin, and average for three integers.
    // Ask the user for three numbers and print the results using those methods.

    public static int findMax(int a, int b, int c) {      // returns the largest of the three values
        return Math.max(a, Math.max(b, c));               // uses Math.max twice to compare all three
    }

    public static int findMin(int a, int b, int c) {      // returns the smallest of the three values
        return Math.min(a, Math.min(b, c));               // uses Math.min twice to compare all three
    }

    public static double average(int a, int b, int c) {   // returns the arithmetic mean as a double
        return (a + b + c) / 3.0;                         // divides by 3.0 to force a decimal result
    }

    void main() {
        int x = Integer.parseInt(IO.readln("Enter first number : "));   // reads first integer
        int y = Integer.parseInt(IO.readln("Enter second number: "));   // reads second integer
        int z = Integer.parseInt(IO.readln("Enter third number : "));   // reads third integer

        double avg = average(x, y, z);
        double roundedAvg = Math.round(avg * 100) / 100.0;             // rounds average to two decimal places

        IO.println("Maximum : " + findMax(x, y, z));
        IO.println("Minimum : " + findMin(x, y, z));
        IO.println("Average : " + roundedAvg);
    }
}
```

---

## Exercise 11 – Dice Statistics

```java
public class Exercise11 {
    // Ask the user how many times to roll two six-sided dice.
    // Print each roll and count how many times a double was rolled (both dice equal).
    void main() {
        int rolls = Integer.parseInt(IO.readln("How many rolls? ")); // total number of rolls to simulate
        int doubles = 0;                                                // counts how many rolls were doubles

        for (int i = 1; i <= rolls; i++) {
            int die1 = (int) (Math.random() * 6) + 1;  // (int)(0.0–5.999) + 1 → random 1–6
            int die2 = (int) (Math.random() * 6) + 1;  // second independent die roll
            int sum = die1 + die2;

            if (die1 == die2) {                         // both dice show the same value → double
                doubles++;
                IO.println("Roll " + i + ": " + die1 + " + " + die2 + " = " + sum + "  DOUBLE!");
            } else {
                IO.println("Roll " + i + ": " + die1 + " + " + die2 + " = " + sum);
            }
        }

        IO.println("Doubles rolled: " + doubles + " out of " + rolls);
    }
}
```

---

## Exercise 12 – Password Generator

```java
public class Exercise12 {
    // Ask the user for a password length.
    // Generate a random password using Math.random() and StringBuilder.
    // Character set: a–z (0–25), A–Z (26–51), 0–9 (52–61) → 62 characters total.
    void main() {
        int length = Integer.parseInt(IO.readln("Enter password length: ")); // reads the desired length

        StringBuilder password = new StringBuilder();   // will hold the generated password

        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * 62);      // picks a random index from 0 to 61

            char ch;
            if (index < 26) {
                ch = (char) ('a' + index);               // 0–25 → lowercase a–z
            } else if (index < 52) {
                ch = (char) ('A' + (index - 26));        // 26–51 → uppercase A–Z
            } else {
                ch = (char) ('0' + (index - 52));        // 52–61 → digits 0–9
            }

            password.append(ch);                        // appends the chosen character
        }

        IO.println("Generated password: " + password);
    }
}
```

---

## Exercise 13 – Receipt Builder

```java
public class Exercise13 {
    // Ask the user to enter item names and prices until they type "done".
    // Use StringBuilder to build and print a formatted receipt with a grand total.
    void main() {
        StringBuilder lines = new StringBuilder();  // accumulates the item lines
        double total = 0;                    // running grand total

        while (true) {
            String item = IO.readln("Enter item name (or 'done'): "); // reads item name or stop signal
            if (item.equalsIgnoreCase("done")) break;                  // stops the loop

            double price = Double.parseDouble(IO.readln("Enter price: ")); // reads item price
            total += price;                                                // adds to the running total

            lines.append(item).append("  ").append(price).append("\n");   // appends the item line
        }

        IO.println("\n==============================");
        IO.println("           Receipt");
        IO.println("==============================");
        IO.println(lines.toString().trim());         // prints all collected item lines (trim removes trailing newline)
        IO.println("------------------------------");
        IO.println("Grand Total:            " + total);
        IO.println("==============================");
    }
}
```

---

## Exercise 14 – Today's Calendar

```java
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Exercise14 {
    // Print today's date with full day name, day number, full month name, and year.
    // Also print whether it is a weekday or a weekend.
    void main() {
        LocalDate today = LocalDate.now();   // gets today's date from the system clock

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("eeee, dd MMMM yyyy"); // full date pattern
        String formatted = today.format(formatter);                                        // applies the pattern

        IO.println("Today is: " + formatted);

        DayOfWeek day = today.getDayOfWeek();                              // gets the day-of-week enum value
        if (day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY) {       // Saturday or Sunday → weekend
            IO.println("It is a Weekend.");
        } else {
            IO.println("It is a Weekday.");
        }
    }
}
```

---

## Exercise 15 – Age Calculator

```java
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Exercise15 {
    // Ask the user for their birth year, month, and day.
    // Print their current age in full years and the days remaining until their next birthday.
    void main() {
        int year = Integer.parseInt(IO.readln("Enter birth year : "));  // reads the birth year
        int month = Integer.parseInt(IO.readln("Enter birth month: "));  // reads the birth month (1–12)
        int day = Integer.parseInt(IO.readln("Enter birth day  : "));  // reads the birth day

        LocalDate birthdate = LocalDate.of(year, month, day);            // constructs the birthdate object
        LocalDate today = LocalDate.now();                           // gets today's date

        long age = ChronoUnit.YEARS.between(birthdate, today);           // full years elapsed since birth

        // try the birthday in the current year; if it has already passed, use next year
        LocalDate nextBirthday = birthdate.withYear(today.getYear());    // birthday this calendar year
        if (!nextBirthday.isAfter(today)) {                              // if today's birthday is today or has passed
            nextBirthday = nextBirthday.plusYears(1);                    // move to next year
        }

        long daysUntil = ChronoUnit.DAYS.between(today, nextBirthday);  // days from today to next birthday

        IO.println("Your age            : " + age + " years");
        IO.println("Days until birthday : " + daysUntil);
    }
}
```

---

## Exercise 16 – Event Countdown

```java
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Exercise16 {
    // Ask the user for an event name and date (yyyy-MM-dd).
    // Print days remaining if the event is in the future, or days ago if it has passed.
    void main() {
        String name = IO.readln("Enter event name: ");               // reads the event name
        String dateInput = IO.readln("Enter event date (yyyy-MM-dd): ");  // reads the date as a string
        LocalDate eventDate = LocalDate.parse(dateInput);                    // parses the ISO date string
        LocalDate today = LocalDate.now();                               // today's date

        long diff = ChronoUnit.DAYS.between(today, eventDate); // positive = future, negative = past, 0 = today

        if (diff > 0) {
            IO.println(name + " is in " + diff + " days!");              // event is upcoming
        } else if (diff < 0) {
            IO.println(name + " was " + Math.abs(diff) + " days ago."); // event has already passed
        } else {
            IO.println(name + " is today!");                             // event is happening today
        }
    }
}
```

---

## Exercise 17 – Appointment Planner

```java
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Exercise17 {
    // Ask the user to enter three appointment names and date-times (yyyy-MM-dd HH:mm).
    // Sort the appointments by date and print a formatted schedule.
    void main() {
        DateTimeFormatter inputFmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");           // for parsing input
        DateTimeFormatter outputFmt = DateTimeFormatter.ofPattern("eeee, dd MMMM yyyy 'at' HH:mm"); // for display

        // --- read the three appointments ---
        String name1 = IO.readln("Enter appointment 1 name: ");
        LocalDateTime dt1 = LocalDateTime.parse(IO.readln("Enter appointment 1 date-time (yyyy-MM-dd HH:mm): "), inputFmt);
        String name2 = IO.readln("Enter appointment 2 name: ");
        LocalDateTime dt2 = LocalDateTime.parse(IO.readln("Enter appointment 2 date-time (yyyy-MM-dd HH:mm): "), inputFmt);
        String name3 = IO.readln("Enter appointment 3 name: ");
        LocalDateTime dt3 = LocalDateTime.parse(IO.readln("Enter appointment 3 date-time (yyyy-MM-dd HH:mm): "), inputFmt);

        // --- sort three items with three conditional swaps ---
        if (dt1.isAfter(dt2)) {                             // if appointment 1 is later than 2, swap them
            LocalDateTime tmpDt = dt1;
            dt1 = dt2;
            dt2 = tmpDt;
            String tmpName = name1;
            name1 = name2;
            name2 = tmpName;
        }
        if (dt1.isAfter(dt3)) {                             // if the new first is still later than 3, swap
            LocalDateTime tmpDt = dt1;
            dt1 = dt3;
            dt3 = tmpDt;
            String tmpName = name1;
            name1 = name3;
            name3 = tmpName;
        }
        if (dt2.isAfter(dt3)) {                             // finally check positions 2 and 3
            LocalDateTime tmpDt = dt2;
            dt2 = dt3;
            dt3 = tmpDt;
            String tmpName = name2;
            name2 = name3;
            name3 = tmpName;
        }

        IO.println("\n--- Your Schedule ---");
        IO.println("1. " + name1 + " – " + dt1.format(outputFmt));
        IO.println("2. " + name2 + " – " + dt2.format(outputFmt));
        IO.println("3. " + name3 + " – " + dt3.format(outputFmt));
    }
}
```

---

## Exercise 18 – Date Range Printer

```java
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Exercise18 {
    // Ask the user for a start and end date (yyyy-MM-dd).
    // Print every date in the range (inclusive) formatted as dd/MM/yyyy (eeee).
    void main() {
        LocalDate start = LocalDate.parse(IO.readln("Enter start date (yyyy-MM-dd): ")); // parses start date
        LocalDate end = LocalDate.parse(IO.readln("Enter end date   (yyyy-MM-dd): ")); // parses end date

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy (eeee)"); // output pattern

        LocalDate current = start;                           // begin at the start date
        while (!current.isAfter(end)) {                      // keep looping until we pass the end date
            IO.println(current.format(formatter));           // prints the current date in the required format
            current = current.plusDays(1);                   // advances by one day — LocalDate is immutable so this returns a new object
        }
    }
}
```

---

## Exercise 19 – Unit Converter

```java
public class UnitConverter {
    // Three overloaded convert() methods — same name, different parameter lists.

    public static double convert(double km) {                      // kilometres → miles
        return km * 0.621371;                                      // 1 km = 0.621371 miles
    }

    public static double convert(double kg, String unit) {         // kilograms → pounds (unit = "lbs")
        return kg * 2.20462;                                       // 1 kg = 2.20462 lbs
    }

    public static double convert(double celsius, boolean toFahrenheit) { // Celsius → °F or Kelvin
        if (toFahrenheit) {
            return celsius * 9.0 / 5 + 32;                        // Celsius to Fahrenheit formula
        } else {
            return celsius + 273.15;                               // Celsius to Kelvin formula
        }
    }
}
```

```java
public class Exercise19 {
    // Ask the user to choose a unit conversion.
    // Call the appropriate overloaded UnitConverter.convert() method and print the result.
    void main() {
        IO.println("Choose conversion:");
        IO.println("1. km → miles");
        IO.println("2. kg → lbs");
        IO.println("3. °C → °F / K");
        int choice = Integer.parseInt(IO.readln("Enter choice: "));  // reads the menu selection

        if (choice == 1) {
            double km = Double.parseDouble(IO.readln("Enter value in km: "));
            double miles = UnitConverter.convert(km);                       // calls convert(double km)
            double result = Math.round(miles * 100) / 100.0;                 // rounds to two decimal places
            IO.println(km + " km = " + result + " miles");

        } else if (choice == 2) {
            double kg = Double.parseDouble(IO.readln("Enter value in kg: "));
            double lbs = UnitConverter.convert(kg, "lbs");                // calls convert(double, String)
            double result = Math.round(lbs * 100) / 100.0;
            IO.println(kg + " kg = " + result + " lbs");

        } else if (choice == 3) {
            double celsius = Double.parseDouble(IO.readln("Enter value in °C: "));
            double fahrenheit = UnitConverter.convert(celsius, true);        // calls convert(double, boolean)
            double kelvin = UnitConverter.convert(celsius, false);
            IO.println(celsius + " °C = " + Math.round(fahrenheit * 100) / 100.0 + " °F");
            IO.println(celsius + " °C = " + Math.round(kelvin * 100) / 100.0 + " K");

        } else {
            IO.println("Invalid choice.");
        }
    }
}
```

---

## Exercise 20 – Profile Card Builder

```java
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Exercise20 {
    // Ask the user for their name, birth date, city, and email.
    // Calculate their age and use StringBuilder to build a formatted profile card.

    public static String padRight(String s, int length) {  // pads a string with trailing spaces to a fixed width
        StringBuilder sb = new StringBuilder(s);
        while (sb.length() < length) sb.append(' ');       // appends spaces until the target width is reached
        return sb.toString();
    }

    void main() {
        String name = IO.readln("Enter name      : ");          // reads full name
        String birthStr = IO.readln("Enter birth date: ");          // reads birth date as yyyy-MM-dd
        String city = IO.readln("Enter city      : ");          // reads city
        String email = IO.readln("Enter email     : ");          // reads email address

        LocalDate birthdate = LocalDate.parse(birthStr);            // parses the ISO date string
        long age = ChronoUnit.YEARS.between(birthdate, LocalDate.now()); // full years elapsed since birth

        // build the card line by line using StringBuilder
        StringBuilder card = new StringBuilder();
        card.append("╔══════════════════════════════╗\n");
        card.append("║         Profile Card         ║\n");
        card.append("╠══════════════════════════════╣\n");
        card.append("║ Name  : ").append(padRight(name, 20)).append(" ║\n"); // padRight keeps columns aligned
        card.append("║ Age   : ").append(padRight(String.valueOf(age), 20)).append(" ║\n");
        card.append("║ City  : ").append(padRight(city, 20)).append(" ║\n");
        card.append("║ Email : ").append(padRight(email, 20)).append(" ║\n");
        card.append("╚══════════════════════════════╝");

        IO.println("\n" + card);
    }
}
```
