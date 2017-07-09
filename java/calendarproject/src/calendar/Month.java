package calendar;

/**
 *  Calendarproject
 *
 * @author Simon Kunz, Andreas Schranz
 * @version 1.0
 *
 */
public enum Month {
    JANUARY, FEBRUARY, MARS, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER;

    public static int length(Month month){
        switch (month){
            case JANUARY:
                return 31;
            case FEBRUARY:
                return 28;
            case MARS:
                return 31;
            case APRIL:
                return 30;
            case MAY:
                return 31;
            case JUNE:
                return 30;
            case JULY:
                return 31;
            case AUGUST:
                return 31;
            case SEPTEMBER:
                return 30;
            case OCTOBER:
                return 31;
            case NOVEMBER:
                return 30;
            case DECEMBER:
                return 31;
            default:
                return 0;
        }
    }
    public static int sequence(Month month){
        switch (month){
            case JANUARY:
                return 1;
            case FEBRUARY:
                return 2;
            case MARS:
                return 3;
            case APRIL:
                return 4;
            case MAY:
                return 5;
            case JUNE:
                return 6;
            case JULY:
                return 7;
            case AUGUST:
                return 8;
            case SEPTEMBER:
                return 9;
            case OCTOBER:
                return 10;
            case NOVEMBER:
                return 11;
            case DECEMBER:
                return 12;
            default:
                return 0;
        }
    }
}
