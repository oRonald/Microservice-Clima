package br.com.projeto.clima.clima.service.mqueue;

import br.com.projeto.clima.clima.dto.ClientDataSubscriber;
import br.com.projeto.clima.clima.service.weather.WeatherService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class UsersWeatherSubscriber {

    private final WeatherService service;

    @RabbitListener(queues = "${mq.queue.clima-request}")
    public void receiveWeatherRequest(@Payload ClientDataSubscriber payload){
        service.getWeatherRequest(payload);
    }
}
