package com.jnenad.lms.users.infrastructure;

import com.jnenad.lms.users.domain.User;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByExternalId(UUID externalId);
}
