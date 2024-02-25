package com.jnenad.lms.gateway;

import com.jnenad.lms.learning.LearningManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class GatewayManagement {
  private final LearningManagement learningManagement;

  public GatewayManagement(LearningManagement learningManagement) {
    this.learningManagement = learningManagement;
  }
}
