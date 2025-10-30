package br.com.projeto.clima.clima.feign.decoder;

import br.com.projeto.clima.clima.handler.exception.ErrorReadingInputStreamException;
import br.com.projeto.clima.clima.handler.exception.WeatherStackException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class FeignErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String s, Response response) {
        String errorBody = "Unknown error";
        try{
            if(response.body() != null){
                errorBody = new String(response.body().asInputStream().readAllBytes());
            }
        } catch (IOException e) {
            throw new ErrorReadingInputStreamException(e.getMessage());
        }

        return new WeatherStackException(
                "Error calling Weatherstack API",
                response.status(),
                errorBody
        );
    }
}
