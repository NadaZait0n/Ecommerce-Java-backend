package com.project.services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.project.database.Entities.User;
import com.project.database.Repository.UserRepositery;


@Service
public class UserService {
    private final UserRepositery userRepositery;

    public UserService(UserRepositery userRepositery) {
        this.userRepositery = userRepositery;
    }

    public List<User>getAll() {
        return userRepositery.findAll();
    }

    public User addUser(User user) {
        return userRepositery.save(user);
    }

    public User getById(int id) {
        return userRepositery.findById(id).orElse(null);
    }

    public void deleteUser(int id) {
        userRepositery.deleteById(id);
    }

}
