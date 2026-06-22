package se.lexicon;


import java.util.Arrays;

public class ArrayDemo {
    void main() {

        // 1. Declaration
        int[] numbers;  // Declares an array of integers
        String[] names; // Declares an array of Strings

        // 2. Initialization with Size
        // An array is a **fixed-size** data structure and cannot be resized once initialized.
        numbers = new int[3]; // Creates an array of size 3 with default values [0, 0, 0]

        //   Visual representation of 'numbers' array:
        //   | Index | 0 | 1 | 2 |
        //   |-------|---|---|---|
        //   | Value | 0 | 0 | 0 |

        // 3. Combined Declaration and Initialization
        String[] stringArray = new String[3]; // [null, null, null]

        // 4. Initializing with Specific Values
        int[] numbersArr = {2, 4, 6, 8}; // Shortened syntax (initializes and assigns values)

        // 5. Accessing and Modifying Elements
        String[] students = {"Fredrik", "Erik", "Jonas"};

        //    Visual representation of 'students' array:
        //    | Index |     0     |    1   |    2    |
        //    |-------|-----------|--------|---------|
        //    | Value | "Fredrik" | "Erik" | "Jonas" |

        IO.println(students[0]); // Output: Fredrik
        IO.println(students[2]); // Output: Jonas

        // [WARNING]
        // Accessing an index outside the range 0 to length - 1 throws an ArrayIndexOutOfBoundsException.
        // IO.println(students[3]); // This would throw an exception

        // Two-Dimensional Array (2D Array)
        // A 2D array can be thought of as an array of arrays, or a table with rows and columns.
        int[][] matrix = {
                {1, 2, 3}, // Row 0
                {4, 5, 6}, // Row 1
                {7, 8, 9}  // Row 2
        };

        /*
           Visual representation of 'matrix' (2D array):
           Column:   0   1   2
           Row 0:  | 1 | 2 | 3 |
           Row 1:  | 4 | 5 | 6 |
           Row 2:  | 7 | 8 | 9 |
        */

        // Accessing elements in a 2D array:
        // Use matrix[rowIndex][columnIndex]
        int element = matrix[1][2]; // Accesses Row 1, Column 2 -> 6
        IO.println("Element at [1][2]: " + element);

        // Modifying elements:
        matrix[0][0] = 10; // Changes Row 0, Column 0 from 1 to 10


        //arrayIterationExample();
        expandingArray();
        expandingArrayUsingCopyOf();
        findMaxNumber(new int[]{2, 5, 80, 1, 9});

    }


    public static void arrayIterationExample() {
        int[] numbers = {5, 2, 3, 4, 7};
        IO.println("Iterating using index-based for loop:");
        for (int i = 0; i < numbers.length; i++) {
            //IO.println(numbers[i]);
            if (i == 2) {
                numbers[i] = 200;
            }
        }
        IO.println(Arrays.toString(numbers));

        IO.println("Iterating using enhanced for loop:");
        for (int number : numbers) {
            //IO.println(number);
            if (number == 5) {
                number = 500;
            }
        }
        IO.println(Arrays.toString(numbers));


    }

    public static void expandingArray() {
        int[] originalArray = {2, 5, 8, 1, 9}; // [2, 5, 8, 1, 9]
        int newElement = 40;
        int[] expandedArray = new int[originalArray.length + 1];
        /*
           Visual representation of 'expandedArray' (initially):
           | Index | 0 | 1 | 2 | 3 | 4 | 5 |
           |-------|---|---|---|---|---|---|
           | Value | 2 | 5 | 8 | 1 | 9 | 40 |
        */
        for (int i = 0; i < originalArray.length; i++) {
            expandedArray[i] = originalArray[i];
        }
        expandedArray[expandedArray.length - 1] = newElement;

        IO.println("Original Array: " + Arrays.toString(originalArray));
        IO.println(Arrays.toString(expandedArray));

    }

    public static void expandingArrayUsingCopyOf() {
        int[] originalArray = {2, 5, 8, 1, 9};
        int newElement = 40;

        // Arrays.copyOf() creates a new array and copies existing elements
        int[] expandedArray = Arrays.copyOf(originalArray, originalArray.length + 1);

        /*
           Visual representation of 'expandedArray' (after Arrays.copyOf):
           | Index | 0 | 1 | 2 | 3 | 4 | 5 |
           |-------|---|---|---|---|---|---|
           | Value | 2 | 5 | 8 | 1 | 9 | 0 |
        */

        // Add the new element to the last position
        expandedArray[expandedArray.length - 1] = newElement;

        /*
           Visual representation of 'expandedArray' (final state):
           | Index | 0 | 1 | 2 | 3 | 4 |  5  |
           |-------|---|---|---|---|---|-----|
           | Value | 2 | 5 | 8 | 1 | 9 | 40  |
        */

        IO.println("Expanded (Arrays.copyOf): " + Arrays.toString(expandedArray));
    }

    public static int findMaxNumber(int[] numbers) { // [2, 5, 8, 1, 9]

        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("numbers array cannot be null or empty");
        }

        int maxNumber = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > maxNumber) {
                maxNumber = numbers[i];
            }
        }
        IO.println("Max number: " + maxNumber);
        return maxNumber;
    }
}
