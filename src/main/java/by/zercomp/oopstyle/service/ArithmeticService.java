package by.zercomp.oopstyle.service;

import by.zercomp.oopstyle.validator.ArithmeticValidator;

public class ArithmeticService {

    private static final int MOD_TEN = 10;
    public static final int EVEN_COUNT = 2;

    public int identifyLastDigitOfSqr(int number) {
        final int lastDigit = number % MOD_TEN;
        return (lastDigit * lastDigit) % MOD_TEN;
    }

    public boolean atLeastTwoEvens(int... array) {
        int counter = 0;
        for (int value : array) {
            if (ArithmeticValidator.isEven(value)) {
                counter++;
                if (counter == EVEN_COUNT) {
                    return true;
                }
            }
        }
        return false;
    }


}
