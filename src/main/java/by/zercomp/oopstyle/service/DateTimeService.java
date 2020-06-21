package by.zercomp.oopstyle.service;

import java.util.Calendar;
import java.util.Date;

public class DateTimeService {

    public static final int MOD_FOUR = 4;
    public static final int MOD_HUNDRED = 100;
    public static final int MOD_FOUR_HOUNDRED = 400;
    public static final int ZERO = 0;

    private boolean isLeapYear(int year) {
        if (equalsZero(mod(year, MOD_FOUR)) ||
                equalsZero(mod(year, MOD_HUNDRED)) ||
                equalsZero(mod(year, MOD_FOUR_HOUNDRED))
        ) {
            return true;
        }
        return false;
    }

    private int mod(int first, int second) {
        return first % second;
    }

    private boolean equalsZero(int number) {
        return number == ZERO;
    }

    private int defineDaysInMonth(int month) {
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
            default: {
                return 30;
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

    public int daysInMonth(int month, int year) {

    }


    public int daysInMonth(int month) {
        return this.daysInMonth(month, getCurrentYear());
    }


}
