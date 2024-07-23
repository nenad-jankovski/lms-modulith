package com.jnenad.lms.users.application;

import com.jnenad.lms.users.UserDto;
import com.jnenad.lms.users.domain.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

import java.util.Collection;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

  UserDto toUserDto(User user);

  User toUser(UserDto userDto);

  void updateUser(@MappingTarget User user, UserDto userDto);

  Collection<UserDto> toUserDtos(Collection<User> users);
}
