package com.jnenad.lms.learning.domain;

import lombok.Builder;

@Builder
public record CourseName(Long id, String name) {}
