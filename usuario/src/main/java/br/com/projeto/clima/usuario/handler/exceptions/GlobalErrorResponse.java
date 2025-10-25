package br.com.projeto.clima.usuario.handler.exceptions;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
public class GlobalErrorResponse {

    private int status;
    private String error;
    private String message;
    private LocalDateTime timestamp;
}
