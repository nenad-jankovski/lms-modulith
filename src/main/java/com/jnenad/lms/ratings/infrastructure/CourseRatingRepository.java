package com.jnenad.lms.ratings.infrastructure;

import com.jnenad.lms.ratings.domain.CourseRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRatingRepository extends JpaRepository<CourseRating, Long> {
  void deleteByCourseId(Long courseId);
}
