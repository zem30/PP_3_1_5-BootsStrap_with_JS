package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.security.Principal;
import java.util.List;

@RestController

public class AdminController {
    private final UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    //все user'ы показываются
    @GetMapping("/allUsers")
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userService.showUsers(), HttpStatus.OK);
    }

    //показывает авторизованного user'a
    @GetMapping("/getAuthorizedUser")
    public ResponseEntity<User> getAuthorizedUser(Principal principal) {
        return ResponseEntity.ok().body(userService.getUserByEmail(principal.getName()));
    }

    //user по id
    @GetMapping("/getUser/{id}")
    public ResponseEntity<User> show(@PathVariable int id) {
        return ResponseEntity.ok().body(userService.getUser(id));
    }

    //создание нового user'а
    @PostMapping("/create")
    public ResponseEntity<User> create(@RequestBody User user) {
        userService.save(user);
        return ResponseEntity.ok().body(user);
    }

    //обновление user'а
    @PutMapping("/update")
    public ResponseEntity<User> update(@RequestBody User user) {
        userService.update(user);
        return ResponseEntity.ok().body(user);
    }

    //удаление user'а
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable int id) {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
