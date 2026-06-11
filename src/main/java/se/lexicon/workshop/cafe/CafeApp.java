package se.lexicon.workshop.cafe;

public class CafeApp {


    void main() {

        // --- Challenge 1: Serve Multiple Customers ---
        // Track how many customers we've served and total money earned today
        int customersServed = 0;
        double totalRevenue = 0.0;

        // Keep the cafe open until the user types "done"
        while (true) {
            String name = IO.readln("Next customer name (or 'done' to close): ").trim();

            // .trim() removes any accidental spaces the user may have typed
            if (name.equalsIgnoreCase("done")) {
                // equalsIgnoreCase() accepts "Done", "DONE", "done", etc.
                break;
            }

            IO.println("Hi " + name + "! Here is our menu:");
            IO.println("");
            printMenu();
            IO.println("");

            // --- Challenge 2: Input Validation (not yet implemented) ---
            // Integer.parseInt() converts the typed text (String) into a whole number (int)
            int itemNumber = Integer.parseInt(IO.readln("Enter item number (1-5): ").trim());
            int quantity = Integer.parseInt(IO.readln("How many? ").trim());

            // equalsIgnoreCase("yes") means "yes", "YES", "Yes" all count as true
            boolean isMember = IO.readln("Loyalty member? (yes/no): ").trim().equalsIgnoreCase("yes");
            IO.println("");

            // Switch expression: sets both itemName and unitPrice based on the chosen number.
            // Each case uses yield to return a value out of the block.
            // The result (unitPrice) and the side-effect (itemName) are set together.
            String itemName;
            double unitPrice = switch (itemNumber) {
                case 1 -> {
                    itemName = "Espresso";
                    yield 25.00;
                }
                case 2 -> {
                    itemName = "Cappuccino";
                    yield 35.00;
                }
                case 3 -> {
                    itemName = "Latte";
                    yield 40.00;
                }
                case 4 -> {
                    itemName = "Croissant";
                    yield 30.00;
                }
                default -> {
                    // default handles any number that doesn't match cases 1-4
                    itemName = "Sandwich";
                    yield 55.00;
                }
            };

            // --- Challenge 3: Order Class ---
            // Create a new Order object and fill in its fields for this customer
            Order order = new Order();
            order.customerName = name;
            order.isMember = isMember;
            order.itemName = itemName;
            order.unitPrice = unitPrice;
            order.quantity = quantity;

            order.printReceipt();

            // ++ is shorthand for customersServed = customersServed + 1
            customersServed++;
            // += adds the order total to the running revenue total
            totalRevenue += order.calculateTotal();

            IO.println("");
        }

        printEndOfDayReport(customersServed, totalRevenue);
    }

    static void printMenu() {
        IO.println("==============================");
        IO.println("Lexicon Cafe");
        IO.println("==============================");
        // String.format() builds a formatted string:
        //   %d   = integer (item number)
        //   %-17s = left-aligned text padded to 17 characters (item name)
        //   %.2f = decimal number with exactly 2 decimal places (price)
        IO.println(String.format("%d. %-17s%.2f SEK", 1, "Espresso", 25.00));
        IO.println(String.format("%d. %-17s%.2f SEK", 2, "Cappuccino", 35.00));
        IO.println(String.format("%d. %-17s%.2f SEK", 3, "Latte", 40.00));
        IO.println(String.format("%d. %-17s%.2f SEK", 4, "Croissant", 30.00));
        IO.println(String.format("%d. %-17s%.2f SEK", 5, "Sandwich", 55.00));
        IO.println("==============================");
    }

    // --- Challenge 1: End-of-Day Report ---
    static void printEndOfDayReport(int customersServed, double totalRevenue) {
        IO.println("==============================");
        IO.println("END OF DAY REPORT");
        IO.println("==============================");
        // %-17s pads the label to 17 chars so the colons line up neatly
        IO.println(String.format("%-17s: %d", "Customers served", customersServed));
        IO.println(String.format("%-17s: %.2f SEK", "Total revenue", totalRevenue));
        IO.println("==============================");
    }


}