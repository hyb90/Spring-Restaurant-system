package com.humam.restaurants.models;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.humam.restaurants.extras.CategorySerializer;
import com.humam.restaurants.extras.ImageSerializer;

import javax.persistence.*;

@Entity
@Table(name = "ads")
public class Ad {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;


  @Column()
  private String title;

  @Lob
  @Column(length=512)
  private String description;

  @OneToOne(fetch = FetchType.LAZY)
  @JsonSerialize(using = ImageSerializer.class)
  private Image image;

  public Ad() {

  }

  public Ad(String title, String description, Image image) {
    this.title = title;
    this.description = description;
    this.image = image;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

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