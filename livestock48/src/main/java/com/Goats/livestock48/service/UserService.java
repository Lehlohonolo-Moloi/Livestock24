package com.Goats.livestock48.service;

import com.Goats.livestock48.model.User;
import com.Goats.livestock48.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserService {

    private final UserRepository repository;
    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> getAllUsers(){
        return repository.findAll();
    }

    public User getUserById(Long id){
        User user = repository.findById(id)
                .orElseThrow(() -> new IllegalStateException("User with id " + id + " does not exist"));
        return user;
    }

    public User addUser(User user){
        repository.save(user);
        return user;
    }

    public User deleteUser(Long id){
        User user = getUserById(id);
        repository.delete(user);
        return user;
    }

    @Transactional
    public User updateUsername(Long id, String name){
        User user = getUserById(id);

        if(name != null
                && name.length() > 3
                && !Objects.equals(user.getName(), name)
        ){
            user.setName(name);
        }

        return user;
    }
}
