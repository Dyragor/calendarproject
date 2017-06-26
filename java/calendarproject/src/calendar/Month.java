package calendar;

/**
 * Created by 5ia15anschranz on 26.06.2017.
 */
public enum Month {
    JANUARY, FEBRUARY, MARS, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER;
    public static int faerbung(Month month){
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
}
