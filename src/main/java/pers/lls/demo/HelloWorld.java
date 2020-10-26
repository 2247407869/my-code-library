package pers.lls.demo;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 */
public class HelloWorld {

    private final static Logger logger = LoggerFactory.getLogger(HelloWorld.class);
    private static List<SimpleDateFormat> allSdfs = new ArrayList<>();

    private static Date getSimpleDate(String date){
        if(allSdfs.size()==0){
            List<SimpleDateFormat> dateForms = new ArrayList<>();
            for (DateFormEnum dateForm : DateFormEnum.values()) {
                dateForms.add(new SimpleDateFormat(dateForm.getCode()));
            }
            allSdfs = dateForms;
        }
        for (SimpleDateFormat sdf : allSdfs) {
            try {
                Date date1 =sdf.parse(date);
                logger.debug("date1:"+date1);
                return date1;
            } catch (ParseException e) {
                logger.warn(e.getMessage(), e);
            }
        }
        return new Date();
    }

    private static class ReaderThread extends Thread {
        public void run() {
            System.out.println(HelloWorld.getSimpleDate("2020-10-14 01:37:00"));
        }
    }

    public static void main(String[] args) {
        String dateFormat="ss mm HH dd MM ? yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        System.out.println(JSONObject.toJSONString(sdf));
    }


}
