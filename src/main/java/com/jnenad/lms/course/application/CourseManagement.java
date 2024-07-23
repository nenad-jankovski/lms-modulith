package com.jnenad.lms.course.application;

import com.jnenad.lms.course.CourseDto;
import com.jnenad.lms.course.CourseExternalAPI;
import com.jnenad.lms.course.CourseInternalAPI;
import com.jnenad.lms.course.domain.*;
import java.util.Collection;
import java.util.Objects;
import java.util.UUID;

import com.jnenad.lms.commons.exceptions.ResourceAlreadyExistsException;
import com.jnenad.lms.course.infrastructure.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CourseManagement implements CourseExternalAPI, CourseInternalAPI {
  private final CourseRepository courseRepository;
  private final CourseMapper courseMapper;

  @Override
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
      throw new ResourceAlreadyExistsException(
          String.format("Course with external-id: %s already exists", externalId));
    }

    return courseMapper.entityToDto(courseRepository.save(course));
  }

  @Override
  public CourseDto findCourseByExternalId(UUID externalId) {
    var course = courseRepository.findByExternalId(externalId).orElseThrow();
    return courseMapper.entityToDto(course);
  }

  @Override
  public Collection<CourseDto> listAll() {
    return courseMapper.entityToDto(courseRepository.findAll());
  }
}
