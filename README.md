## 💻 Objetivo do projeto

Rest api para simular rotinas bancárias

## Diagrama de classe:
```mermaid
classDiagram
    class User {
        +String name
        +Account account
        +Feature[] features
        +Card card
        +News[] new
    }

    class Account {
        +String number
        +String agency
        +float balance
        +float limit
    }

    class Feature {
        +String icon
        +String description
    }

    class Card {
        +String number
        +float limit
    }

    class News {
        +String icon
        +String description
    }

    User --> Account
    User --> Feature
    User --> Card
    User --> News
```


## 🛠 Tecnologias

As seguintes tecnologias foram utilizadas no desenvolvimento da API Rest do projeto:

- **[Java 17](https://www.oracle.com/java)**
- **[Spring Boot 3](https://spring.io/projects/spring-boot)**
- **[Gradle](https://gradle.org/)**
- **[PostgreSQL](https://www.postgresql.org/)**
- **[Lombok](https://projectlombok.org)**
- **[H2 Database](com.h2database)**
