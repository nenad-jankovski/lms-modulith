package com.jnenad.lms.users;

import java.util.UUID;

public record UserDto(
    UUID externalId, String firstName, String lastName, String role, String email) {}
