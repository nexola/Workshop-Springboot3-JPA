package com.cursoudemy.curso.repositories;

import com.cursoudemy.curso.entities.Category;
import com.cursoudemy.curso.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {}
