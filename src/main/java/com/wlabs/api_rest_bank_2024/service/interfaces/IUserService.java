package com.wlabs.api_rest_bank_2024.service.interfaces;

import com.wlabs.api_rest_bank_2024.domain.model.User;
import com.wlabs.api_rest_bank_2024.exception.UserAlreadyExistsException;

import java.util.List;

public interface IUserService {

    User findById(Long id);

    User createUser(User user) throws UserAlreadyExistsException;
    
    List<User> listAllUsers();
}
