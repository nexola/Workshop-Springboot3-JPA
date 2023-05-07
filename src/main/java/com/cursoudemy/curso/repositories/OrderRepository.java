package com.cursoudemy.curso.repositories;

import com.cursoudemy.curso.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {}
