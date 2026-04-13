🚧 Projeto em evolução – Automação de API com RestAssured e Cucumber

## Objetivo
Projeto criado para estudo e consolidação de automação de APIs REST,
simulando um cenário real de projeto em evolução e boas práticas de automação backend.

## API utilizada

Este projeto utiliza a **API pública ServeRest**, amplamente usada para fins educacionais,
como base para a automação dos cenários de teste.

A API foi escolhida por disponibilizar endpoints de usuários, login e produtos, permitindo
a prática de automação de fluxos autenticados e não autenticados sem dependência de
infraestrutura local.

Documentação da API: https://serverest.dev/

## Funcionalidades implementadas
- Estrutura de automação baseada em Service Layer
- Organização dos steps por responsabilidade e domínio
- Automação dos endpoints de usuários (GET, POST, busca por ID e DELETE)
- Automação do endpoint de login com validação e extração de token, organizada em feature e steps próprios
- Automação do endpoint de cadastro de produtos passando token de autenticação
- Validação de status code, contratos de resposta e identificação de recursos
- Uso de DataTable e Models para construção de requisições
- Geração de dados dinâmicos (email e nome do produto) para evitar conflitos de execução


## Estrutura e conceitos aplicados
- Gherkin com Cucumber (cenários independentes)
- Separação de pré-condições e comportamento testado
- Uso de estado compartilhado entre steps
- Services responsáveis apenas por comunicação com a API

## Escopo dos testes

Os cenários implementados neste projeto têm foco principal em fluxos positivos, com o objetivo de exercitar o uso do **RestAssured**, a estruturação
de testes **BDD**, o reaproveitamento de estado entre steps e a organização de uma
automação de API.

Cenários alternativos e negativos (como validações de erro, dados duplicados ou regras
de negócio específicas) são reconhecidos como importantes, porém não fazem parte do
escopo atual do projeto, que possui caráter técnico e educacional.

## Próximos passos
- Implementação de novos cenários de Produtos
- Evoluções e ajustes arquiteturais conforme crescimento do projeto


## 🛠️ Tecnologias utilizadas

- **Java** – linguagem base do projeto
- **RestAssured** – automação e validação de APIs
- **Cucumber** – escrita de cenários em Gherkin
- **JUnit** – execução dos testes
- **Maven** – gerenciamento de dependências e build

## ▶️ Como executar o projeto

### 🔧 Pré‑requisitos
- Java JDK 11 ou superior
- Maven
- Acesso à internet (API externa)

### ▶️ Executando via Maven
Na raiz do projeto, execute:

```bash
mvn test

