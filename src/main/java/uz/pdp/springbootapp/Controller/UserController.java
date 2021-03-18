package uz.pdp.springbootapp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springbootapp.DTO.Result;
import uz.pdp.springbootapp.DTO.UserDTO;
import uz.pdp.springbootapp.Entity.User;
import uz.pdp.springbootapp.Service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    // CREATE new user
    @PostMapping
    public Result addUsers(@RequestBody UserDTO userDTO) {
        Result result = userService.addUser(userDTO);
        return result;
    }

    // READ all users
    @GetMapping
    public List<User> readAllUsers() {
        List<User> userList = userService.getAllUsers();
        return userList;
    }

    // READ user by id
    @GetMapping("/{id}")
    public User readUsersById(@PathVariable Integer id) {
        User user = userService.getUserById(id);
        return user;
    }

    // UPDATE user by id
    @PutMapping("/{id}")
    public Result updateUserById(@PathVariable Integer id, @RequestBody UserDTO userDTO) {
        Result updateUser= userService.updateUser(id, userDTO);
        return updateUser;
    }

    // DELETE user by id
    @DeleteMapping("/{id}")
    public Result deleteUserById(@PathVariable Integer id) {
        Result deleteUsers = userService.deleteUser(id);
        return deleteUsers;

    }
}
