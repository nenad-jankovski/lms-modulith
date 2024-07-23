package com.jnenad.lms.users.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Builder
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = {"externalId"}))
@AllArgsConstructor
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  private UUID externalId;

  private String firstName;
  private String lastName;

  private String email;

  @Enumerated(EnumType.STRING)
  private UserRole role;
}
