package util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by Administrator on 2017/6/27 0027.
 */
public class EmpUtil {

    public static String getEmpid() {
        Date time = new Date(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String current = sdf.format(time);
        Random random = new Random();
        int i = random.nextInt(900) + 100;
        return current + i;
    }

    public static String getHiredate() {
        Date time = new Date(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String current = sdf.format(time);
        return current;
    }

}
