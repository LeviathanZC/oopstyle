package by.zercomp.oopstyle.service;

import by.zercomp.oopstyle.validator.ArithmeticValidator;

public class ArithmeticService {

    private static final int MOD_TEN = 10;
    private static final int EVEN_COUNT = 2;

    /**
     * Task 1 method
     * @param number - number
     * @return last digit of square of number
     */
    public int identifyLastDigitOfSqr(int number) {
        final int lastDigit = number % MOD_TEN;
        return (lastDigit * lastDigit) % MOD_TEN;
    }

    /**
     * Task 4
     * @param array - 4 numbers [A B C D]
     * @return true if at least two numbers are even. false - in other cases.
     */
    public boolean atLeastTwoEvens(int... array) {
        int counter = 0;
        for (int value : array) {
            if (ArithmeticValidator.isEven(value)) {
                if (++counter == EVEN_COUNT) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Task5
     * @param number number
     * @return true if number is perfect, false in other cases.
     */
    public boolean isPerfect(int number) {
        boolean isPerfect = false;
        int sum = 0;
        int i;
        for (i = 1; i < number; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        isPerfect = sum == number;
        return isPerfect;
    }

}
