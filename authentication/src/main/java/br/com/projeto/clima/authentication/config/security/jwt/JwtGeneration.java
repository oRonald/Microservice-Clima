package br.com.projeto.clima.authentication.config.security.jwt;

import br.com.projeto.clima.authentication.dto.UsersLoginRequest;
import br.com.projeto.clima.authentication.handler.exceptions.TokenGenerationException;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Component
@Getter
public class JwtGeneration {

    @Value("${TOKEN_SECRET}")
    private String JWT_SECRET;

    public String generateToken(UsersLoginRequest request){
        try{
            Algorithm algorithm = Algorithm.HMAC256(JWT_SECRET);
            return JWT.create()
                    .withSubject(request.getEmail())
                    .withExpiresAt(expirationDate())
                    .sign(algorithm);
        }catch (JWTCreationException e){
            throw new TokenGenerationException("Error creating token", e);
        }
    }

    private Instant expirationDate(){
        return LocalDateTime.now().plusMinutes(15).toInstant(ZoneOffset.UTC);
    }
}
