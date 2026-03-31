🚧 Projeto em evolução – Automação de API com RestAssured e Cucumber

## Objetivo
Projeto criado para estudo e consolidação de automação de APIs REST,
simulando um cenário real de projeto em evolução e boas práticas de automação backend.

## Funcionalidades implementadas
- Estrutura de automação baseada em Service Layer
- Organização dos steps por responsabilidade e domínio
- Automação dos endpoints de usuários (GET, POST e busca por ID)
- Validação de status code, contratos de resposta e identificação de recursos
- Uso de DataTable e Models para construção de requisições
- Geração de dados dinâmicos (email) para evitar conflitos de execução
- Automação de login com validação e extração de token, organizada em feature e steps próprios

## Estrutura e conceitos aplicados
- Gherkin com Cucumber (cenários independentes)
- Separação de pré-condições e comportamento testado
- Uso de estado compartilhado entre steps
- Services responsáveis apenas por comunicação com a API

## Próximos passos
- Endpoints com autorização (uso de token)
- Cadastro de produtos
- Evoluções e ajustes arquiteturais conforme crescimento do projeto


## 🛠️ Tecnologias utilizadas

- **Java** – linguagem base do projeto
- **RestAssured** – automação e validação de APIs
- **Cucumber** – escrita de cenários em Gherkin
- **JUnit** – execução dos testes
- **Maven** – gerenciamento de dependências e build

