package com.springapp.mvc.Beans;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * Created by chj on 2016/3/16.
 */


public class TestBeans implements  InitializingBean {


    private Logger logger= LogManager.getLogger(TestBeans.class);

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.debug("TestBeans","inited");
    }
}
