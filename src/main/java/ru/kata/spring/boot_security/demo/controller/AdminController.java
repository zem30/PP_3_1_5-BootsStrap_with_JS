package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;
import ru.kata.spring.boot_security.demo.service.UserServiceImpl;

import java.security.Principal;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/adminview")
    public String showInfoAllUser(Model model, Principal principal) {
        model.addAttribute("user",userService.getUserByEmail(principal.getName()));
        return "adminview";
    }


    @GetMapping("/new")
    public String newUser(Model model, @ModelAttribute("user") User user, Principal principal) {
        model.addAttribute("admin", userService.getUserByEmail(principal.getName()));
        model.addAttribute("listRoles", userService.listRoles());
        return "new";
    }

    @PostMapping()
    public String saveUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/admin";
    }

    @GetMapping("/update/{id}")
    public String updateUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        model.addAttribute("listRoles", userService.listRoles());
        return "redirect:/admin";
    }
    @PatchMapping("/update/{id}")
    public String saveUpdateUser(@ModelAttribute("user") User user,Model model) {
        model.addAttribute("listRoles", userService.listRoles());
        userService.update(user);
        return "redirect:/admin";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/admin";
    }
}
