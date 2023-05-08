package com.cursoudemy.curso.services;

import com.cursoudemy.curso.entities.Category;
import com.cursoudemy.curso.entities.Product;
import com.cursoudemy.curso.repositories.CategoryRepository;
import com.cursoudemy.curso.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Registra uma dependência Spring
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product findById(Long id) {
        Optional<Product> obj = repository.findById(id);
        return obj.get();
    }
}
