package com.jnenad.lms.course.domain;

import jakarta.persistence.*;
import java.util.UUID;

import lombok.*;
import org.jmolecules.ddd.annotation.Identity;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Builder
@Table(name = "courses", uniqueConstraints = @UniqueConstraint(columnNames = {"externalId"}))
@AllArgsConstructor
public class Course {
  @Id
  @Identity
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
