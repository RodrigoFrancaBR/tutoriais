package br.com.franca.myAppMongoDB.api.controller;

import br.com.franca.myAppMongoDB.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping
    public List<User> users(){

        List<User> users = List.of(
                new User("1", "user_1", "user_1@gmail.com"),
                new User("2", "user_2", "user_2@gmail.com"),
                new User("3", "user_3", "user_3@gmail.com")
        );

        return users;
    }
}
