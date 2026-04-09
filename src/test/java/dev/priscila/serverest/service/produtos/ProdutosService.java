package dev.priscila.serverest.service.produtos;

import dev.priscila.serverest.config.BaseTest;
import dev.priscila.serverest.model.ModelProduct;
import io.restassured.response.Response;

public class ProdutosService extends BaseTest {

    public Response createProduct(ModelProduct dadosProduto, String token) {

        return io.restassured.RestAssured
                .given()
                .relaxedHTTPSValidation()
                .spec(requestSpec)
                .header("Authorization", token)
                .body(dadosProduto)
                .when()
                .post("/produtos")
                .then()
                .log().all()
                .extract().response();
    }


}