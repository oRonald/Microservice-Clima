package br.com.projeto.clima.usuario.service.mqueue;

import br.com.projeto.clima.usuario.dto.ClientDataPublish;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class UsersWeatherPublisher {

    private final RabbitTemplate rabbitTemplate;
    private final Queue queue;

    public UsersWeatherPublisher(RabbitTemplate rabbitTemplate,
                                 @Qualifier("queueClimaRequest") Queue queue) {
        this.rabbitTemplate = rabbitTemplate;
        this.queue = queue;
    }

    public void requestWeather(ClientDataPublish clientDataPublish) {
        rabbitTemplate.convertAndSend(
                queue.getName(),
                clientDataPublish);
    }
}
