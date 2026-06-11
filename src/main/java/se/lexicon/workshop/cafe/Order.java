package se.lexicon.workshop.cafe;

// --- Challenge 3: Order Class ---
// All order data and calculations live here so main() only coordinates.
public class Order {

    String customerName;
    boolean isMember;
    String itemName;
    double unitPrice;
    int quantity;


    double calculateSubtotal() {
        return unitPrice * quantity;
    }

    double calculateDiscount() {
        final double memberDiscountRate = 0.15;
        final double largeOrderDiscountRate = 0.10;
        final double largeOrderThreshold = 150.0;

        double subtotal = calculateSubtotal();
        // Member discount takes priority; only one rule ever applies
        if (isMember) {
            return subtotal * memberDiscountRate;
        }
        if (subtotal > largeOrderThreshold) {
            return subtotal * largeOrderDiscountRate;
        }
        return 0.0;
    }

    double calculateVat() {
        final double vatRate = 0.12;

        // VAT is applied after the discount, not on the original subtotal
        double afterDiscount = calculateSubtotal() - calculateDiscount();
        return afterDiscount * vatRate;
    }

    double calculateTotal() {
        return calculateSubtotal() - calculateDiscount() + calculateVat();
    }

    void printReceipt() {
        double subtotal = calculateSubtotal();
        double discount = calculateDiscount();
        double vat = calculateVat();
        double total = calculateTotal();

        IO.println("==============================");
        IO.println("LEXICON CAFE");
        IO.println("==============================");
        IO.println(String.format("%-10s: %s", "Customer", customerName));
        IO.println(String.format("%-10s: %s x %d", "Item", itemName, quantity));
        IO.println(String.format("%-10s: %.2f SEK", "Subtotal", subtotal));
        if (discount > 0) {
            IO.println(String.format("%-10s: -%.2f SEK", "Discount", discount));
        }
        IO.println(String.format("%-10s: %.2f SEK", "VAT", vat));
        IO.println("------------------------------");
        IO.println(String.format("%-10s: %.2f SEK", "TOTAL", total));
        IO.println("==============================");
        IO.println("   Thank you, " + customerName + "!");
        IO.println("   See you next time.");
        IO.println("==============================");
    }

}
