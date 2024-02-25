package com.jnenad.lms.course.application;

import com.jnenad.lms.course.domain.Course;
import com.jnenad.lms.course.domain.CourseDescription;
import com.jnenad.lms.course.domain.CourseName;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CourseMapper {
  CourseDto entityToDto(Course course);

  default String valueToString(CourseName name) {
    return name.value();
  }

  default String valueToString(CourseDescription description) {
    return description.value();
  }
}
