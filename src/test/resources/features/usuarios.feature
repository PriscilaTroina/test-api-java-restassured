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

  Cenario: Buscar usuario por ID
    Dado que exista um usuario cadastrado
    Quando eu buscar o usuario pelo ID
    Entao o status code deve ser 200
    E os dados do usuario devem ser retornados corretamente


  Cenario: Deletar usuario
    Dado que exista um usuario cadastrado
    Quando eu remover o usuario pelo ID
    Entao o status code deve ser 200
    E a resposta deve conter a mensagem "Registro excluído com sucesso"





