# language: pt

Funcionalidade: Gerenciar endpoint de Login

  Contexto: que a API esteja disponivel

  Cenario: Login com sucesso

    Dado que exista um usuario cadastrado
    Quando eu fizer uma requisicao POST com dados validos
    Entao o status code retornado deve ser 200
