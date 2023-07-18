package com.example.realestateagentapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.realestateagentapp.entity.Users;
import com.example.realestateagentapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UsersDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepo;

    /*
     * Метод loadUserByUsername загружает информацию о пользователе по его имени пользователя.
     * В случае успешного нахождения пользователя, возвращается объект UserDetails, представляющий пользователя.
     * Если пользователь не найден, выбрасывается исключение UsernameNotFoundException.
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> opt = userRepo.findByUserEmail(username);

        if (opt.isPresent()) {
            Users users = opt.get();

            // Создаем список разрешений для пользователя
            List<GrantedAuthority> authority = new ArrayList<>();
            SimpleGrantedAuthority sga = new SimpleGrantedAuthority(users.getRole());
            authority.add(sga);

            // Создаем и возвращаем объект UserDetails, представляющий пользователя
            return new User(users.getUserEmail(), users.getUserPassword(), authority);
        } else {
            // Если пользователь не найден, выбрасываем исключение BadCredentialsException
            throw new BadCredentialsException("The User with this username was not found: " + username);
        }
    }
}