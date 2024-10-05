package com.wlabs.api_rest_bank_2024.controller;

import com.wlabs.api_rest_bank_2024.domain.model.User;
import com.wlabs.api_rest_bank_2024.exception.UserAlreadyExistsException;
import com.wlabs.api_rest_bank_2024.service.impl.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> GetUser(@PathVariable Long id) {
        var user = userService.findById(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);

    }

    @PostMapping
    public ResponseEntity<User> SaveUser(@RequestBody User user) throws UserAlreadyExistsException {
        var userPersist = userService.createUser(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(userPersist);

    }

    @GetMapping
    public List<User> ListAllUser(){
        return userService.listAllUsers();
    }


    @PutMapping("/{id}")
    public ResponseEntity<User> UpdateUserById(@PathVariable Long id, @RequestBody User userUpdated) {
        var user = userService.updateUser(id, userUpdated);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> DeleteUserId(@PathVariable Long id) {
        userService.deleteUserById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
