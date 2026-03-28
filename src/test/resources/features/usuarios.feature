# language: pt

Funcionalidade: Gerenciar endpoints de usuarios

 Contexto: que a API esteja disponivel

  Cenario: Listar usuarios
    Quando eu fizer uma requisicao GET no endpoint de usuarios
    Então o status code deve ser 200
    E a quantidade de usuarios deve ser maior que zero
    E cada usuario deve conter os campos obrigatorios


  Cenario: Cadastrar novo usuario
    Quando eu preencher as informacoes de cadastro com os dados:
      | nome     | email              | password | administrador |
      | Priscila | priscilla@gmail.com | teste123 | true          |
    E enviar a requisicao POST
    Entao o status code deve ser 201
    E a resposta deve conter a mensagem "Cadastro realizado com sucesso"
    E a resposta deve conter um id de usuario valido


  Cenario: Login com sucesso

    Dado que exista um usuario cadastrado
    Quando eu fizer uma requisicao POST com dados validos
    Entao o status code deve ser 200
    E deve ser retornado um token valido




