package com.jnenad.lms.gateway;

import com.jnenad.lms.course.CourseExternalAPI;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class GatewayManagement {
  private final CourseExternalAPI courseExternalAPI;

  public GatewayManagement(CourseExternalAPI courseExternalAPI) {
    this.courseExternalAPI = courseExternalAPI;
  }
}
