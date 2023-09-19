package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import pojo.BodyBaseTests;
import util.TestConfig;

import static io.restassured.RestAssured.given;

public class  StepsConsultaCPF {



    // Teste Cenário Consulta CPF Restrito

    //CPF Cenário 1
    private Response response;

    @Dado("que o endpoint para Cpf Restrito Esteja Disponivel")
    public void queOEndpointParaCpfRestritoEstejaDisponivel() {
        RestAssured.baseURI = TestConfig.BASE_URL;
        RestAssured.port = TestConfig.APP_PORT;
        RestAssured.basePath = TestConfig.basePath;
    }


    @Quando("for enviado um GET para o endpoint de CPF com restrição")
    public void forEnviadoUmGETParaApiVRestricoesCpfComCPFComRestricao() {
        String cpfComRestricao = BodyBaseTests.CpfComRestrição().getCpf();

        response = given()
                .contentType(TestConfig.APP_CONTENT_TYPE)
                .when()
                .get("/restricoes/" + cpfComRestricao);
    }

    // Então validando
    @Então("Deve ser retornado que o CPF tem Restrição juntamente com status 200")
    public void eve_ser_retornado_que_o_cpf_tem_restrição_juntamente_com_status_200() {
        response.then()
                .statusCode(200)
                .log().all();

    }


    @Dado("que o endpoint para Cpf Sem restricao Esteja Disponivel")
    public void ueOEndpointParaCpfSemRestricaoEstejaDisponivel() {
        RestAssured.baseURI = TestConfig.BASE_URL;
        RestAssured.port = TestConfig.APP_PORT;
        RestAssured.basePath = TestConfig.basePath;

    }

    @Quando("for enviado um GET para o endpoint de CPF Sem restrição")
    public void forEnviadoUmGETParaOEndpointDeCPFSemRestricao() {
        String cpfSemRestricao = BodyBaseTests.CpfSemRestrição().getCpf();

        response = given()
                .contentType(TestConfig.APP_CONTENT_TYPE)
                .when()
                .get("/restricoes/" + cpfSemRestricao);

    }

    @Então("Deve ser retornado que o CPF  não tem Restrição juntamente com status 204")
    public void deveSerRetornadoQueOCPFNaoTemRestricaoJuntamenteComStatus() {
        response.then()
                .statusCode(204)
                .log().all();

    }


}
