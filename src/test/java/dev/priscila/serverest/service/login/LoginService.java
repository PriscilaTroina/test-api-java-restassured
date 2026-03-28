package dev.priscila.serverest.service.login;

import dev.priscila.serverest.config.BaseTest;
import io.restassured.response.Response;
import dev.priscila.serverest.model.ModelLogin;

public class LoginService extends BaseTest {

    public Response login(ModelLogin dadosLogin) {
        return io.restassured.RestAssured
                .given()
                .relaxedHTTPSValidation()
                .spec(requestSpec)
                .body(dadosLogin)
                .when()
                .post("/login")
                .then()
                .log().all()
                .extract().response();
    }
}
