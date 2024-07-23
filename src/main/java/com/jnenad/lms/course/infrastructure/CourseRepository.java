package com.jnenad.lms.course.infrastructure;

import java.util.Optional;
import java.util.UUID;

import com.jnenad.lms.course.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
  Optional<Course> findByExternalId(UUID externalId);
}
