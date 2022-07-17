package com.example.ProjectX.entity;

import javax.persistence.*;

@Entity
@Table(name = "clothes")
public class ClothesEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name = "userId")
	private Integer userId;
	@Column(name = "clothesType")
	private String clothesType;
	@Column(name = "color")
	private String color;
	@Column(name = "name")
	private String name;
	@Column(name = "picture")
	private String picture;
	@Column(name = "rating")
	private Integer rating;
	@Column(name = "ironed")
	private Boolean ironed;
	@Column(name = "washed")
	private Boolean washed;

	public ClothesEntity() {
	}

	public Integer getId() { return id; }

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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
