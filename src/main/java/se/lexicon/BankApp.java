package se.lexicon;

public class BankApp {

    void main() {
        BankAccount account1 = new BankAccount();
        account1.accountHolder = "Alice";
        account1.deposit(1000);
        // interestRate = 4.5

        IO.println(LoanUtil.interestRate);

        BankAccount account2 = new BankAccount();
        account2.accountHolder = "Bob";
        account2.deposit(500);
        // interestRate = 4.5

        IO.println(LoanUtil.interestRate);
        IO.println(LoanUtil.calculateLoanRepayment(1000, 5));
    }
}
