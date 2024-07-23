package com.jnenad.lms.gateway;

import com.jnenad.lms.course.CourseDto;
import com.jnenad.lms.course.CourseExternalAPI;
import com.jnenad.lms.ratings.RatingExternalAPI;
import com.jnenad.lms.users.UserDto;
import com.jnenad.lms.users.UserExternalAPI;
import java.util.Collection;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/api/v1")
public class GatewayManagement {
  private final CourseExternalAPI courseExternalAPI;
  private final UserExternalAPI userExternalAPI;
  private final RatingExternalAPI ratingExternalAPI;

  public GatewayManagement(
      CourseExternalAPI courseExternalAPI,
      UserExternalAPI userExternalAPI,
      RatingExternalAPI ratingExternalAPI) {
    this.courseExternalAPI = courseExternalAPI;
    this.userExternalAPI = userExternalAPI;
    this.ratingExternalAPI = ratingExternalAPI;
  }

  @PostMapping("/courses")
  ResponseEntity<Void> createCourse(@RequestBody CourseRequest request) {
    var result =
            courseExternalAPI.createCourse(request.externalId(), request.title(), request.description());
    var location =
            ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{externalId}")
                    .buildAndExpand(result.externalId())
                    .toUri();
    return ResponseEntity.created(location).build();
  }

  @GetMapping("/courses/{externalId}")
  ResponseEntity<CourseDto> findCourseByExternalId(@PathVariable UUID externalId) {
    var result = courseExternalAPI.findCourseByExternalId(externalId);
    return ResponseEntity.ok(result);
  }

  @GetMapping(value = {"/courses", "/courses/"})
  ResponseEntity<Collection<CourseDto>> listAllCourses() {
    var result = courseExternalAPI.listAll();
    if (result.isEmpty()) {
      return ResponseEntity.noContent().build();
    }
    return ResponseEntity.ok(result);
  }

  @PostMapping("/users")
  ResponseEntity<Void> createUser(@RequestBody UserRequest request) {
    var result =
        userExternalAPI.createUser(
            new UserDto(
                request.externalId(),
                request.firstName(),
                request.lastName(),
                request.role(),
                request.email()));
    var location =
        ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{externalId}")
            .buildAndExpand(result.externalId())
            .toUri();
    return ResponseEntity.created(location).build();
  }
}
