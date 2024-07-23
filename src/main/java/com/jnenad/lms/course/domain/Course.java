package com.jnenad.lms.course.domain;

import jakarta.persistence.*;
import java.util.UUID;

import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Builder
@Table(name = "courses", uniqueConstraints = @UniqueConstraint(columnNames = {"externalId"}))
@AllArgsConstructor
public class Course {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private UUID externalId;
  @Embedded
  @AttributeOverride(name="value", column=@Column(name="name"))
  private CourseName name;
  @Embedded
  @AttributeOverride(name="value", column=@Column(name="description"))
  private CourseDescription description;
}
