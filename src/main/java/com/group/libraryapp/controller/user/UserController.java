package com.group.libraryapp.controller.user;

import com.group.libraryapp.domain.user.User;
import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import com.group.libraryapp.service.user.UserService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

//    private final List<User> users = new ArrayList<>();

    private final UserService userService;

    private final JdbcTemplate jdbcTemplate;

    public UserController(JdbcTemplate jdbcTemplate) {

        this.jdbcTemplate = jdbcTemplate;
        this.userService = new UserService(jdbcTemplate);

    }

    @PostMapping("/user") // POST /user
    public void saveUser(@RequestBody UserCreateRequest request) {
//        users.add(new User(request.getName(), request.getAge()));

        userService.saveUser(request);

    }

    @GetMapping("/user")
    public List<UserResponse> getUser() {
//        List<UserResponse> responses = new ArrayList<>();
//        for (int i=0; i< users.size(); i++) {
//            responses.add(new UserResponse(i + 1, users.get(i)));
//        }
//        return responses;

        return userService.getUsers();

    }


    @PutMapping("/user")
    public void updateUser(@RequestBody UserUpdateRequest request) {

        userService.updateUser(request);
    }

    @DeleteMapping("/user")
    public void deleteUser(@RequestParam String name) {
        userService.deleteUser(name);

    }


}
