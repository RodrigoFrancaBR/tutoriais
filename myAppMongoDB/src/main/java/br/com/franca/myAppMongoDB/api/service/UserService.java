package br.com.franca.myAppMongoDB.api.service;

import br.com.franca.myAppMongoDB.model.User;
import br.com.franca.myAppMongoDB.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }
}
