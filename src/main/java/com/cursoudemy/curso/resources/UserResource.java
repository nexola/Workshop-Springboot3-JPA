package com.cursoudemy.curso.resources;

import com.cursoudemy.curso.entities.User;
import com.cursoudemy.curso.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // Retorna os dados gravados no endereço web como JSON ou XML
@RequestMapping(value = "/users") // Endereço pós url do local especificado
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping // Notação composta que serve como atalho para o RequestMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> list = service.findAll();
        return ResponseEntity.ok().body(list); // Retorna como corpo o objeto passado como parâmetro
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) { // PathVariable utiliza o parâmetro da url como variável
        User obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}
