# 📋 ToDoList_Atualizado

Este projeto é uma aplicação **Spring Boot** que implementa um sistema de gerenciamento de usuários e tarefas (**CRUD completo**) com relacionamento **1:N (Um-para-Muitos)** utilizando JPA.

---

## 🚀 Funcionalidades

### Usuário
- Criar usuário
- Listar usuários
- Buscar usuário por ID
- Deletar usuário
- Associar tarefas a um usuário

### Tarefa
- Criar tarefa vinculada a um usuário
- Listar tarefas de um usuário específico
- Atualizar tarefa
- Deletar tarefa

---

## 🔗 Relacionamento 1:N

- **Um Usuário pode ter várias Tarefas**  
- **Uma Tarefa pertence a apenas um Usuário**  
- **Não deve existir tarefa sem usuário associado**  

### Modelagem esperada

**Usuário**
- `id`
- `nome`
- `email`
- `password`
- `tarefas` (lista de tarefas)

**Tarefa**
- `id`
- `titulo`
- `descricao`
- `status`
- `beginDate`
- `endDate`
- `usuario` (referência ao usuário)

👉 A chave estrangeira (`user_id`) fica na tabela **task**.

---

## ⚙️ Configuração do Banco de Dados

No MySQL Workbench / Xampp:

```
CREATE DATABASE todo_db;
```

No arquivo `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/todo_db
spring.datasource.username=root
spring.datasource.password=rootroot

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

server.port=8080
```

---
## 🌐 Endpoints Usuários
```
    POST /usuarios → Criar usuário
```
```
    GET /usuarios → Listar usuários
```
```
    GET /usuarios/{id} → Buscar usuário por ID
```
```
    DELETE /usuarios/{id} → Deletar usuário
```
```
    POST /usuarios/{id}/tarefas → Criar tarefa vinculada a um usuário
```
```
    GET /usuarios/{id}/tarefas → Listar tarefas de um usuário específico
```

---
## Tarefas

```
    POST /tarefas → Criar tarefa (sem vínculo direto, usado apenas se necessário)
```
```
    GET /tarefas → Listar todas as tarefas
```
```
    GET /tarefas/{id} → Buscar tarefa por ID
```
```
    PUT /tarefas/{id} → Atualizar tarefa
```
```
    DELETE /tarefas/{id} → Deletar tarefa
```

---
## 📬 Exemplos de Requisições (Postman) + Prints 📸

### Criar Usuário HTTP
```
POST /usuarios
Content-Type: application/json
```
```
{
  "name": "Gabriel",
  "email": "gabriel.vereda@gmail.com",
  "password": "123456"
}
```
<img width="1289" height="619" alt="Captura de tela de 2026-02-04 10-58-46" src="https://github.com/user-attachments/assets/9931f3d0-1f99-408d-bba1-d870a64271dd" />

### Criar Tarefa vinculada a um Usuário HTTP
```
POST /usuarios/1/tarefas
Content-Type: application/json
```
```
{
  "name": "Estudar Spring Boot",
  "description": "Finalizar projeto To-Do List",
  "status": "PENDING",
  "beginDate": "2026-02-04",
  "endDate": "2026-02-10"
}
```
<img width="1289" height="619" alt="Captura de tela de 2026-02-04 11-01-27" src="https://github.com/user-attachments/assets/58e7fe95-eece-4523-a679-f983fa14069a" />

### Listar Tarefas de um Usuário HTTP
```
GET /usuarios/1/tarefas
```
<img width="1372" height="552" alt="Captura de tela de 2026-02-04 11-11-42" src="https://github.com/user-attachments/assets/eaca7825-ba1a-4f92-a629-4800fe9aca5f" />

### Atualizar Tarefa HTTP
```
PUT /tarefas/1
Content-Type: application/json
```
```
{
  "name": "Estudar Spring Boot",
  "description": "Finalizar projeto com relacionamento 1:N",
  "status": "DONE",
  "beginDate": "2026-02-04",
  "endDate": "2026-02-10"
}
```
<img width="1372" height="552" alt="Captura de tela de 2026-02-04 11-10-39" src="https://github.com/user-attachments/assets/9a094116-f908-4233-be84-84205331631f" />


### Deletar Tarefa HTTP
```
DELETE /tarefas/1
```
<img width="1372" height="552" alt="Captura de tela de 2026-02-04 11-13-08" src="https://github.com/user-attachments/assets/a81b78d5-c250-42c5-8b1b-5abfafb9d4b5" />
