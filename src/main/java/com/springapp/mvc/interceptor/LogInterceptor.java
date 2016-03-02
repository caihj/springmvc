package com.springapp.mvc.interceptor;

import com.alibaba.fastjson.JSON;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.AsyncHandlerInterceptor;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;


/**
 * Created by chj on 2016/2/2.
 */
public class LogInterceptor implements HandlerInterceptor {


    private Logger logger= LogManager.getLogger(LogInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {



        Enumeration<String> names = request.getHeaderNames();
        while(names.hasMoreElements())
        {

            String name=names.nextElement();
            logger.info("{}:{}",name,request.getHeader(name));
        }

        return true;
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
