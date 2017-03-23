package gmail.dimon0272.WebApp.tools;

import java.time.Duration;

/**
 * Created by User on 04.03.2017.
 */
public class DurationConverter {
    private static String durationFormat = "kk:mm";

    private static char[] timeChars = {'H', 'M', 'S'};

    public static Duration toDuration(String stringDuration) {
        Duration result = null;

        if (stringDuration != null && !stringDuration.isEmpty()) {
            int parts = durationFormat.split(":").length;
            String[] fields = stringDuration.split(":", parts);

            if (fields.length >= 2) {
                StringBuilder builder = new StringBuilder("PT");
                for (int i = 0; i < parts; i++) {
                    builder.append(fields[i]).append(timeChars[i]);
                }

                result = Duration.parse(builder.toString());

            }
        }
        return result;
    }


    public static String toString(Long durationInMilliseconds) {
        Duration duration = Duration.ofMillis(durationInMilliseconds);
        String result;
        if(String.valueOf(duration.toHours()).toCharArray().length < 2){
            result = "0" + String.valueOf(duration.toHours() + ":" + duration.toMinutes() % 60);
            if(String.valueOf(duration.toMinutes() % 60).toCharArray().length<2) {
                result = "0" + String.valueOf(duration.toHours() + ":" + "0" + duration.toMinutes() % 60);
            }
        } else if(String.valueOf(duration.toMinutes() % 60).toCharArray().length<=2){
            result =  String.valueOf(duration.toHours() + ":" + "0" + duration.toMinutes() % 60);
        }else{
            result = String.valueOf(duration.toHours() + ":" + duration.toMinutes() % 60);
        }
        return result;
    }
}
