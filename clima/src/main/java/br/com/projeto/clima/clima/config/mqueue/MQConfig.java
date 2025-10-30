package br.com.projeto.clima.clima.config.mqueue;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MQConfig {

    @Value("${mq.queue.clima-request}")
    private String requestClimaRequest;

    @Value("${mq.queue.clima-response}")
    private String requestClimaResponse;

    @Bean
    public Queue queueClimaRequest(){
        return new Queue(requestClimaRequest, true);
    }

    @Bean
    public Queue queueClimaResponse(){
        return new Queue(requestClimaResponse, true);
    }
}
