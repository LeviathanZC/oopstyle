package by.zercomp.oopstyle.service;

public class ArithmeticService {

    private static final int MOD_TEN = 10;





    public int identifyLastDigitOfSqr(int number) {
        final int lastDigit = number % MOD_TEN;
        return (lastDigit * lastDigit) % MOD_TEN;
    }





}
