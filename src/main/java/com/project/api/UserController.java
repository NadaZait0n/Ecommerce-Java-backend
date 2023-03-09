package com.project.api;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.project.database.Entities.User;
import com.project.services.UserService;

@RestController
public class UserController {
    
private final UserService userService;
public UserController(UserService userService) {
    this.userService = userService;
}

@GetMapping("/users")
public List<User> getAllUsers()
{
 return userService.getAll();
}

@PostMapping("/users")
public User addProduct(@RequestBody User user)
{
    return userService.addUser(user);
}

@GetMapping("/users/{id}")
public User getById(@PathVariable Integer id)
{
 return userService.getById(id);
}


@DeleteMapping("/users/{id}")
public void deleteUser(@PathVariable int id)
{
  userService.deleteUser(id);
}


}
