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

    public UserService(){
        userList = new ArrayList<>();

        User user1 = new User(1, "Ida", 14, "ida@gmail.com");
        User user2 = new User(2, "Två", 14, "ida@gmail.com");
        User user3 = new User(3, "Tre", 14, "ida@gmail.com");
        User user4 = new User(4, "Fyra", 14, "ida@gmail.com");
        User user5 = new User(5, "Fem", 14, "ida@gmail.com");

        userList.addAll(Arrays.asList(user1, user2, user3, user4, user5));

    }
    public Optional<User> getUser(Integer id) {
        Optional optional = Optional.empty();
        for(User user: userList) {
            if(id == user.getId()) {
                optional = Optional.of(user);

                return optional;
            }
        }
        return optional;
    }
}
