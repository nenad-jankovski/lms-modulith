package com.jnenad.lms.ratings.application;

import com.jnenad.lms.course.CourseRemovedEvent;
import com.jnenad.lms.ratings.RatingExternalAPI;
import com.jnenad.lms.ratings.RatingInternalAPI;
import com.jnenad.lms.ratings.domain.CourseRating;
import com.jnenad.lms.ratings.infrastructure.CourseRatingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RatingManagement implements RatingExternalAPI, RatingInternalAPI {
  private final CourseRatingRepository courseRatingRepository;

  @ApplicationModuleListener
  void onCourseRemovedEvent(CourseRemovedEvent event) {
    courseRatingRepository.deleteByCourseId(event.getId());
  }

  @Override
  public void rateCourse(Long courseId, int stars, Long userId) {
    courseRatingRepository.save(new CourseRating(null, courseId, userId, stars));
  }

  @Override
  public int getRating(Long courseId) {
    return 0;
  }

  @Override
  public int getAvgRatingByUser(Long userId) {
    return 0;
  }
}
