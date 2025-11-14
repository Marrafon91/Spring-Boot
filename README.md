# Spring Boot Studies Repository

Bem-vindo ao meu repositório de estudos sobre **Spring Boot**! 🚀

Este repositório reúne exercícios, projetos, anotações e práticas que desenvolvi enquanto estudo o ecossistema Spring, incluindo Spring Boot, Spring MVC, Spring Data JPA, testes unitários, containers Docker e muito mais.

---

## 📚 Objetivo do Repositório

O objetivo principal deste repositório é documentar minha evolução no desenvolvimento Java com Spring Boot, praticando:

* Criação de APIs REST
* Integração com bancos de dados usando **Spring Data JPA**
* Configurações com **application.properties** e **application.yml**
* Tratamento de erros e exceções personalizadas
* Testes com **JUnit** e **Mockito**
* Dockerização de aplicações Spring Boot
* Boas práticas de código e arquitetura

---

## 🛠️ Tecnologias Utilizadas

* **Java 21**
* **Spring Boot**
* **Spring Web**
* **Spring Data JPA**
* **Spring Validation**
* **Spring Security**
* **Hibernate**
* **Lombok**
* **PostgreSQL / H2 Database**
* **JUnit 5 & Mockito**
* **Docker & Docker Compose**

---

## 📂 Estrutura do Repositório

```
Spring-Boot/
 ├── src/
 │   ├── main/java/...  # Código-fonte principal
 │   ├── resources/     # Configurações, SQL e dados
 │   └── test/          # Testes automatizados
 ├── Dockerfile         # Dockerização da aplicação
 ├── docker-compose.yml # Serviços auxiliares
 └── README.md
```

---

## 🔍 Conteúdos de Estudo

### ✅ 1. CRUD Completo com Spring MVC + JPA

* Controllers REST
* Serviços e Regras de Negócio
* Repositórios JPA
* Respostas HTTP adequadas (201, 204, 404, 400)

### ✅ 2. Testes Unitários e de Integração

* Mockito para simulação de dependências
* JUnit 5
* Assertivas profissionais

### ✅ 3. Banco de Dados e Mapeamento ORM

* Entidades
* Relacionamentos
* Validações com Jakarta Bean Validation

### ✅ 4. Dockerização da Aplicação

* Dockerfile personalizado
* Subida do banco via Docker Compose

### ✅ 5. Segurança com Spring Security

* Autenticação básica e JWT
* Autorização por roles (RBAC)
* Configuração de filtros e exception handlers de segurança
* Integração com banco de dados para usuários e permissões
* Testes de segurança (mocking de usuários/autenticação)

### ✅ 6. Logs, Exceptions & Boas Práticas

* @ControllerAdvice
* Exceptions customizadas
* Padrões de resposta para erros

---

## 🚀 Como Executar o Projeto

### **1️⃣ Rodar com Maven**

```
mvn spring-boot:run
```

### **2️⃣ Rodar com Docker**

```
docker build -t spring-boot-studies .
docker run -p 8080:8080 spring-boot-studies
```

### **3️⃣ Rodar com Docker Compose**

```
docker-compose up --build
```

---

## 🧪 Testes

Para rodar os testes:

```
mvn test
```

---

## 📝 Aprendizados em Progresso

* [ ] Clean Architecture
* [x] Spring Security
* [ ] Mensageria com RabbitMQ
* [ ] Deploy em AWS

---

## 📫 Contato

Se quiser trocar ideias sobre Java, Spring ou desenvolvimento em geral:

* **GitHub**: [https://github.com/Marrafon91](https://github.com/Marrafon91)

---

Obrigado por visitar! 😄
