package ru.kata.spring.boot_security.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("Select u from User u left join fetch u.roles where u.email=:email")
    User getUserByEmail(String email);
}
