package com.example.elearning.model;


public class Course {

  private long id;
  private long price;
  private String name;
  private String description;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getPrice() {
    return price;
  }

  public void setPrice(long price) {
    this.price = price;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Course(long id, long price, String name, String description) {
    this.id = id;
    this.price = price;
    this.name = name;
    this.description = description;
  }

  public Course() {
  }
}
