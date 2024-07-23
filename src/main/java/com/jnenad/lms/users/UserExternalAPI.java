package com.jnenad.lms.users;

import java.util.Collection;

public interface UserExternalAPI {

    UserDto createUser(UserDto dto);

    UserDto updateUser(UserDto dto);

    UserDto findUser(UserDto dto);

    Collection<UserDto> findAllUsers();

}
