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

Consultar CPF <br/>
passedConsultar CPF.Consulta CPF Restrito<br/>
passedConsultar CPF.Consulta CPF Sem Restrição<br/>
Simulações de crédito<br/>
passedSimulações de crédito.(POS)Consulta Simulacoes Existentes<br/>
passedSimulações de crédito.(POS)Consulta Simulacao por CPF<br/>
passedSimulações de crédito.(NEG)Consulta Simulacao por CPF<br/>
passedSimulações de crédito.(POS)Altera uma Simulação de Crédito<br/>
passedSimulações de crédito.(NEG)Altera uma Simulação de Crédito<br/>
failedSimulações de crédito.(POS) Validar deleção de uma simulação<br/>
failedSimulações de crédito.(NEG) Validar deleção de uma simulação<br/>
passedSimulações de crédito.Criar uma simulação com dados Válidos<br/>
failedSimulações de crédito.Criar uma simulação com cpf ja existente<br/>
failedSimulações de crédito.Criar uma simulação com Valor menor condição<br/>
passedSimulações de crédito.Criar uma simulação com Valor maior condição<br/>
passedSimulações de crédito.Criar uma simulação com Parcela menor condição<br/>
failedSimulações de crédito.Criar uma simulação com Parcela maior condição<br/>

De acordo com o plano de teste Disponivel no link:
https://docs.google.com/document/d/1tDQck9WezxBEOp7BnyuiRV6xHTuZeJb7daGWl0cw6KI/edit?usp=sharing

Além disso, na pasta raiz do projeto, será criado um arquivo HTML Chamado cucumber-html-report.html
Nele é disposto um relatório, mais  detalhado sobre cada teste 

