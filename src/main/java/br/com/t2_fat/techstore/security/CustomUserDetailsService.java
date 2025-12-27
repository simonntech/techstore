package br.com.t2_fat.techstore.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public User loadUserByUsername(String username)
            throws UsernameNotFoundException {
        if (username.equals("admin")) {
            return new User("admin", "$2a$10$7kZUl2vTI7e/...criptografado...", List.of(() -> "ROLE_ADMIN"));
        }
        if (username.equals("cliente")) {
            return new User("cliente", "$2a$10$7kZUl2vTI7e/...criptografado...", List.of(() -> "ROLE_CLIENTE"));
        }

        throw new UsernameNotFoundException("Usuário não encontrado");
    }
}