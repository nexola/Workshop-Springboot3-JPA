package com.cursoudemy.curso.repositories;

import com.cursoudemy.curso.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
