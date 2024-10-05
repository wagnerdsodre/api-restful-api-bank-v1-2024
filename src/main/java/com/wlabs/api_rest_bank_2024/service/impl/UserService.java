package com.wlabs.api_rest_bank_2024.service.impl;

import com.wlabs.api_rest_bank_2024.domain.model.User;
import com.wlabs.api_rest_bank_2024.domain.repository.UserRepository;
import com.wlabs.api_rest_bank_2024.exception.UserAlreadyExistsException;
import com.wlabs.api_rest_bank_2024.exception.UserNotFoundException;
import com.wlabs.api_rest_bank_2024.service.interfaces.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User with ID " + id + " not found"));
    }

    @Override
    public User createUser(User user) throws UserAlreadyExistsException {
        if (userRepository.existsByAccountNumber(user.getAccount().getNumber())) {
            throw new UserAlreadyExistsException("User already exists with ID: " + user.getId());
        }
        return userRepository.save(user);
    }

    @Override
    public List<User> listAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(Long id, User user) throws UserNotFoundException {
        var userUpdated = new User();
        if(userRepository.findById(id).isPresent()){
            userUpdated.setId(user.getId());
            userUpdated.setName(user.getName());
            userUpdated.setCard(user.getCard());
            userUpdated.setAccount(user.getAccount());
            userUpdated.setFeatures(user.getFeatures());
            userUpdated.setNews(user.getNews());
        }
        userRepository.save(userUpdated);
        return userUpdated;
    }
}
