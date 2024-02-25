package com.jnenad.lms.learning.persistance;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Object, Long> {}
