package utilities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtils {
    public static String returnNextMonth(){
        Date date = new Date();

        Calendar calendar = new GregorianCalendar();

        calendar.setTime(date);

        SimpleDateFormat sdf = new SimpleDateFormat("MMM-yyyy");
        calendar.add(Calendar.MONTH, 1);

        String da = sdf.format(calendar.getTime());
        return da;
    }
}
