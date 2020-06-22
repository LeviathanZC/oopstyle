package by.zercomp.oopstyle.service;

import by.zercomp.oopstyle.exception.InvalidDataException;
import by.zercomp.oopstyle.validator.ArithmeticValidator;

public class ArithmeticService {

    private static final int MOD_TEN = 10;
    private static final int EVEN_COUNT = 2;

    /**
     * Task 1 method
     *
     * @param number - number
     * @return last digit of square of number
     */
    public int identifyLastDigitOfSqr(int number) {
        final int lastDigit = number % MOD_TEN;
        return (lastDigit * lastDigit) % MOD_TEN;
    }

    /**
     * Task 4
     *
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
     *
     * @param number number
     * @return true if number is perfect, false in other cases.
     */
    public boolean isPerfect(int number) {
        int sum = 0;
        int i;
        for (i = 1; i < number; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        return sum == number;
    }

    /**
     * Task 8
     * @param variable - x
     * @return result of calculating a given function
     * @throws InvalidDataException if x is infinite or not a number
     */
    public double calcFunction(double variable) throws InvalidDataException{
        if(Double.isInfinite(variable) || Double.isNaN(variable)) {
            throw new InvalidDataException("Given double value is invalid:" + variable);
        }
        final double constraint = 3;
        if(Double.compare(variable, 3) < 0) {
            return whenLessThenThree(variable);
        }
        return whenMoreOrEqualThree(variable);
    }

    private double whenMoreOrEqualThree(double x) {
        return -(x * x) + 3 * x + 9;
    }

    private double whenLessThenThree(double x) {
        return 1 / ((x * x * x) - 6);
    }


}
