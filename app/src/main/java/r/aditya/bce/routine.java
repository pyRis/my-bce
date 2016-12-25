package r.aditya.bce;

import java.util.Calendar;

/**
 * Created by pyRis on 03/12/16.
 */

public class routine {

    /*I Don't know what I am doing. If you don't either, Leave this code intact or increment
     the count after the unsuccessful attempt.
    Count = 1;
     */

    Calendar calendar = Calendar.getInstance();
    int day = calendar.get(Calendar.DAY_OF_WEEK);

    public static int getDayName(int day) {
        switch (day) {
            case 0:
                return 0;
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            case 5:
                return 5;
            case 6:
                return 6;
        }
        return -1;
    }

}
