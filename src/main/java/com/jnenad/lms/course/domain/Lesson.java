package com.jnenad.lms.course.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Builder
@Table(name = "lessons")
@AllArgsConstructor
public final class Lesson {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String title;
  @Column(name = "lesson_content")
  private String content;
  private Long courseId;
}
