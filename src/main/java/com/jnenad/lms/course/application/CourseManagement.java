package com.jnenad.lms.course.application;

import com.jnenad.lms.course.CourseExternalAPI;
import com.jnenad.lms.course.domain.*;

import java.util.Objects;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseManagement implements CourseExternalAPI {
  private final CourseRepository courseRepository;
//  private final LessonRepository lessonRepository;
  private final CourseMapper courseMapper;

  public CourseDto createCourse(UUID externalId, String name, String description) {
    var course =
        courseRepository
            .findByExternalId(externalId)
            .orElseGet(
                () ->
                    Course.builder()
                        .externalId(externalId)
                        .description(new CourseDescription(description))
                        .name(new CourseName(name))
                        .build());
    if (Objects.nonNull(course.getId())) {
      throw new IllegalArgumentException(
          String.format("Course with UUID: %s already exists", externalId));
    }

    return courseMapper.entityToDto(courseRepository.save(course));
  }

  public CourseDto findCourseByExternalId(UUID externalId) {
    var course = courseRepository.findByExternalId(externalId).orElseThrow();
    return courseMapper.entityToDto(course);
  }
}
