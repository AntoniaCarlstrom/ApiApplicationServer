package com.example.api.api.controller;

import com.example.api.api.model.User;
import com.example.api.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired

    public UserController(UserService userService) {
        this.userService = userService;
    }
//GetMapping för olika url beroende på vad användaren väljer i menyn

    //Hämtar alla users i listan
    @GetMapping("/users")
    public ResponseEntity<String> getAllUsers() throws JsonProcessingException {
        List<User> userList = userService.getAllUsers();
        if (userList.size() > 0) {
            ObjectMapper mapper = new ObjectMapper();
            String jsonUsers = mapper.writeValueAsString(userList);
            return ResponseEntity.ok().body(jsonUsers);
        }
        return ResponseEntity.notFound().build();
    }

    //Hämtar specifik user efter id som användaren valt.
    @GetMapping("/user")
    public ResponseEntity<String> getUser(@RequestParam Integer id) throws JsonProcessingException {
        Optional<User> user = userService.getUser(id);
        if (user.isPresent()) {
            ObjectMapper mapper = new ObjectMapper();
            String jsonUser = mapper.writeValueAsString(user.get());

            return ResponseEntity.ok().body(jsonUser);
        }
        return ResponseEntity.notFound().build();
    }
}
