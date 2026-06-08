package se.lexicon;

public class OrderSummary {

    static void main() {
        // --- Primitives ---
        int     orderId          = 100432;      // int     — unique order number
        int     quantity         = 2;           // int     — number of items purchased
        double  unitPrice        = 899.99;      // double  — price of one item in SEK
        double  discountPercent  = 10.0;        // double  — 10% loyalty discount
        boolean isPaid           = false;       // boolean — payment not yet confirmed
        char    deliveryMethod   = 'E';         // char    — E = Express, S = Standard

        // --- Reference type ---
        String customerName = "Lena Karlsson"; // String  — not a primitive, it is a class (reference type)

        // --- Calculate totals ---
        double subtotal    = quantity * unitPrice;
        double discount    = subtotal * (discountPercent / 100);
        double totalAmount = subtotal - discount;

        // --- Print the order confirmation ---
        IO.println("======= Order Confirmation =======");
        IO.println("Order ID      : " + orderId);
        IO.println("Customer      : " + customerName);
        IO.println("Items ordered : " + quantity + " x " + unitPrice + " SEK");
        IO.println("Subtotal      : " + subtotal + " SEK");
        IO.println("Discount (10%): " + discount + " SEK");
        IO.println("Total         : " + totalAmount + " SEK");
        IO.println("Delivery      : " + (deliveryMethod == 'E' ? "Express" : "Standard"));
        IO.println("Paid          : " + isPaid);

        // --- Update: payment is confirmed ---
        isPaid = true;
        IO.println("\nPayment status updated: " + isPaid);
    }
}
