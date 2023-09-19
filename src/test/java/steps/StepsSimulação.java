package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import pojo.BodyBaseTests;
import pojo.Usuario;
import util.TestConfig;

import static io.restassured.RestAssured.given;

public class StepsSimulação {


    private Response response;

    @Dado("Envie um GET o endpoint de simulações")
    public void envie_um_get_o_endpoint_de_simulações() {
        response = given()
                .baseUri(TestConfig.BASE_URL)
                .port(TestConfig.APP_PORT)
                .basePath(TestConfig.basePath)
                .contentType(TestConfig.APP_CONTENT_TYPE)
                .when()
                .get("/simulacoes");
    }

    @Então("Retorna a lista de simulações cadastradas e status 200")
    public void retornaAListaDeSimulacoesCadastradasEStatus() {
        response.then()
                .statusCode(200)
                .log().all();
    }

    @Dado("\\(POS)Envie um GET o endpoint de simulações vinculando um CPF")
    public void envieUmGETOEndpointDeSimulacoesVinculandoUmCPF() {
        String cpf = "17822386034";
        response = given()
                .baseUri(TestConfig.BASE_URL)
                .port(TestConfig.APP_PORT)
                .basePath(TestConfig.basePath)
                .contentType(TestConfig.APP_CONTENT_TYPE)
                .when()
                .get("/simulacoes/" + cpf);
    }

    @Entao("Retorna a simulação cadastrada e status 200")
    public void retornaASimulacaoCadastrada() {
        response.then()
                .statusCode(200)
                .log().all();

    }
    @Dado("\\(NEG)Envie um GET o endpoint de simulações vinculando um CPF")
    public void negEnvieUmGETOEndpointDeSimulacoesVinculandoUmCPF() {
        String cpf = "16400823799";
        response = given()
                .baseUri(TestConfig.BASE_URL)
                .port(TestConfig.APP_PORT)
                .basePath(TestConfig.basePath)
                .contentType(TestConfig.APP_CONTENT_TYPE)
                .when()
                .get("/simulacoes/" + cpf);
    }

    @Entao("Retornar o status 404")
    public void retornarOStatus() {
        response.then()
                .statusCode(404)
                .log().all();
    }

    //chama atualiza usuario
    String cpfsimulacaovalido = "66414919004";
    String urialterasimulacao = "/simulacoes/" + cpfsimulacaovalido;
    Usuario atualizaUsuario = BodyBaseTests.AtualizaUsuario();
    //Define URI



    @Dado("Que eu tenha um CPF a ser alterado")
    public void queEuTenhaUmCPFASerAlterado() {
        RestAssured.baseURI = TestConfig.BASE_URL;
        RestAssured.port = TestConfig.APP_PORT;
        RestAssured.basePath = TestConfig.basePath;


    }

    @Quando("Envie um PUT o endpoint de simulações vinculando um CPF existente")
    public void envieUmPUTOEndpointDeSimulacoesVinculandoUmCPFExistente() {
        response = given()
                .contentType(TestConfig.APP_CONTENT_TYPE)
                .body(atualizaUsuario)
                .when()
                .put(urialterasimulacao);
    }

    @Entao("valida alteração e retorna status 200")
    public void validaAlteraçãoRetornaStatus200(){
        response.then()
                .statusCode(200)
                .log().all();
    }


    //chama atualiza usuario
    String cpfsimulacaoinvalido = "16400822294";
    String urialterasimulacaoinvalida = "/simulacoes/" + cpfsimulacaoinvalido;

    //Define URI



    @Dado("Que eu tenha um CPF invalido a ser alterado")
    public void queEuTenhaUmCPFInvalidoASerAlterado() {
        RestAssured.baseURI = TestConfig.BASE_URL;
        RestAssured.port = TestConfig.APP_PORT;
        RestAssured.basePath = TestConfig.basePath;


    }

    @Quando("Envie um PUT o endpoint de simulações vinculando um CPF invalido")
    public void envieUmPUTOEndpointDeSimulacoesVinculandoUmCPFInvalido() {
        response = given()
                .contentType(TestConfig.APP_CONTENT_TYPE)
                .body(atualizaUsuario)
                .when()
                .put(urialterasimulacaoinvalida);
    }

    @Entao("valida alteração e retorna status 404")
    public void validaAlteraçãoRetornaStatus404(){
        response.then()
                .statusCode(404)
                .log().all();
    }


    //Dados para delete

    String idExistente = "11";
    String urideleçaoValido = "/simulacoes/" + idExistente;


    @Dado("Que eu tenha uma simulação a ser excluida")
    public void queEuTenhaUmaSimulacaoASerExcluida() {
        RestAssured.baseURI = TestConfig.BASE_URL;
        RestAssured.port = TestConfig.APP_PORT;
        RestAssured.basePath = TestConfig.basePath;

    }

    @Quando("Enviar um DELETE ao endpoint de remover simulação com ID Valida")
    public void enviarUmDELETEAoEndpointDeRemoverSimulacao() {
        response = given()
                .contentType(TestConfig.APP_CONTENT_TYPE)
                .when()
                .delete(urideleçaoValido);
    }


    @Então("Exclui simulação e retornar status 204")
    public void excluiSimulacaoERetornarStatus() {
        response.then()
                .statusCode(204)
                .log().all();
    }



    String idInexistente = "88";
    String urideleçaoInvalido = "/simulacoes/" + idInexistente;
    @Dado("Que eu tente excluir uma simulação por uma ID inexistente")
    public void queEuTenteExcluirUmaSimulacaoPorUmaIDInexistente() {
        RestAssured.baseURI = TestConfig.BASE_URL;
        RestAssured.port = TestConfig.APP_PORT;
        RestAssured.basePath = TestConfig.basePath;

    }


    @Quando("Enviar um DELETE ao endpoint de remover simulação com ID Invalida")
    public void enviarUmDELETEAoEndpointDeRemoverSimulacaoComIDInvalida() {
        response = given()
                .contentType(TestConfig.APP_CONTENT_TYPE)
                .when()
                .delete(urideleçaoInvalido);
    }


    @Então("Deve indicar não existir simulação e retornar status 404")
    public void deveIndicarNaoExistirSimulacaoERetornarStatus() {
        response.then()
                .statusCode(404)
                .log().all();
    }

    //Cria usuario valido

    Usuario CriaUsuarioValido = BodyBaseTests.CriaUsuarioValido();

    String uriCriação = "/simulacoes";



    @Dado("Que tente criar uma simulação com dado válido")
    public void queTenteCriarUmaSimulacaoComDadoValido() {
        RestAssured.baseURI = TestConfig.BASE_URL;
        RestAssured.port = TestConfig.APP_PORT;
        RestAssured.basePath = TestConfig.basePath;
    }

    @Quando("Enviar um POST ao endpoint de criar simulação com dados validos")
    public void enviarUmPOSTAoEndpointDeCriarSimulacaoComDadosValidos() {
        response = given()
                .contentType(TestConfig.APP_CONTENT_TYPE)
                .body(CriaUsuarioValido)
                .when()
                .post(uriCriação);
    }

    @Então("Deve retorar os dados de cadastro, indicar que foi um sucesso e retornar status 201")
    public void deveRetorarOsDadosDeCadastroIndicarQueFoiUmSucessoERetornarStatus() {
        response.then()
                .statusCode(201)
                .log().all();
    }



    //cria usuario duplicado
    Usuario CriaUsuarioCPFRepetido = BodyBaseTests.CriaUsuarioCpfRepetido();


    @Dado("Que tente criar uma simulação com cpf já existente")
    public void queTenteCriarUmaSimulacaoComCpfJaExistente() {
        RestAssured.baseURI = TestConfig.BASE_URL;
        RestAssured.port = TestConfig.APP_PORT;
        RestAssured.basePath = TestConfig.basePath;
    }

    @Quando("Enviar um POST ao endpoint de criar simulação com cpf existente")
    public void enviarUmPOSTAoEndpointDeCriarSimulacaoComCpfExistente() {
        response = given()
                .contentType(TestConfig.APP_CONTENT_TYPE)
                .body(CriaUsuarioCPFRepetido)
                .when()
                .post(uriCriação);
    }

    @Então("Deve retorar que já existe CPF e retornar status 409")
    public void deveRetorarQueJaExisteCPFERetornarStatus() {
        response.then()
                .statusCode(409)
                .log().all();
    }
    //cria usuario valor menor
    Usuario CriaUsuarioValormenor = BodyBaseTests.CriaUsuarioValorMenor();


    @Dado("Que tente criar uma simulação Valor menor que condição")
    public void queTenteCriarUmaSimulacaoComValorMenor() {
        RestAssured.baseURI = TestConfig.BASE_URL;
        RestAssured.port = TestConfig.APP_PORT;
        RestAssured.basePath = TestConfig.basePath;
    }

    @Quando("Enviar um POST ao endpoint de criar simulação com o valor menor")
    public void enviarUmPOSTAoEndpointDeCriarSimulacaoComValorMenor() {
        response = given()
                .contentType(TestConfig.APP_CONTENT_TYPE)
                .body(CriaUsuarioValormenor)
                .when()
                .post(uriCriação);
    }

    @Então("Deve retorar que está fora da condição, e retornar status 400")
    public void deveRetorarQueEstaForaCondicaoRetornarStatus400() {
        response.then()
                .statusCode(400)
                .log().all();


    }
    //cria usuario valor Maior
    Usuario CriaUsuarioValorMaior = BodyBaseTests.CriaUsuarioValorMaior();


    @Dado("Que tente criar uma simulação Valor Maior que condição")
    public void queTenteCriarUmaSimulacaoComValorMaior() {
        RestAssured.baseURI = TestConfig.BASE_URL;
        RestAssured.port = TestConfig.APP_PORT;
        RestAssured.basePath = TestConfig.basePath;
    }

    @Quando("Enviar um POST ao endpoint de criar simulação com o valor Maior")
    public void enviarUmPOSTAoEndpointDeCriarSimulacaoComValorMaior() {
        response = given()
                .contentType(TestConfig.APP_CONTENT_TYPE)
                .body(CriaUsuarioValorMaior)
                .when()
                .post(uriCriação);
    }

    @Então("Deve retorar que está fora da condição pelo valor maior, e retornar status 400")
    public void deveRetorarQueEstaForaCondicaoValorMaiorRetornarStatus400() {
        response.then()
                .statusCode(400)
                .log().all();


    }

    //cria usuario Parcela menor
    Usuario CriaUsuarioParcelamenor = BodyBaseTests.CriaUsuarioParcelaMenor();


    @Dado("Que tente criar uma simulação Parcela menor que condição")
    public void queTenteCriarUmaSimulacaoComParcelaMenor() {
        RestAssured.baseURI = TestConfig.BASE_URL;
        RestAssured.port = TestConfig.APP_PORT;
        RestAssured.basePath = TestConfig.basePath;
    }

    @Quando("Enviar um POST ao endpoint de criar simulação com o Parcela menor")
    public void enviarUmPOSTAoEndpointDeCriarSimulacaoComParcelaMenor() {
        response = given()
                .contentType(TestConfig.APP_CONTENT_TYPE)
                .body(CriaUsuarioParcelamenor)
                .when()
                .post(uriCriação);
    }

    @Então("Deve retorar que está fora da condição, Parcela Menor e retornar status 400")
    public void deveRetorarQueEstaForaCondicaoParcelaMenorRetornarStatus400() {
        response.then()
                .statusCode(400)
                .log().all();


    }
    //cria usuario Parcela Maior
    Usuario CriaUsuarioParcelaMaior = BodyBaseTests.CriaUsuarioParcelaMaior();


    @Dado("Que tente criar uma simulação Parcela Maior que condição")
    public void queTenteCriarUmaSimulacaoComParcelaMaior() {
        RestAssured.baseURI = TestConfig.BASE_URL;
        RestAssured.port = TestConfig.APP_PORT;
        RestAssured.basePath = TestConfig.basePath;
    }

    @Quando("Enviar um POST ao endpoint de criar simulação com o Parcela Maior")
    public void enviarUmPOSTAoEndpointDeCriarSimulacaoComParcelaMaior() {
        response = given()
                .contentType(TestConfig.APP_CONTENT_TYPE)
                .body(CriaUsuarioParcelaMaior)
                .when()
                .post(uriCriação);
    }

    @Então("Deve retorar que está fora da condição pelo Parcela maior, e retornar status 400")
    public void deveRetorarQueEstaForaCondicaoParcelaMaiorRetornarStatus400() {
        response.then()
                .statusCode(400)
                .log().all();


    }






}
