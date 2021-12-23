package br.com.franca.myAppMongoDB.api.controller;

import br.com.franca.myAppMongoDB.api.service.UserService;
import br.com.franca.myAppMongoDB.model.User;
import br.com.franca.myAppMongoDB.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;
    private final UserRepository repo;

    @GetMapping
    public List<User> findAll(){
        var a = new User();
        a.setName("x");
        a.setEmail("myemail");
        return service.findAll();
    }
}
