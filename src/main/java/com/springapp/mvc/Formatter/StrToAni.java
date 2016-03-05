package com.springapp.mvc.Formatter;

import com.alibaba.fastjson.JSONObject;
import com.springapp.mvc.pojo.Animal;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

/**
 * Created by chj on 2016/1/29.
 */
public class StrToAni implements Formatter<Animal> {

    @Override
    public Animal parse(String text, Locale locale) throws ParseException {
        return JSONObject.parseObject(text, Animal.class);
    }


    @Override
    public String print(Animal object, Locale locale) {
        return JSONObject.toJSONString(object);
    }
}
