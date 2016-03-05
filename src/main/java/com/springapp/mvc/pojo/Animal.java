package com.springapp.mvc.pojo;

import com.sun.istack.internal.NotNull;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.List;

/**
 * Created by chj on 2016/1/29.
 */
public class Animal implements Serializable {

    @NotNull
    private String name;

    @NotNull
    private Integer weight;


    private List<MultipartFile> images;



    public List<MultipartFile> getImages() {
        return images;
    }

    public void setImages(List<MultipartFile> images) {
        this.images = images;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
