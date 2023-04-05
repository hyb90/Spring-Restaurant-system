package com.humam.restaurants.payload.request;

import com.humam.restaurants.models.Image;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class AdRequest {
	@NotBlank
  private String title;

	@NotBlank
	private String description;

	@NotNull
	private Image image;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
}
