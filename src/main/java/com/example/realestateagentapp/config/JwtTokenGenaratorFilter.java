package com.example.realestateagentapp.config;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.util.Collection;
import java.util.Date;

public class JwtTokenGenaratorFilter extends OncePerRequestFilter {

    /*
     * Метод doFilterInternal выполняет основную логику фильтра.
     * Он получает аутентификацию из SecurityContextHolder, генерирует токен JWT на основе аутентификации и добавляет его в заголовок ответа.
     * Затем передает управление следующему фильтру в цепочке (если есть).
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (null != authentication) {
            SecretKey key = Keys.hmacShaKeyFor(SecurityConstants.JWT_KEY.getBytes());

            String jwt = Jwts.builder()
                    .setIssuer("Ashish")
                    .setSubject("JWT TOKEN")
                    .claim("username", authentication.getName())
                    .claim("role", getRole(authentication.getAuthorities()))
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(new Date().getTime() + 30000000))
                    .signWith(key).compact();

            response.setHeader(SecurityConstants.JWT_HEADER, jwt);
        }

        filterChain.doFilter(request, response);
    }

    /*
     * Метод getRole возвращает роль пользователя из переданной коллекции разрешений.
     * В данном случае, он перебирает разрешения и возвращает первую найденную роль.
     */
    private String getRole(Collection<? extends GrantedAuthority> authorities) {
        String role = "";

        for (GrantedAuthority au : authorities) {
            role = au.getAuthority();
        }

        return role;
    }

    /*
     * Метод shouldNotFilter определяет, нужно ли пропустить фильтрацию для данного запроса.
     * В данном случае, фильтрация будет пропущена только для запросов, соответствующих "/signIn".
     */
    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        return !request.getServletPath().equals("/signIn");
    }
}
