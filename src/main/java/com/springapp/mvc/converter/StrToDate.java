package com.springapp.mvc.converter;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by chj on 2016/1/29.
 */
public class StrToDate implements Converter<String,Date> {

    private Logger logger= LogManager.getLogger(StrToDate.class);

    private String formatStr;

    public StrToDate(String formatStr)
    {
        this.formatStr=formatStr;
    }

    @Override
    public Date convert(String s) {
        try
        {
            return new SimpleDateFormat(formatStr).parse(s);
        }
        catch (Exception e)
        {
            logger.error(e.getMessage());
            return null;
        }
    }
}
