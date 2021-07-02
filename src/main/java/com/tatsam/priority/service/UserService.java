package com.tatsam.priority.service;

import com.tatsam.priority.dto.UserData;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    String addUser(UserData userData);

    String getTokenByUserNameAndPass(UserData userData);
}
