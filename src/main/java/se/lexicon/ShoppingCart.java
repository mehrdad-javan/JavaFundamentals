package se.lexicon;

public class ShoppingCart {
    
    // 1. Class-Level Scope (Instance Field)
    //    Accessible from any method in this class
   double totalPrice;

    void addItem(String itemName, double price) {
        // 2. Method-Level Scope (Parameter & Local Variable)
        //    'itemName', 'price', and 'discount' only exist inside this method
        double discount = price * 0.1;
        double finalPrice = price - discount;

        if (finalPrice > 0) {
            // 3. Block-Level Scope
            //    'message' only exists inside this if-block
            String message = "Added: " + itemName + " for " + finalPrice;
            IO.println(message); // OK
        }
        // IO.println(message); // ERROR: 'message' is out of scope here

        totalPrice += finalPrice; // OK: 'totalPrice' is class-level, accessible here
    }

    void printTotal() {
        // IO.println(finalPrice); // ERROR: 'finalPrice' belongs to addItem(), not here
        IO.println("Total: " + totalPrice); // OK: class-level field is accessible
    }


    void main(){
        ShoppingCart cart1 = new ShoppingCart();
        cart1.addItem("Book", 80.00);
        cart1.addItem("Pen", 20.00);
        cart1.printTotal();
    }
}