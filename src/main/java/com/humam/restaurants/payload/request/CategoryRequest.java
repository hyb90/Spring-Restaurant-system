package com.humam.restaurants.payload.request;

import com.humam.restaurants.models.Image;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CategoryRequest {
	@NotBlank
  private String name;

	@NotNull
	private Image featuredImage;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Image getFeaturedImage() {
		return featuredImage;
	}

	public void setFeaturedImage(Image featuredImage) {
		this.featuredImage = featuredImage;
	}
}
