<h1>
  <span>Consulta de Clima com Microsserviços</span>
  <img width="50" height="50" alt="logo" src="https://github.com/user-attachments/assets/28b6f7ee-883f-445f-9d40-550650734044" />
</h1>

Backend implementando um consulta de clima por cidade registrada no cadastro do usuário a partir de uma API externa da Weatherstack.

## Serviços implementados:
- Discovery
- Gateway com Spring WebFlux
- Microsserviço de usuário (registrar e buscar clima)
- Microsserviço de clima (responsável por consultar a API da Weatherstack e salvar a resposta em cache para utilização pelo usuário)

## Design Patterns usados:
- Builder
- Data Transfer Object
- Strategy Pattern

## Tecnologias
- Java 17
- Spring Boot (Security, JPA, Web)
- Spring Cloud Netflix (Discovery, Gateway)
- Spring Cloud Open Feign
- Redis (cache)
- PostgreSQL
- Docker
- Mensageria com RabbitMQ
