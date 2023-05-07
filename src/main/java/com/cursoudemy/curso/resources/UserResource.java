package com.cursoudemy.curso.resources;

import com.cursoudemy.curso.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Retorna os dados gravados no endereço web como JSON ou XML
@RequestMapping(value = "/users") // Endereço pós url do local especificado
public class UserResource {

    @GetMapping // Notação composta que serve como atalho para o RequestMapping
    public ResponseEntity<User> findAll() {
        User u = new User(1L, "Maria", "maria@gmail.com", "99999999", "12345");
        return ResponseEntity.ok().body(u);
    }
}
