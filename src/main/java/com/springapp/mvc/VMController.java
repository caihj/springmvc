package com.springapp.mvc;

import com.springapp.mvc.pojo.Animal;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.tools.generic.DateTool;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chj on 2016/2/2.
 */
@Controller
@RequestMapping("/vm")
public class VMController {

    private Logger logger= LogManager.getLogger(VMController.class);

    @RequestMapping(value = "/getpage",method = RequestMethod.GET)
    public String getPage(Model model,HttpServletRequest request)
    {
        request.getSession().setAttribute("id","111");
        model.addAttribute("message","hello");
        return "/firstVM";
    }

    @RequestMapping(value="/getjson",method = RequestMethod.GET)
    public Animal getjson(HttpServletRequest request) throws Exception
    {
        logger.info("{} getjson", Thread.currentThread().getId());

        Animal a=new Animal();

        a.setName("panda熊猫"+request.getSession().getAttribute("id"));
        a.setWeight(100);;

        return a;
    }

    @RequestMapping(value="/getjson2",method = RequestMethod.GET)
    public List getjson2() throws Exception
    {
        List a=new ArrayList<String>();

        a.add("name");


        return a;
    }
}
