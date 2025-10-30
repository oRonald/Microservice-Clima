package br.com.projeto.clima.usuario.service.mqueue;

import br.com.projeto.clima.usuario.dto.WeatherResponse;
import br.com.projeto.clima.usuario.service.usuario.implementation.UsuarioClimateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class UsersWeatherSubscriber {

    private final UsuarioClimateService service;

    @RabbitListener(queues = "${mq.queue.clima-response}")
    public void getResponse(@Payload WeatherResponse response){
        if(response != null){
            service.putResponse(response.getRequestId(), response);
        }
    }
}
