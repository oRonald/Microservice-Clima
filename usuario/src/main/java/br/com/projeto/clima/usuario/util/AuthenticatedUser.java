package br.com.projeto.clima.usuario.util;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthenticatedUser {

    @Autowired
    private HttpServletRequest request;

    public String getEmail(){
        return request.getHeader("X-User-Email");
    }
}
