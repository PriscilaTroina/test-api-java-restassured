🚧 Projeto em evolução – Automação de API com RestAssured e Cucumber

## Objetivo
Projeto criado para estudo e consolidação de automação de APIs REST,
simulando um cenário real de projeto em evolução e boas práticas de automação backend.

## Funcionalidades implementadas
- Estrutura com Service Layer
- Steps organizados por responsabilidade
- GET e POST de usuários
- Validação de status code, contratos e IDs
- Uso de DataTable e Models para construção de body
- Geração de dados dinâmicos (email)
- Login com validação e extração de token

## Estrutura e conceitos aplicados
- BDD com Cucumber (cenários independentes)
- Separação de pré-condições e comportamento testado
- Uso de estado compartilhado entre steps
- Services responsáveis apenas por comunicação com a API

## Próximos passos
- Organização do domínio de autenticação (login em feature e steps próprios)
- Endpoints com autorização (uso de token)
- Cadastro de produtos
- Evoluções e ajustes arquiteturais conforme crescimento do projeto