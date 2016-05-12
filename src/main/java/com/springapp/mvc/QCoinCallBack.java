package com.springapp.mvc;

import com.alibaba.fastjson.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by chj on 2016/5/12.
 */
@Controller

public class QCoinCallBack {

    private Logger logger = LogManager.getLogger(QCoinCallBack.class);
    @RequestMapping("/qcoinback")
    public void back(HttpServletRequest request){

        logger.info("收到回调");

        Map<String,String [] >  params = request.getParameterMap();

        for( Map.Entry<String ,String []> kv : params.entrySet() ){

            logger.info("key:{} value:{}",kv.getKey(), JSONObject.toJSONString(kv.getValue()));
        }

    }
}
