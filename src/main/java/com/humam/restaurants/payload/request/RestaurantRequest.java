package com.humam.restaurants.payload.request;

import com.humam.restaurants.extras.CuisineType;
import com.humam.restaurants.models.Category;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class RestaurantRequest {
	@NotBlank
  	private String name;

	@NotBlank
	private String about;

	@NotNull
	private Category category;

	@NotNull
	private CuisineType cuisineType;

	@NotNull
	private Double longitude;

	@NotNull
	private Double latitude;

	public RestaurantRequest(String name, String about, Category category, CuisineType cuisineType, Double longitude, Double latitude) {
		this.name = name;
		this.about = about;
		this.category = category;
		this.cuisineType = cuisineType;
		this.longitude = longitude;
		this.latitude = latitude;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public CuisineType getCuisineType() {
		return cuisineType;
	}

	public void setCuisineType(CuisineType cuisineType) {
		this.cuisineType = cuisineType;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
}
