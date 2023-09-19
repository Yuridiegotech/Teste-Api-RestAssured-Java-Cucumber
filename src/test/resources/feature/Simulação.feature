#language:pt
Funcionalidade: Simulações de crédito
  Cenário:(POS)Consulta Simulacoes Existentes
    Dado Envie um GET o endpoint de simulações
    Então Retorna a lista de simulações cadastradas e status 200


  Cenário:(POS)Consulta Simulacao por CPF
    Dado (POS)Envie um GET o endpoint de simulações vinculando um CPF
    Entao Retorna a simulação cadastrada e status 200

  Cenário:(NEG)Consulta Simulacao por CPF
    Dado (NEG)Envie um GET o endpoint de simulações vinculando um CPF
    Entao Retornar o status 404


  Cenário: (POS)Altera uma Simulação de Crédito
    Dado Que eu tenha um CPF a ser alterado
    Quando Envie um PUT o endpoint de simulações vinculando um CPF existente
    Entao valida alteração e retorna status 200


  Cenário: (NEG)Altera uma Simulação de Crédito
    Dado Que eu tenha um CPF invalido a ser alterado
    Quando Envie um PUT o endpoint de simulações vinculando um CPF invalido
    Entao valida alteração e retorna status 404

  Cenário: (POS) Validar deleção de uma simulação
    Dado Que eu tenha uma simulação a ser excluida
    Quando Enviar um DELETE ao endpoint de remover simulação com ID Valida
    Então Exclui simulação e retornar status 204

  Cenário: (NEG) Validar deleção de uma simulação
    Dado Que eu tente excluir uma simulação por uma ID inexistente
    Quando Enviar um DELETE ao endpoint de remover simulação com ID Invalida
    Então Deve indicar não existir simulação e retornar status 404

  Cenário: Criar uma simulação com dados Válidos
    Dado Que tente criar uma simulação com dado válido
    Quando Enviar um POST ao endpoint de criar simulação com dados validos
    Então Deve retorar os dados de cadastro, indicar que foi um sucesso e retornar status 201


  Cenário: Criar uma simulação com cpf ja existente
    Dado Que tente criar uma simulação com cpf já existente
    Quando Enviar um POST ao endpoint de criar simulação com cpf existente
    Então Deve retorar que já existe CPF e retornar status 409

  Cenário: Criar uma simulação com Valor menor condição
    Dado Que tente criar uma simulação Valor menor que condição
    Quando Enviar um POST ao endpoint de criar simulação com o valor menor
    Então Deve retorar que está fora da condição, e retornar status 400

  Cenário: Criar uma simulação com Valor maior condição
    Dado Que tente criar uma simulação Valor Maior que condição
    Quando Enviar um POST ao endpoint de criar simulação com o valor Maior
    Então Deve retorar que está fora da condição pelo valor maior, e retornar status 400



  Cenário: Criar uma simulação com Parcela menor condição
    Dado Que tente criar uma simulação Parcela menor que condição
    Quando Enviar um POST ao endpoint de criar simulação com o Parcela menor
    Então Deve retorar que está fora da condição, Parcela Menor e retornar status 400

  Cenário: Criar uma simulação com Parcela maior condição
    Dado Que tente criar uma simulação Parcela Maior que condição
    Quando Enviar um POST ao endpoint de criar simulação com o Parcela Maior
    Então Deve retorar que está fora da condição pelo Parcela maior, e retornar status 400






