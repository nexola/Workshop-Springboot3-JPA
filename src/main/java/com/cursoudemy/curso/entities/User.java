package com.cursoudemy.curso.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity // Informa que a classe também é uma entidade (tabela), a partir disso, a JPA liga a entidade a uma tabela de mesmo nome no database
@Table(name = "tb_user") // Nome da tabela do database, renomeando para não dar conflito
public class User implements Serializable { // Serializable salva o arquivo em formato binário para poder ser usado posteriormente

    @Id // Informa ao JPA o campo primário da tabela
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Define que o valor primário terá geração de auto incrementação a cada registro no database
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String password;

    @JsonIgnore // Annotation para corrigir problemas com o jackson
    @OneToMany(mappedBy = "client") // Um para muitos, mapeado do outro lado por "client"
    private List<Order> orders = new ArrayList<>();

    public User() {}

    public User(Long id, String name, String email, String phone, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Order> getOrders() {
        return orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
