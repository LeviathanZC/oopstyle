package by.zercomp.oopstyle.validator;

public class ArithmeticValidator {

    private ArithmeticValidator() {

    }

    public static boolean isPositive(double number) {
        return number > 0;
    }

    public static boolean isNegative(double number) {
        return number < 0;
    }

}
