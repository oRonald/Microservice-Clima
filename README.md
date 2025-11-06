<h1>
  <span>Consulta de Clima com Microsserviços</span>
  <img width="50" height="50" alt="logo" src="https://github.com/user-attachments/assets/28b6f7ee-883f-445f-9d40-550650734044" />
</h1>

<p>Um sistema desenvolvido em Spring Boot com arquitetura baseada em microsserviços e mensageria assíncrona.</p> 
Permite que um usuário se cadastre e consulte o clima atual de sua cidade.
A cidade é obtida automaticamente no momento do cadastro e usada para buscar dados na API externa da Weatherstack.

## 🧱 Arquitetura:
- Discovery (Eureka Server).
- Gateway com Spring WebFlux.
- Spring Security para autenticação e autorização via Keycloak.
- Microsserviço de usuário (registrar e buscar clima).
- Microsserviço de clima (responsável por consultar a API da Weatherstack e salvar a resposta em cache para utilização pelo usuário).
- RabbitMQ utilizado para o fluxo assíncrono entre serviços.
- Redis utilizado com Cache para armazenar a consulta mais recente com um TTL de 15 minutos, com o objetivo de reduzir latência.
- PostgreSQL para persistência de usuários.
- Docker Compose para orquestração de conteineres.

## ⚙️ Fluxo
1. O usuário realiza o cadastro.
2. O sistema identifica sua cidade e envia um pedido de clima via RabbitMQ.
3. O serviço clima consome a mensagem, consulta a API Weatherstack e retorna a resposta.
4. O resultado é armazenado no Redis com TTL de 15 minutos.
5. Caso o usuário solicite novamente dentro desse período, o dado é retornado do cache.

## 🔎 Design Patterns usados:
- Builder
- Data Transfer Object
- Strategy Pattern

## 🧰 Tecnologias
- Java 17
- Spring Boot (Security, JPA, Web, AMQP)
- Spring Cloud Netflix (Discovery, Gateway)
- Spring Cloud Open Feign
- Keycloak
- Redis (cache)
- PostgreSQL
- Docker / Docker Compose
- Mensageria com RabbitMQ
