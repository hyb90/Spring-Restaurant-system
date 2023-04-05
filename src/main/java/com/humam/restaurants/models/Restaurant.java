package com.humam.restaurants.models;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.humam.restaurants.extras.CategorySerializer;
import com.humam.restaurants.extras.CuisineType;

import javax.persistence.*;

@Entity
@Table(name = "restaurants")
public class Restaurant {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private String name;

  @Enumerated(EnumType.STRING)
  @Column(length = 20)
  private CuisineType cuisineType;

  @Lob
  @Column(length=512)
  private String about;

  @ManyToOne(fetch = FetchType.LAZY)
  @JsonSerialize(using = CategorySerializer.class)
  private Category category;


  @Column
  private Double longitude;

  @Column
  private Double latitude;

  public Restaurant() {

  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Restaurant(String name, CuisineType cuisineType, String about, Category category, Double longitude,Double latitude) {
    this.name = name;
    this.cuisineType = cuisineType;
    this.about = about;
    this.category = category;
    this.longitude=longitude;
    this.latitude=latitude;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CuisineType getCuisineType() {
    return cuisineType;
  }

  public void setCuisineType(CuisineType cuisineType) {
    this.cuisineType = cuisineType;
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