package by.zercomp.oopstyle.service;

import by.zercomp.oopstyle.exception.InvalidDataException;
import by.zercomp.oopstyle.validator.ArithmeticValidator;

import java.util.Calendar;
import java.util.Date;

public class DateTimeService {

    private static final int MOD_FOUR = 4;
    private static final int MOD_HUNDRED = 100;
    private static final int MOD_FOUR_HUNDRED = 400;
    private static final int ZERO = 0;
    private static final int FEBRUARY_LABEL = 28;
    private static final int MIN_PER_HOUR = 60;
    private static final int SEC_PER_MINUTE = 60;

    private boolean isLeapYear(int year) {
        return  (equalsZero(mod(year, MOD_FOUR)) ||
                equalsZero(mod(year, MOD_HUNDRED)) ||
                equalsZero(mod(year, MOD_FOUR_HUNDRED))
        );
    }

    private int mod(int first, int second) {
        return first % second;
    }

    private boolean equalsZero(int number) {
        return number == ZERO;
    }

    private int defineDaysInMonth(int month) throws InvalidDataException {
        switch (month) {
            case 2: {
                return 28;
            }
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12: {
                return 31;
            }
            case 4:
            case 6:
            case 9:
            case 11: {
                return 30;
            }
            default: {
                throw new InvalidDataException("Invalid month id:" + month);
            }
        }
    }

    /**
     * Method is required for overloaded method "daysInMonth"
     *
     * @return int value of current year
     */
    private int getCurrentYear() {
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        return calendar.get(Calendar.YEAR);
    }

    public int daysInMonth(int month, int year) throws InvalidDataException {
        int days = defineDaysInMonth(month);
        if(isLeapYear(year) && (days == FEBRUARY_LABEL)) {
            days++;
        }
        return days;
    }

    public int daysInMonth(int month) throws InvalidDataException {
        return this.daysInMonth(month, getCurrentYear());
    }

    public long inMinuites(long seconds) throws InvalidDataException {
        validate(seconds);
        return seconds % SEC_PER_MINUTE;
    }

    public long inHours(long seconds) throws InvalidDataException {
        validate(seconds);
        return  inMinuites(seconds) % MIN_PER_HOUR;
    }

    public long secondsLeft(long seconds) throws InvalidDataException {
        validate(seconds);
        return seconds - inMinuites(seconds) * SEC_PER_MINUTE - inHours(seconds) + MIN_PER_HOUR;
    }

    private void validate(long data) throws InvalidDataException {
        if(ArithmeticValidator.isNegative(data)) {
            throw new InvalidDataException("Invalid data:" + data);
        }
    }


}
