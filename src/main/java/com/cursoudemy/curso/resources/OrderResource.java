package com.cursoudemy.curso.resources;

import com.cursoudemy.curso.entities.Order;
import com.cursoudemy.curso.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // Retorna os dados gravados no endereço web como JSON ou XML
@RequestMapping(value = "/orders") // Endereço pós url do local especificado
public class OrderResource {

    @Autowired
    private OrderService service;

    @GetMapping // Notação composta que serve como atalho para o RequestMapping
    public ResponseEntity<List<Order>> findAll() {
        List<Order> list = service.findAll();
        return ResponseEntity.ok().body(list); // Retorna como corpo o objeto passado como parâmetro
    }

    @GetMapping(value = "/{id}") // Adiciona mais uma camada a url, utilizando como valor a variável dentro das chaves
    public ResponseEntity<Order> findById(@PathVariable Long id) { // PathVariable utiliza o parâmetro da url como variável
        Order obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}
