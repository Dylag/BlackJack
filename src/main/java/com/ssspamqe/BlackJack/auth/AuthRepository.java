package com.ssspamqe.BlackJack.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface AuthRepository extends JpaRepository<User, Integer> {
    @Query(value = """
                    SELECT u FROM User u
                    WHERE u.username = ?1""")
    Optional<User> findByName(String name);
}