# Sistema de Gerenciamento de Carteira de Investimentos

Este projeto consiste em uma API REST desenvolvida em Java com Spring Boot para o gerenciamento de ativos financeiros. A aplicação permite o cadastro, atualização e consulta de ações, integrando regras de negócio para controle de histórico e auditoria de dados.

## Requisitos de Negocio

O sistema foi projetado para atender aos seguintes critérios:

* **Identificação Única**: Cada ativo possui um ID incremental gerado pelo banco de dados e um Ticker padronizado (ex: PETR4, ORCL).
* **Auditoria Automática**: Controle de data de criação (DT_CADASTRO) e data de última modificação (DT_ALTERACAO) para cada registro, utilizando hooks do JPA (@PrePersist e @PreUpdate).
* **Segurança**: Implementação de Spring Security para proteção de endpoints e gerenciamento de acesso.
* **Normalização**: Separação clara entre as entidades de representação de banco de dados e objetos de transferência de dados (DTOs).
* **Persistência**: Armazenamento em banco de dados relacional PostgreSQL com suporte a chaves primárias automáticas via Sequences.

## Tecnologias Utilizadas

* **Java 21**: Versão utilizada para aproveitar as últimas melhorias de performance e sintaxe.
* **Spring Boot 4.0.2**: Framework base para construção da aplicação.
* **Spring Data JPA**: Para abstração da camada de persistência e comunicação com o banco de dados.
* **Spring Security**: Para autenticação e autorização.
* **PostgreSQL**: Banco de dados relacional para armazenamento dos ativos.
* **MapStruct 1.5.5**: Ferramenta para mapeamento entre Entidades e DTOs, garantindo performance em tempo de compilação.
* **Lombok**: Para redução de código boilerplate (Getters, Setters, Constructors).
* **OpenAPI 3 (Swagger)**: Documentação interativa para teste de endpoints.

## Estrutura da Aplicacao

A arquitetura segue o padrão de camadas para garantir a separação de responsabilidades:

1. **Models (Entities)**: Representam as tabelas do banco de dados com JPA.
2. **DTOs (Data Transfer Objects)**: Classes específicas para entrada (`AcaoRequisicao`), atualização (`AcaoAtualiza`) e saída (`AcaoResposta`).
3. **Repositories**: Interfaces que herdam de `JpaRepository` para operações CRUD no banco de dados.
4. **Services**: Camada de lógica de negócio, onde os mapeamentos de dados, regras de persistência e tratamentos de erro são executados.
5. **Controllers**: Expõe os endpoints REST e gerencia as respostas HTTP.
