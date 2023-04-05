package com.humam.restaurants.models;



import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.humam.restaurants.extras.ImageSerializer;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;


  @Column()
  private String name;

  @OneToOne(fetch = FetchType.LAZY)
  @JsonSerialize(using = ImageSerializer.class)
  private Image featuredImage;

  public Category() {

  }

  public Category(String name, Image featuredImage) {
    this.name = name;
    this.featuredImage = featuredImage;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

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