package ru.kata.spring.boot_security.demo.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserService extends UserDetailsService {
    public List<User> showUsers();

    public void save(User user);

    public User getUser(int id);

    public void delete(int id);

    public void update(User user);

    public User findByUsername(String username);

    public List<Role> listRoles();
}
