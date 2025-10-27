package br.com.projeto.clima.authentication.handler;

import br.com.projeto.clima.authentication.handler.exceptions.ClientDataNotFoundException;
import br.com.projeto.clima.authentication.handler.exceptions.CommunicationErrorException;
import com.auth0.jwt.exceptions.JWTCreationException;
import common.exception.GlobalErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalHandler {


    @ExceptionHandler(JWTCreationException.class)
    public ResponseEntity<GlobalErrorResponse> tokenCreationException(JWTCreationException exception){
        GlobalErrorResponse globalErrorResponse = GlobalErrorResponse.builder()
                .status(HttpStatus.UNAUTHORIZED.value())
                .error("Error creating token")
                .message(exception.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(globalErrorResponse);
    }

    @ExceptionHandler(ClientDataNotFoundException.class)
    public ResponseEntity<String> clientDataNotFound(ClientDataNotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(CommunicationErrorException.class)
    public ResponseEntity<String> communcationError(CommunicationErrorException e){
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(e.getMessage());
    }
}
