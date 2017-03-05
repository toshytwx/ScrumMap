package gmail.dimon0272.WebApp.tools;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by User on 04.03.2017.
 */
public class DateConverter {
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    public static  Date convertStringToDate(String stringDate){
        Date result = null;
        try {
            result = DATE_FORMAT.parse(stringDate);
        }catch (ParseException e){
            e.printStackTrace();
        }
        return result;
    }
}
