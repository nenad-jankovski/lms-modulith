package com.jnenad.lms.learning.persistance;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Object, Long> {}
