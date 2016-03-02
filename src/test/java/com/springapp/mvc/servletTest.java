package com.springapp.mvc;

import java.io.PrintWriter;
import java.io.Writer;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import junit.framework.Assert;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.DispatcherServlet;
import servlet.FirstServlet;
import servletContainter.HttpRequestFactory;
import servletContainter.HttpResponseFactory;

import static org.easymock.EasyMock.*;

/**
 * Created by chj on 2016/2/4.
 */


@RunWith(JUnit4.class)
public class servletTest extends TestCase {


    @Test
    public void test() throws Exception {


        DispatcherServlet servlet = new DispatcherServlet();

        servlet.init();
        servlet.init(servlet);

        HttpServletRequest request= HttpRequestFactory.newGet("/");
        HttpServletResponse rsp= HttpResponseFactory.newResponse();

        servlet.service(request, rsp);
        rsp.getWriter().flush();

    }


    @Test
    public void myTest() throws Exception
    {

        FirstServlet servlet=new FirstServlet();



        servlet.init();
        servlet.init(null);

        HttpServletRequest request= HttpRequestFactory.newGet("/");
        HttpServletResponse rsp= HttpResponseFactory.newResponse();

        servlet.service(request, rsp);

        rsp.getWriter().flush();


    }

    @Test
    public void tt() throws  Exception
    {
        //System.out.write("hello".getBytes());
        PrintWriter writer=new PrintWriter(System.out);
        writer.println("hello");
        writer.flush();
    }
}
