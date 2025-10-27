package br.com.projeto.clima.authentication.handler.exceptions;

import com.auth0.jwt.exceptions.JWTCreationException;

public class TokenGenerationException extends JWTCreationException {

    public TokenGenerationException(String message, Throwable cause) {
        super(message, cause);
    }
}
