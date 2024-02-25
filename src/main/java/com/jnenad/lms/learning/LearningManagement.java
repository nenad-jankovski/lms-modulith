package com.jnenad.lms.learning;

import com.jnenad.lms.learning.services.AssessmentService;
import com.jnenad.lms.learning.services.CourseService;
import com.jnenad.lms.learning.services.EnrollmentService;
import org.springframework.stereotype.Component;

@Component
public class LearningManagement {
  private final AssessmentService assessmentService;
  private final CourseService courseService;
  private final EnrollmentService enrollmentService;

  public LearningManagement(
      AssessmentService assessmentService,
      CourseService courseService,
      EnrollmentService enrollmentService) {
    this.assessmentService = assessmentService;
    this.courseService = courseService;
    this.enrollmentService = enrollmentService;
  }
}
