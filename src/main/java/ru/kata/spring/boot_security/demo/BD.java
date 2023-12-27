package ru.kata.spring.boot_security.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.repository.RoleRepository;
import ru.kata.spring.boot_security.demo.service.UserService;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;
//
//@Component
//public class BD {
//
//
//    private UserService userService;
//    private RoleRepository roleRepository;
//
//
//    @Autowired
//    public BD(UserService userService, RoleRepository roleRepository) {
//        this.userService = userService;
//        this.roleRepository = roleRepository;
//    }
//
//    @PostConstruct
//    private void loadTestUsers() {
//
//
//        Role adminRole = new Role();
//        adminRole.setRole("ROLE_ADMIN");
//        Role userRole = new Role();
//        userRole.setRole("ROLE_USER");
//        roleRepository.save(userRole);
//        roleRepository.save(adminRole);
//
//        Set<Role> roles = new HashSet<>();
//        roles.add(adminRole);
//        roles.add(userRole);
//        User userAdmin = new User("admin", "Kalinina", 28, "admin", "admin@yandex.ru");
//        userAdmin.setRoles(userAdmin.getRoles());
//        userAdmin.setRoles(roles);
//        userService.save(userAdmin);
//
//        roles.clear();
//        User user1 = new User("user", "Kalinin", 25, "user", "user@yandex.ru");
//        roles.add(userRole);
//        user1.setRoles(roles);
//        userService.save(user1);
//    }
//}
