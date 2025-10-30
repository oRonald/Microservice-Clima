package br.com.projeto.clima.clima.service.mqueue;

import br.com.projeto.clima.clima.dto.WeatherResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UsersWeatherPublisher {

    private final RabbitTemplate template;
    private final Queue queue;

    public UsersWeatherPublisher(RabbitTemplate template,
                                 @Qualifier("queueClimaResponse") Queue queue) {
        this.template = template;
        this.queue = queue;
    }

    public void sendResponse(WeatherResponse response){
        template.convertAndSend(queue.getName(), response);
    }
}
