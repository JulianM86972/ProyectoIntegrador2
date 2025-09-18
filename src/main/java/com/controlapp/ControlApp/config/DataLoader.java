package com.controlapp.ControlApp.config;

import com.controlapp.ControlApp.model.Rol;
import com.controlapp.ControlApp.model.Usuario;
import com.controlapp.ControlApp.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner initDatabase(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            // Crear usuario ADMIN si no existe
            if (usuarioRepository.findByUsername("admin").isEmpty()) {
                Usuario admin = Usuario.builder()
                        .username("admin")
                        .password(passwordEncoder.encode("admin123"))
                        .rol(Rol.ADMIN)
                        .build();
                usuarioRepository.save(admin);
                System.out.println("Usuario admin creado: admin/admin123");
            }

            // Crear usuario USER si no existe
            if (usuarioRepository.findByUsername("usuario").isEmpty()) {
                Usuario user = Usuario.builder()
                        .username("usuario")
                        .password(passwordEncoder.encode("password123"))
                        .rol(Rol.USER)
                        .build();
                usuarioRepository.save(user);
                System.out.println("Usuario user creado: usuario/password123");
            }
        };
    }
}