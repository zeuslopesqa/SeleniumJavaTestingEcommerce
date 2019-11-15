package utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class TimeGenerator {
    public static String dataTimeToArchive(){
        //Using timestamp class to catch time to use in file name.
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        return new SimpleDateFormat("yyyyMMddhhmmss").format(ts);
    }
}
