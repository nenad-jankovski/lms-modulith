package com.jnenad.lms.course.application;

import java.util.UUID;

public record CourseDto(UUID externalId, String name, String description) {
}
