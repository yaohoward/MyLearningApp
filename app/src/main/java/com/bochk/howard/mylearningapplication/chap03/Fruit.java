package com.bochk.howard.mylearningapplication.chap03;

/**
 * Created by ThinkPad on 2017/6/7.
 * P115 创建一个实体类，作为ListView 适配器的适配类型
 */

public class Fruit {
    private String name;
    private int imageId;

    public Fruit (String name, int imageId){
        this.name = name;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }
}
