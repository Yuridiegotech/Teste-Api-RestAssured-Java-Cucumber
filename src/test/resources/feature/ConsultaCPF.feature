#language:pt
Funcionalidade: Consultar CPF
  Cenário: Consulta CPF Restrito
    Dado que o endpoint para Cpf Restrito Esteja Disponivel
    Quando for enviado um GET para o endpoint de CPF com restrição
    Então Deve ser retornado que o CPF tem Restrição juntamente com status 200


    Cenário: Consulta CPF Sem Restrição
      Dado que o endpoint para Cpf Sem restricao Esteja Disponivel
      Quando for enviado um GET para o endpoint de CPF Sem restrição
      Então Deve ser retornado que o CPF  não tem Restrição juntamente com status 204




