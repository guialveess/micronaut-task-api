# Micronaut Task API

API REST de gerenciamento de tarefas (to-do list) construída com **Micronaut** e organizada em **Arquitetura Hexagonal (Ports & Adapters)**. Projeto de estudo para explorar o framework Micronaut e os princípios de separação entre domínio, aplicação e infraestrutura.

## Arquitetura

O código é dividido em três camadas, seguindo a ideia de portas e adaptadores:

```
src/main/java/com/guiialves/
├── domain/                  # Regras de negócio puras, sem dependência de framework
│   ├── model/               # Entidades de domínio (Task)
│   └── exception/           # Exceções de domínio
├── application/              # Casos de uso (orquestração do domínio)
│   ├── port/in/              # Portas de entrada (interfaces dos use cases)
│   ├── port/out/             # Portas de saída (interfaces para persistência, etc.)
│   └── service/              # Implementação dos casos de uso
└── infrastructure/           # Adaptadores (detalhes técnicos)
    ├── in/web/                # Controllers HTTP
    ├── in/dto/                # DTOs de request/response
    └── out/persistence/       # Repositórios JDBC, entidades e mappers
```

A ideia central: o `domain` não conhece nada do Micronaut, HTTP ou banco de dados. A camada `application` define *o que* o sistema faz através de ports; a `infrastructure` implementa *como* isso é feito (REST + PostgreSQL via Micronaut Data JDBC).

## Stack

- **Java 21**
- **Micronaut 4.10.18**
- **Micronaut Data JDBC** + **PostgreSQL**
- **Flyway** para migrações de banco
- **Micronaut Validation** / Jakarta Validation
- **Micronaut Serialization (Jackson)**
- **OpenAPI / Swagger UI / Scalar** para documentação da API
- **JUnit 5 + Mockito** para testes
- **Docker Compose** (PostgreSQL)
- **Lombok**

## Como executar

### Pré-requisitos
- JDK 21
- Docker (para o banco de dados)

### Subindo o banco de dados

```bash
docker compose up -d
```

Isso inicia um PostgreSQL em `localhost:5432` (database `tarefas`, usuário/senha `postgres`).

### Rodando a aplicação

```bash
./mvnw mn:run
```

A API fica disponível em `http://localhost:8080`.

### Variáveis de ambiente

| Variável       | Padrão                                         | Descrição                  |
|----------------|-------------------------------------------------|-----------------------------|
| `JDBC_URL`     | `jdbc:postgresql://localhost:5432/tarefas`      | URL de conexão com o banco  |
| `JDBC_USER`    | `postgres`                                      | Usuário do banco            |
| `JDBC_PASSWORD`| `postgres`                                      | Senha do banco              |

### Testes

```bash
./mvnw test
```

## Documentação da API

Com a aplicação em execução:

- Swagger UI: `http://localhost:8080/swagger-ui`
- Scalar: `http://localhost:8080/scalar`

## Endpoints

| Método | Rota      | Descrição          |
|--------|-----------|---------------------|
| POST   | `/tasks`  | Cria uma nova tarefa |

Exemplo de requisição:

```bash
curl -X POST http://localhost:8080/tasks \
  -H "Content-Type: application/json" \
  -d '{"title": "Estudar Micronaut", "description": "Praticar arquitetura hexagonal"}'
```

## Migrações

As migrações do banco (Flyway) ficam em `src/main/resources/db/migration` e são aplicadas automaticamente na inicialização da aplicação.
