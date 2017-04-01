package gmail.dimon0272.WebApp.tools;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Created by User on 04.03.2017.
 */
public class DateConverter {
    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    public static final DateFormat OLD_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");

    public static  Date convertStringToDate(String stringDate){
        Date result = null;
        try {
            result = DATE_FORMAT.parse(stringDate);
        }catch (ParseException e){
            e.printStackTrace();
        }
        return result;
    }

    public static Date convertToPattern(String stringDate){
        Date date = null;
        String result = null;
        try {
            date = OLD_DATE_FORMAT.parse(stringDate);
            result = DATE_FORMAT.format(date);
        }catch(ParseException e){
            e.printStackTrace();
        }
        Date resultDate = convertStringToDate(result);
        return resultDate;
    }

    public static Date convertToDateTime(String stringDate){
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        Date date = null;
        try {
            date = formatter.parse(stringDate);
        }catch (ParseException e){
            e.printStackTrace();
        }
        return date;
    }
}
