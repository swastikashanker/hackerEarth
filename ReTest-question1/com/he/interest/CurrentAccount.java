package PractiseTest2_java.com.he.interest;

import java.util.Arrays;

public class CurrentAccount extends BankAccount{

    public CurrentAccount(Double amount, Double rateOfInterest, Transaction... transactions) {
        super(amount, rateOfInterest, Arrays.asList(transactions));
    }

    @Override
    public Double getInterest(Integer duration) {
        Double interest = 0d;
        Double P = getAmount();
        Double r = getRateOfInterest();
        int N = 12;
        interest = (P * Math.pow((1 + (r / N)), (N * duration))) -P;

        return interest;    }
}
