package com.example.api.service;

import com.example.api.api.model.User;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    private List<User> userList;

    public List<User> getAllUsers() {
        return userList;
    }

    //Lista skapas och users skapas och läggs till
    public UserService() {
        userList = new ArrayList<>();

        User user1 = new User(1, "Ida", 14, "ida@gmail.com");
        User user2 = new User(2, "Erik", 25, "erik@gmail.com");
        User user3 = new User(3, "Therese", 64, "therese@hotmail.com");
        User user4 = new User(4, "Miniliten", 32, "miniliten@gmail.com");
        User user5 = new User(5, "Lisa", 65, "lisa@hotmail.com");

        userList.addAll(Arrays.asList(user1, user2, user3, user4, user5));

    }

    //Hämtar och returnerar user från lista efter id
    public Optional<User> getUser(Integer id) {
        Optional optional = Optional.empty();
        for (User user : userList) {
            if (id == user.getId()) {
                optional = Optional.of(user);

                return optional;
            }
        }
        return optional;
    }
}
