package com.example.elearning.model;


public class Lesson {

  private long id;
  private String durationTime;
  private String notes;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getDurationTime() {
    return durationTime;
  }

  public void setDurationTime(String durationTime) {
    this.durationTime = durationTime;
  }


  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

  public Lesson(long id, String durationTime, String notes) {
    this.id = id;
    this.durationTime = durationTime;
    this.notes = notes;
  }

  public Lesson() {
  }
}
