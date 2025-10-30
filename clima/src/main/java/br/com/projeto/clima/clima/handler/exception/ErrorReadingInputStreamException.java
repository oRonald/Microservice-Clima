package br.com.projeto.clima.clima.handler.exception;

import java.io.IOException;

public class ErrorReadingInputStreamException extends RuntimeException {

    public ErrorReadingInputStreamException(String message) {
        super(message);
    }
}
