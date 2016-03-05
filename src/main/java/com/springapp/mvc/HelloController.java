package com.springapp.mvc;

import com.springapp.mvc.pojo.Animal;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import javax.xml.bind.JAXBException;
import javax.xml.bind.PropertyException;
import javax.xml.bind.ValidationEventHandler;
import javax.xml.bind.Validator;
import java.util.*;

import org.apache.commons.fileupload.FileItemFactory;

@Controller
public class HelloController {

    @RequestMapping(value="/hello",method = RequestMethod.GET)
    public void hello(Model model)
    {
        model.addAttribute("message","this is message");
    }

    @RequestMapping(value="/json",method = RequestMethod.POST)
    public Map  json(Animal f,
                     HttpServletRequest request) {

        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if(isMultipart)
        {
            if(request instanceof DefaultMultipartHttpServletRequest) {

                DefaultMultipartHttpServletRequest fileRequest =(DefaultMultipartHttpServletRequest) request;

                System.out.println("has File upload");
                try {

                    MultiValueMap<String,MultipartFile> parts = fileRequest.getMultiFileMap();

                    for(Map.Entry<String,List<MultipartFile>> kv:parts.entrySet())
                    {
                        System.out.println("key is " + kv.getKey());
                        for(MultipartFile file: kv.getValue())
                        {
                            System.out.println("name  is " + file.getName()+" size is "+file.getSize());
                        }
                    }

                } catch (Exception e) {
                    System.out.println(" exception " + e.getMessage());
                }
            }

        }
        else
        {
            System.out.println("do not have File upload");
        }



        System.out.println(" images size"+f.getImages().size());

        Map map=new HashMap();
        map.put("message", "qq22211");
        map.put("name", f.getName());
        return  map;
    }

    @RequestMapping(value="/upload",method = RequestMethod.POST)
    @ResponseBody
    public Map upload(Animal f,HttpServletRequest request,
                      @RequestParam("images") List<MultipartFile> file) throws Exception
    {


        Map map=new HashMap();


        System.out.println("file  " + file.size());

        map.put("message", "part size "+request.getParts().size());

        return  map;
    }


    @RequestMapping(value="/getjson",method = RequestMethod.GET)
    @ResponseBody
        public Animal getjson() throws Exception
    {

        Animal a=new Animal();

        a.setName("panda熊猫");
        a.setWeight(100);;

        return a;
    }

    @RequestMapping(value="/getStr",method = RequestMethod.GET)
    public String getStr() throws Exception
    {


        return "str";
    }

}



