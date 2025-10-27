package br.com.projeto.clima.authentication.handler.exceptions;

public class ClientDataNotFoundException extends RuntimeException{

    public ClientDataNotFoundException(String message) {
        super(message);
    }
}
