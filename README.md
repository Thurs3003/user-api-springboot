# User API Spring Boot

API REST desenvolvida com Java e Spring Boot para gerenciamento de usuários.

---

## 📌 Sobre o projeto

Este projeto foi desenvolvido com o objetivo de praticar e consolidar conceitos de desenvolvimento back-end utilizando Java e Spring Boot, incluindo construção de APIs REST, integração com banco de dados e organização em camadas.

---

## 🚀 Funcionalidades

- Criar usuário  
- Listar usuários  
- Buscar usuário por ID  
- Atualizar usuário  
- Deletar usuário  
- Validação de campos obrigatórios  
- Validação de e-mail único  
- Respostas HTTP com ResponseEntity  
- Tratamento global de erros  
- Documentação com Swagger  
- Persistência com MySQL  

---

## 🛠 Tecnologias

- Java  
- Spring Boot  
- Spring Data JPA  
- MySQL  
- Maven  
- Swagger / OpenAPI  
- Postman  

---

## 📂 Estrutura do projeto

```text
userapi
├── controller
├── service
├── repository
├── entity
├── exception
```


## 🔗 Endpoints principais
```md

| Método | Endpoint      | Descrição         |
|--------|-------------|-------------------|
| GET    | /users      | Lista usuários    |
| GET    | /users/{id} | Busca por ID      |
| POST   | /users      | Cria usuário      |
| PUT    | /users/{id} | Atualiza usuário  |
| DELETE | /users/{id} | Remove usuário    |