package pers.lls.regular;

import org.joda.time.DateTime;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则
 */
public class RegularDemo {

    public static final Pattern TABLE_NAME_PATTERN = Pattern.compile("\\s+(between|BETWEEN)\\s+'([^\\s]*)'\\s+(and|AND)\\s+'([^\\s]*)'");
    public static final Pattern TABLE_NAME_PATTERN2 = Pattern.compile("\\s+from\\s+([^\\s]*)[\\r\\n\\s]*");

    private String innerSQLQuery(String sql) {
        Matcher matcher = TABLE_NAME_PATTERN2.matcher(sql);
            if (matcher.find()) {
                return matcher.group(1);
            }
        return "resutRows";
    }

    public static void main(String[] args) {
        System.out.println(new RegularDemo().innerSQLQuery("select * from `交易模型` where ts_end between 'now-10d' and 'now';"));
//        System.out.println(new RegularDemo().parse("2021-07-07 11:34:00",
//                "yyyy-MM-dd HH:mm:ss" , new Date().getTime()));
    }

    public String parse(String text,String format,long now) {
        return new DateTime(text).toString(format);
    }
}
