package se.lexicon;

public class BankAccount {
    String accountHolder;
    double balance;


    void deposit(double amount) {
        balance += amount;
        IO.println("Deposited " + amount + " to account " + accountHolder);
    }



}
