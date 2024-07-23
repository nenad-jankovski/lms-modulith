package com.jnenad.lms.ratings.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Builder
@Table(name = "course_rating")
@AllArgsConstructor
public class CourseRating {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Long courseId;

  private Long userId;

  private int rating;
}
