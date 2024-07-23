package com.jnenad.lms.users.application;

import com.jnenad.lms.commons.exceptions.ResourceAlreadyExistsException;
import com.jnenad.lms.users.UserDto;
import com.jnenad.lms.users.UserExternalAPI;
import com.jnenad.lms.users.UserInternalAPI;
import com.jnenad.lms.users.infrastructure.UserRepository;
import java.util.Collection;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserManagement implements UserExternalAPI, UserInternalAPI {

  private final UserRepository userRepository;
  private final UserMapper userMapper;

  @Override
  public UserDto createUser(UserDto dto) {
    var user =
        userRepository.findByExternalId(dto.externalId()).orElseGet(() -> userMapper.toUser(dto));
    if (Objects.nonNull(user.getId())) {
      throw new ResourceAlreadyExistsException(
          String.format("Course with external-id: %s already exists", dto.externalId()));
    }
    return userMapper.toUserDto(user);
  }

  @Override
  public UserDto updateUser(UserDto dto) {
    var user = userRepository.findByExternalId(dto.externalId()).orElseThrow();

    userMapper.updateUser(user, dto);

    return userMapper.toUserDto(userRepository.save(user));
  }

  @Override
  public UserDto findUser(UserDto dto) {
    var user = userRepository.findByExternalId(dto.externalId()).orElseThrow();

    return userMapper.toUserDto(user);
  }

  @Override
  public Collection<UserDto> findAllUsers() {
    return userMapper.toUserDtos(userRepository.findAll());
  }
}
