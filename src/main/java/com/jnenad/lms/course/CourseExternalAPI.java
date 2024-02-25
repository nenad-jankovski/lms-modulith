package com.jnenad.lms.course;

import java.util.Collection;
import java.util.UUID;

public interface CourseExternalAPI {
  CourseDto createCourse(UUID externalId, String name, String description);

  CourseDto findCourseByExternalId(UUID externalId);

  Collection<CourseDto> listAll();
}
