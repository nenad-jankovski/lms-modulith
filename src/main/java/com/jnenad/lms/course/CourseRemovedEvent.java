package com.jnenad.lms.course;

public class CourseRemovedEvent {
  private Long id;

  public CourseRemovedEvent(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
