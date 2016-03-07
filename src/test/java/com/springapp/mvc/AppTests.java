package com.springapp.mvc;

import com.alibaba.fastjson.JSONObject;


import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.web.context.WebApplicationContext;

import java.io.InputStream;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml")
public class AppTests {
    private MockMvc mockMvc;

    @Autowired
    protected WebApplicationContext wac;

    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(this.wac).build();
    }

    @Test
    public void simple() throws Exception {

        MvcResult result=mockMvc.perform(get("/hello")).andDo(MockMvcResultHandlers.print()).andReturn();

        System.out.println(result.getResponse().getForwardedUrl());


        Map<String,Object> map=mockMvc.perform(get("/vm/getpage")).andDo(MockMvcResultHandlers.print()).andReturn().getModelAndView().getModel();

        for (Map.Entry item:map.entrySet())
        {
            System.out.println(item);
        }

        Object a=mockMvc.perform(get("/vm/getjson")).andDo(MockMvcResultHandlers.print()).andReturn().getResponse();
        System.out.println(a.toString());



    }


    @Test
    public void simple2() throws Exception {

        MockHttpServletResponse rsp=mockMvc.perform(get("/vm/getpage")).andDo(MockMvcResultHandlers.print()).andReturn().getResponse();

        System.out.println("rsp is " + rsp.getContentAsString());



//        HttpClient httpclient = new DefaultHttpClient();
//        HttpGet httpget = new HttpGet("http://localhost:8080/hello");
//        System.out.println(JSONObject.toJSONString(httpget.getAllHeaders()));
//        org.apache.http.HttpResponse rsp=httpclient.execute(httpget);
//        while(rsp.getEntity().getContent().available()>0)
//        {
//            System.out.write(rsp.getEntity().getContent().read());
//        }

    }





    @Test
    public void simple3() throws Exception
    {

        String url = "http://10.2.13.178:8085/";
        String param = "action=compile&" +
                "applicationFlag=jenkins&project=berbon&code=9999.0" +
                "&debug=true&sourceFile=123.zip&host=bbgw.berbon.com:80&" +
                "channels=10,27,58&versionCode=1.3.0&callback=compileCallback" +
                "&readyToAppStore=false";

        HttpClient httpclient = new DefaultHttpClient();
        // 创建Get方法实例
        HttpGet httpgets = new HttpGet(url+"?"+param);


        HttpResponse response=null;
        try
        {

            response = httpclient.execute(httpgets);
        }
        catch (ClientProtocolException e)
        {
            System.out.println("异常"+e.getMessage());
        }


        InputStream in=response.getEntity().getContent();


        while(in.available()>0)
        {
            int a=in.read();
            System.out.write(a);
        }
    }

    @Test
    public void simple4() throws Exception
    {
        HttpClient httpclient = HttpClients.custom().build();
        HttpGet httpget = new HttpGet("http://www.baidu.com");

        org.apache.http.HttpResponse rsp=httpclient.execute(httpget);


        while(rsp.getEntity().getContent().available()>0)
        {
            System.out.write(rsp.getEntity().getContent().read());
        }


    }

    @Test
    public void IntegerTest()
    {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;

        System.out.println(c+0==d+0);
        System.out.println(e+0==f+0);
        System.out.println(c+0==(a+b)+0);
        System.out.println(c.equals(a+b));


        System.out.println(g.intValue()==(a+b));

        System.out.println(g==(a+b));
    }


}
