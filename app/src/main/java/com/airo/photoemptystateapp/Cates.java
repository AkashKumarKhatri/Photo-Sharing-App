package com.airo.photoemptystateapp;

public class Cates {
    private String iconTitle;
    private Integer iconImg;

    public Cates(String iconTitle, Integer iconImg) {
        this.iconTitle = iconTitle;
        this.iconImg = iconImg;
    }

    public String getIconTitle() {
        return iconTitle;
    }

    public void setIconTitle(String iconTitle) {
        this.iconTitle = iconTitle;
    }

    public Integer getIconImg() {
        return iconImg;
    }

    public void setIconImg(Integer iconImg) {
        this.iconImg = iconImg;
    }
}
