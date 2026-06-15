package se.lexicon;

public class LoanUtil {
    static double interestRate = 4.5;


    static void setInterestRate(double interestRate) {
        LoanUtil.interestRate = interestRate;
    }

    static double calculateLoanRepayment(double amount, int years) {
        return amount + (amount * (interestRate / 100) * years);
    }

}
