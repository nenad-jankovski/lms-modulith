package com.jnenad.lms.course.application;

import com.jnenad.lms.course.CourseDto;
import com.jnenad.lms.course.domain.Course;
import com.jnenad.lms.course.domain.CourseDescription;
import com.jnenad.lms.course.domain.CourseName;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.Collection;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CourseMapper {
  CourseDto entityToDto(Course course);
  Collection<CourseDto> entityToDto(Collection<Course> course);

  default String valueToString(CourseName name) {
    return name.value();
  }

  default String valueToString(CourseDescription description) {
    return description.value();
  }
}
