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
import java.util.Scanner;

@RestController
public class UserController {

    private UserService userService;

    @Autowired

    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @GetMapping("/user")
//    public User getUser(@RequestParam Integer id) {
//
//        Optional user = breedService.getUser(id);
//        if(user.isPresent()) {
//            return (User) user.get();
//
//        } return null;
//    }

//    @GetMapping("/user")
//    public ResponseEntity<User> getUser() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter user id: ");
//        Integer id = scanner.nextInt();
//        Optional<User> user = breedService.getUser(id);
//        if(user.isPresent()) {
//            return ResponseEntity.ok().body(user.get());
//        }
//        return ResponseEntity.notFound().build();
//    }
//@GetMapping("/user")
//public ResponseEntity<String> getUser() throws JsonProcessingException {
//    Scanner scanner = new Scanner(System.in);
//    System.out.print("Enter user ID: ");
//    Integer id = scanner.nextInt();
//    Optional<User> user = userService.getUser();
//    if(user.isPresent()) {
//        ObjectMapper mapper = new ObjectMapper();
//        String jsonUser = mapper.writeValueAsString(user.get());
//        System.out.println(jsonUser);
//        return ResponseEntity.ok().body(jsonUser);
//    }
//    return ResponseEntity.notFound().build();
//}

    @GetMapping("/users")
    public ResponseEntity<String> getAllUsers() throws JsonProcessingException {
        List<User> userList = userService.getAllUsers();
        if(userList.size() > 0) {
            ObjectMapper mapper = new ObjectMapper();
            String jsonUsers = mapper.writeValueAsString(userList);
            System.out.println(jsonUsers);
            return ResponseEntity.ok().body(jsonUsers);
        }
        return ResponseEntity.notFound().build();
    }
@GetMapping("/user")
public ResponseEntity<String> getUser(@RequestParam Integer id) throws JsonProcessingException {
    Optional<User> user = userService.getUser(id);
    if(user.isPresent()) {
        ObjectMapper mapper = new ObjectMapper();
        String jsonUser = mapper.writeValueAsString(user.get());
        System.out.println(jsonUser);
        return ResponseEntity.ok().body(jsonUser);
    }
    return ResponseEntity.notFound().build();
}
}
