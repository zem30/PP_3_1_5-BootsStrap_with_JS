package ru.kata.spring.boot_security.demo.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserService extends UserDetailsService {
    public List<User> showUsers();

    public void save(User user);

    public User getUser(Long id);

    public void delete(Long id);

    public void update(User user);

    public User getUserByEmail(String email);

    public List<Role> listRoles();
}
