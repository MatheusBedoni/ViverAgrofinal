package com.example.viveragrofinal.domain;

public class Fruit {
    private String name;
    private int img;
    private int imgColor;
    private int look;


    public String getName() {
        return name;
    }

    public int getImgColor() {
        return imgColor;
    }

    public int getLook() {
        return look;
    }

    public void setImgColor(int imgColor) {
        this.imgColor = imgColor;
    }

    public void setLook(int look) {
        this.look = look;
    }

    public int getImg(){
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public void setName(String name) {
        this.name = name;
    }
}
