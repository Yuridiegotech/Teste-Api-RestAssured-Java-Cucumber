# DesafioAPI-Backend
Desafio de API BACK-END usando rest-Assured

Para que execute os testes, deve estar instalado o JDK 8 , e o maven.

Ao abrir o projeto na IDE, deve estar devidamente vinculado no projeto o JDK e o Maven.

Abra o terminal e vá para Raiz do projeto.

Execute primeiramente o comando : **mvn clean spring-boot:run**

este comando iniciará o servidor da API.

Após isso, execute em um segundo terminal, o comando: **MVN Test.**

Esse comando irá executar os testes.

Via terminal será indicado os resultados

Consultar CPF
passedConsultar CPF.Consulta CPF Restrito
passedConsultar CPF.Consulta CPF Sem Restrição
Simulações de crédito
passedSimulações de crédito.(POS)Consulta Simulacoes Existentes
passedSimulações de crédito.(POS)Consulta Simulacao por CPF
passedSimulações de crédito.(NEG)Consulta Simulacao por CPF
passedSimulações de crédito.(POS)Altera uma Simulação de Crédito
passedSimulações de crédito.(NEG)Altera uma Simulação de Crédito
failedSimulações de crédito.(POS) Validar deleção de uma simulação
failedSimulações de crédito.(NEG) Validar deleção de uma simulação
passedSimulações de crédito.Criar uma simulação com dados Válidos
failedSimulações de crédito.Criar uma simulação com cpf ja existente
failedSimulações de crédito.Criar uma simulação com Valor menor condição
passedSimulações de crédito.Criar uma simulação com Valor maior condição
passedSimulações de crédito.Criar uma simulação com Parcela menor condição
failedSimulações de crédito.Criar uma simulação com Parcela maior condição

De acordo com o plano de teste Disponivel no link:
https://docs.google.com/document/d/1tDQck9WezxBEOp7BnyuiRV6xHTuZeJb7daGWl0cw6KI/edit?usp=sharing

Além disso, na pasta raiz do projeto, será criado um arquivo HTML Chamado cucumber-html-report.html
Nele é disposto um relatório, mais  detalhado sobre cada teste 

