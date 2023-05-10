package com.cursoudemy.curso.resources;

import com.cursoudemy.curso.entities.User;
import com.cursoudemy.curso.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @GetMapping(value = "/{id}") // Adiciona mais uma camada a url, utilizando como valor a variável dentro das chaves
    public ResponseEntity<User> findById(@PathVariable Long id) { // PathVariable utiliza o parâmetro da url como variável
        User obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User obj) { // RequestBody indica que o recurso não será enviado ou recebido por meio de uma página Web
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
