package br.com.projeto.clima.usuario.handler;

import br.com.projeto.clima.usuario.handler.exceptions.EmailAlreadyExistsException;
import br.com.projeto.clima.usuario.handler.exceptions.EmailDoesNotExistsException;
import common.exception.GlobalErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalHandler {

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<GlobalErrorResponse> emailAlreadyExists(EmailAlreadyExistsException e){
        GlobalErrorResponse globalErrorResponse = GlobalErrorResponse.builder()
                .status(409)
                .error("Login error")
                .message("Tried to register a new user with and email already used")
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.CONFLICT).body(globalErrorResponse);
    }

    @ExceptionHandler(EmailDoesNotExistsException.class)
    public ResponseEntity<GlobalErrorResponse> emailDoesNotExists(EmailDoesNotExistsException e){
        GlobalErrorResponse globalErrorResponse = GlobalErrorResponse.builder()
                .status(403)
                .error("Bad request")
                .message("Email informed does not exists")
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(globalErrorResponse);
    }
}
