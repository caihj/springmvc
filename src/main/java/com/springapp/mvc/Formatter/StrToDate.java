package com.springapp.mvc.Formatter;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by chj on 2016/1/29.
 */
public class StrToDate implements Formatter<Date> {

    private String dateformat;



    @Override
    public Date parse(String s, Locale locale) throws ParseException {
        return new SimpleDateFormat(dateformat).parse(s);
    }

    @Override
    public String print(Date date, Locale locale) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
    }




    public String getDateformat() {
        return dateformat;
    }

    public void setDateformat(String dateformat) {
        this.dateformat = dateformat;
    }
}
