package br.com.projeto.clima.usuario.config.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MQConfig {

    @Value("${mq.queue.clima-request}")
    private String requestClimaRequest;

    @Bean
    public Queue queueClimaRequest(){
        return new Queue(requestClimaRequest, true);
    }
}
