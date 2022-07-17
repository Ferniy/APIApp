package com.example.ProjectX.model;

import com.example.ProjectX.entity.ClothesEntity;

public class Clothes {
    private String clothesType;
    private String color;
    private String name;
    private String picture;
    private Integer rating;
    private Boolean ironed;
    private Boolean washed;

    public static Clothes toModel(ClothesEntity clothesEntity){
        Clothes clothes = new Clothes();
        clothes.clothesType = clothesEntity.getClothesType();
        clothes.color = clothesEntity.getColor();
        clothes.name = clothesEntity.getName();
        clothes.picture = clothesEntity.getPicture();
        clothes.rating = clothesEntity.getRating();
        clothes.ironed = clothesEntity.getIroned();
        clothes.washed = clothesEntity.getWashed();
        return clothes;
    }

    public String getClothesType() {
        return clothesType;
    }

    public void setClothesType(String clothesType) {
        this.clothesType = clothesType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Boolean getIroned() {
        return ironed;
    }

    public void setIroned(Boolean ironed) {
        this.ironed = ironed;
    }

    public Boolean getWashed() {
        return washed;
    }

    public void setWashed(Boolean washed) {
        this.washed = washed;
    }
}
