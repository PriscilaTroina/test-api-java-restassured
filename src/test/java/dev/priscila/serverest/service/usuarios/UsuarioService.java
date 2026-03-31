package dev.priscila.serverest.service.usuarios;

import dev.priscila.serverest.config.BaseTest;
import dev.priscila.serverest.model.ModelUser;
import io.restassured.response.Response;

public class UsuarioService extends BaseTest {

    public Response getAllUsers() {

        return io.restassured.RestAssured
                .given()
                .relaxedHTTPSValidation()
                .spec(requestSpec)
                .when()
                .get("/usuarios");
    }

    public Response createUser(ModelUser dadosUsuario) {
        return io.restassured.RestAssured
                .given()
                .relaxedHTTPSValidation()
                .spec(requestSpec)
                .body(dadosUsuario)
                .when()
                .post("/usuarios")
                .then()
                .log().all()
                .extract().response();

    }

    public Response getUserByID(String userID) {
        return io.restassured.RestAssured
                .given()
                .relaxedHTTPSValidation()
                .spec(requestSpec)
                .when()
                .get("/usuarios/" + userID)
                .then()
                .log().all()
                .extract().response();
    }
}