# 💸 Payments Service - PIX com Spring Boot, Kafka e PostgreSQL

[![Java](https://img.shields.io/badge/Java-21-blue.svg)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![Docker](https://img.shields.io/badge/Docker-Compose-blue.svg)](https://www.docker.com/)
[![Kafka](https://img.shields.io/badge/Apache_Kafka-Event_Driven-black.svg)](https://kafka.apache.org/)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

Este projeto tem como objetivo simular um **serviço de pagamentos via PIX**, utilizando uma **arquitetura orientada a eventos**, com **Spring Boot**, **Apache Kafka**, **PostgreSQL** e **Docker**.

Projeto de estudo/teste com foco em:

* Produção e consumo de eventos com Kafka
* Transações financeiras simuladas
* Criação de usuários via eventos
* Arquitetura baseada em microsserviços
* Comunicação assíncrona com Kafka

---

## 🚀 Tecnologias Utilizadas

* **Java 21**
* **Spring Boot**
* **Apache Kafka**
* **Kafka UI**
* **PostgreSQL**
* **Docker e Docker Compose**

---

## 🛠️ Como Rodar Localmente

### Pré-requisitos

* [Docker](https://www.docker.com/) instalado
* [DBeaver](https://dbeaver.io/) ou [pgAdmin](https://www.pgadmin.org/) (opcional, para visualização do banco)

### Passo a passo

1. **Clone o repositório**

```bash
git clone https://github.com/henriqueHfr/payments-service.git
cd payments-service
```

2. **Atualize o IP local**

No arquivo `src/main/resources/application.yaml`, altere o valor de `bootstrap-servers` para o IP local da sua máquina, por exemplo:

```yaml
bootstrap-servers: 192.168.0.X:9092
```

No arquivo `docker-compose.yml`, altere também a variável de ambiente:

```yaml
KAFKA_CFG_ADVERTISED_LISTENERS: PLAINTEXT://<SEU_IP_LOCAL>:9092
```

> ⚠️ Essa configuração é necessária para o Kafka UI funcionar corretamente e permitir acesso externo ao container Kafka.

3. **Suba os containers**

```bash
docker-compose up --build
```

4. **Execute a aplicação Spring Boot**

Você pode rodar pela sua IDE (IntelliJ, VS Code, etc.) ou via terminal com Maven:

```bash
./mvnw spring-boot:run
```

---

## 📦 Estrutura do Projeto

```
├── config/          # Configurações do Kafka
├── controller/      # Controladores de entrada (rotas HTTP)
├── event/           # Lógica de eventos Kafka (producers, listeners)
├── exception/       # Exceções customizadas para tratamento de erros
├── models/          # Modelos de entidades (AccountUserModel, PixPaymentModels etc.)
├── repository/      # Interfaces JPA para acesso ao banco
├── service/         # Regras de negócio (transações, validações etc.)
├── utils/           # Utilitários e conversores auxiliares
```

---

## 📫 Exemplos de Requisições (Payloads)

### ✅ Criar Usuário

`POST http://localhost:8080/auth/create/user`

#### 🔹 Payload - Usuário João Silva

```json
{
  "userName": "João Silva",
  "userEmail": "joao.silva1@example.com",
  "userCpf": "01230123011",
  "userPhone": "+5511999999991",
  "userAddress": "Rua das Flores, 123",
  "userCity": "São Paulo",
  "userState": "SP",
  "userCountry": "Brasil",
  "userPostalCode": "01000-000",
  "userPixKey": "01230123011",
  "userPixKeyType": "CPF",
  "userValueBalance": 1500.75,
  "userLastTransactionId": "TX123456789",
  "userLastTransactionDate": "2023-10-01T15:30:00",
  "userLastTransactionAmount": "250.00"
}
```

#### 🔹 Payload - Usuário Henrique Teste

```json
{
  "userName": "Henrique Teste",
  "userEmail": "teste@teste.com",
  "userCpf": "12312312311",
  "userPhone": "+5511999999992",
  "userAddress": "Rua das Flores, 123",
  "userCity": "São Paulo",
  "userState": "SP",
  "userCountry": "Brasil",
  "userPostalCode": "01000-000",
  "userPixKey": "12312312311",
  "userPixKeyType": "CPF",
  "userValueBalance": 1500.00,
  "userLastTransactionId": "TX123456789",
  "userLastTransactionDate": "2023-10-01T15:30:00",
  "userLastTransactionAmount": "250.00"
}
```

---

### ✅ Enviar Pagamento PIX

`POST http://localhost:8080/payments/pix/send`

```json
{
  "pixKey": "12312312311",
  "pixKeyType": "CPF",
  "transactionId": "",
  "amount": 350.00,
  "comments": "oi amigo, tudo bem?",
  "userSendingId": 1
}
```

---

## 🤝 Como Contribuir

1. Faça um fork do projeto
2. Crie uma nova branch:

```bash
git checkout -b feature/sua-feature
```

3. Commit suas alterações:

```bash
git commit -m 'feat: minha nova feature'
```

4. Push para o seu repositório:

```bash
git push origin feature/sua-feature
```

5. Abra um **Pull Request**

---

## 📬 Contato

Desenvolvido por [Henrique Fernandes](https://github.com/henriqueHfr)

---

## ⚖️ Licença

Este projeto está licenciado sob a **MIT License**.
