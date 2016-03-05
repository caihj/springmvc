package com.springapp.mvc.view;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;
import  org.springframework.web.servlet.ViewResolver;
import java.util.Locale;

/**
 * Created by fighter on 3/1/16.
 */
@Component
public class ViewResolverDispatcher implements ViewResolver {

    private Logger logger= LogManager.getLogger();

    //@Autowired
    //private org.springframework.web.servlet.view.velocity.VelocityViewResolver view;


    @Override
    public View resolveViewName(String viewName, Locale locale) throws Exception {

//        logger.error(" resolver view "+viewName);
//        return view.resolveViewName(viewName,locale);

        return new SimpleView();

    }
}
