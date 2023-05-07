package com.cursoudemy.curso.config;

import com.cursoudemy.curso.entities.User;
import com.cursoudemy.curso.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration // Informa ao JPA que esta é uma classe de configuração
@Profile("test") // Indica em qual perfil a configuração irá rodar
public class TestConfig implements CommandLineRunner {

    @Autowired // Injeção de dependencia
    private UserRepository userRepository;


    @Override
    public void run(String... args) throws Exception { // Executa tudo o que estiver dentro desse método quando a aplicação for iniciada

        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

         userRepository.saveAll(Arrays.asList(u1, u2)); // Salva tudo na entidade

    }
}
