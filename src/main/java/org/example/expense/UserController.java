package org.example.expense;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping
    public User createUser(@RequestBody User user) {
       return  userService.addUser(user);
    }
    public void deleteUser(@RequestBody User user) {
        userService.Deleteuser(user);
    }
    @GetMapping
    public List<User> getUsers() {
        return userService.getUser();
    }
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable long userId) {
        userService.deleteUser(userId);
    }

}
