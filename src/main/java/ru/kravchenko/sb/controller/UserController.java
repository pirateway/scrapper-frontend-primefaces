package ru.kravchenko.sb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.SessionScope;
import ru.kravchenko.sb.api.repository.UserRepository;
import ru.kravchenko.sb.model.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author Roman Kravchenko
 */

@Controller
@SessionScope
public class UserController {

    @Autowired
    UserRepository userRepository;

    private final List<User> userList = new ArrayList<>();

    {
        userList.add(new User("Masya", "masik01"));
        userList.add(new User("Filya", "fil666"));
        userList.add(new User("Pafiriy", "pafik"));
    }

    public List<User> getUserList() {
        return userList;
    }

    public void createUser(){
        final User user = new User();
        user.setLogin("Vasek");
        user.setPassword("2222");
        userRepository.save(user);
        userList.add(user);
    }

}
