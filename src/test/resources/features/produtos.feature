# language: pt

Funcionalidade: Gerenciar endpoints de produtos

  Contexto: que a API esteja disponivel

  Cenario: Cadastrar produto
    Dado que exista um usuario cadastrado
    E que eu esteja autenticado
    Quando eu cadastrar um novo produto com os dados:
      | nome       | preco | descricao              | quantidade     |
      | Produto Teclado da Priscila  | 10    | Descrição do produto X | 10             |
    Entao o status code sera 201
    E no response deverá conter a mensagem "Cadastro realizado com sucesso"
    E deverá conter um id de produto valido







