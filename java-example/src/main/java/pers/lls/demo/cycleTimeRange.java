package pers.lls.demo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 */
public class cycleTimeRange {
    public static void main(String[] args) {
        System.out.println(new cycleTimeRange().inTimeOfDay("15:00-16:30/", new Date(1597912151000L)));
    }

    boolean inTimeOfDay(String timeOfDay, Object time) {
        if (time instanceof Long)
            time = new Date((Long)time);
        if (time == null) return false;

        String[] timeString = timeOfDay.split("/");

        return checkDay(timeString[0], time) && checkWeek(timeString[1], time);
    }

    private boolean checkWeek(String s, Object time) {
        Calendar cal = Calendar.getInstance();
        cal.setTime((Date)time);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 2;
        if (w < 0)
            w += 7;
        return s.contains(String.valueOf(w));
    }

    private boolean checkDay(String s, Object time) {
        String[] minString = s.split("-");
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        long time1 = 0L;
        long time2 = 0L;
        long time3 = 0L;
        try {
            Date startmin = sdf.parse(minString[0]);
            Date endmin = sdf.parse(minString[1]);
            Date now = sdf.parse(sdf.format((Date)time));
            time1 = now.getTime();
            time2 = startmin.getTime();
            time3 = endmin.getTime();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (time2 < time3)
            return time1 > time2 && time1 < time3;
        else
            return time1 > time2 || time1 < time3;
    }


}
