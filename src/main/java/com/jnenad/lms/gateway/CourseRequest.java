package com.jnenad.lms.gateway;

import java.util.UUID;

public record CourseRequest(UUID externalId, String title, String description) {}
