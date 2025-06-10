# pt2025-dev-mm – Prova Técnica Backend 💳

Este repositório contém a implementação do backend para a prova técnica de estágio da empresa **Move Mais**, desenvolvida com **Java 17 + Spring Boot**.  
O desafio consistia em criar uma API RESTful para simular um processo de checkout de pagamento, sem persistência de dados, seguindo boas práticas de desenvolvimento.

---

## 🚀 Tecnologias utilizadas

- **Java 17**
- **Spring Boot 3.5**
- **Gradle**
- **Spring Web**
- **Spring Validation**
- **Spring DevTools**

---

## 📁 Estrutura de pastas

```
backend/
├── controller/       # Camada de entrada (API REST)
├── service/          # Lógica de negócio (validações)
├── dto/              # Objetos de entrada/saída (Request/Response)
├── exception/        # Tratamento global de erros com @ControllerAdvice
└── BackendApplication.java
```

---

## 🔌 Como rodar o backend

### Pré-requisitos

- Java 17+ instalado
- IntelliJ IDEA, VS Code ou outra IDE compatível
- Gradle (ou use o wrapper já incluso)

### Passos para rodar localmente:

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/pt2025-dev-mm.git
   cd backend
   ```

2. Rode a aplicação:
   ```bash
   ./gradlew bootRun
   ```

3. Acesse:
   ```
   http://localhost:8080
   ```

---

## 🧪 Testando a API

### Endpoint: `POST /api/payments`

#### Exemplo de requisição:

```json
{
  "nomeTitular": "João Dev",
  "numeroCartao": "4111111111111111",
  "validade": "12/29",
  "cvv": "123",
  "cpf": "12345678900",
  "idade": 22
}
```

#### Exemplo de resposta:

```json
{
  "status": "SUCESSO",
  "mensagem": "Pagamento processado com sucesso!",
  "dados": {
    "nomeTitular": "João Dev",
    "bandeira": "Visa"
  }
}
```

#### Resposta de erro (exemplo – CPF inválido):

```json
{
  "status": "FALHA",
  "mensagem": "CPF é obrigatório.",
  "dados": null
}
```

---

## ✅ Funcionalidades implementadas

- [x] Estrutura com Spring Boot (Java 17)
- [x] Endpoint `POST /api/payments`
- [x] DTOs com validações via `jakarta.validation`
- [x] Simulação de lógica de negócio:
  - CPF válido
  - Idade mínima de 18 anos
  - Validade do cartão futura
  - Identificação da bandeira (Visa / MasterCard)
- [x] Desmascaramento manual de dados (ex: CPF)
- [x] Respostas padronizadas com `status`, `mensagem`, `dados`
- [x] Tratamento global de erros com `@ControllerAdvice`

---

## 📌 Observações

- Nenhum dado é salvo ou persistido (simulação completa em tempo de execução)
- O foco foi aplicar boas práticas de estrutura, validação e retorno amigável
- Pronto para ser consumido por um frontend React ou outras interfaces

---

## 🤓 Desenvolvedor

Feito com empenho e muito aprendizado por Henrique Rossin – em preparação para uma vaga de estágio 🚀
