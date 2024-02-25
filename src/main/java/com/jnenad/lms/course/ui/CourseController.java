package com.jnenad.lms.course.ui;

import com.jnenad.lms.course.application.CourseDto;
import com.jnenad.lms.course.application.CourseManagement;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/api/v1/courses")
@RequiredArgsConstructor
public class CourseController {

  private final CourseManagement courseManagement;

  @PostMapping
  ResponseEntity<Void> createCourse(@RequestBody CourseRequest request) {
    var result =
        courseManagement.createCourse(request.externalId, request.title, request.description);
    var location =
        ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{externalId}")
            .buildAndExpand(result.externalId())
            .toUri();
    return ResponseEntity.created(location).build();
  }

  record CourseRequest(UUID externalId, String title, String description) {}

  @GetMapping("/{externalId}")
  ResponseEntity<CourseDto> findCourseByExternalId(@PathVariable UUID externalId) {
    var result = courseManagement.findCourseByExternalId(externalId);
    return ResponseEntity.ok(result);
  }
}
