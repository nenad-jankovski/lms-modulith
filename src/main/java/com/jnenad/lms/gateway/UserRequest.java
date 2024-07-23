package com.jnenad.lms.gateway;

import java.util.UUID;

public record UserRequest(
    UUID externalId, String firstName, String lastName, String role, String email) {}
