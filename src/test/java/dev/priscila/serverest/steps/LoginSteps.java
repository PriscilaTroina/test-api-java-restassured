package dev.priscila.serverest.steps;

import dev.priscila.serverest.service.login.LoginService;
import dev.priscila.serverest.model.ModelLogin;

import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Entao;
import io.restassured.response.Response;
import org.hamcrest.*;
import org.junit.jupiter.api.Assertions;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.emptyString;


public class LoginSteps {
    private final LoginService loginService = new LoginService();
    private Response response;
    private ModelLogin loginRequest;
    protected static String token;



    // =========================
    // LOGIN COMO AÇÃO (cenário de login)
    // ========================

    @Quando("eu fizer uma requisicao POST com dados validos")
    public void requestLogin() {
        authenticateUser();
    }


    // =========================
    // VALIDAÇÕES LOGIN
    // =========================
    @Entao("o status code retornado deve ser {int}")
    public void validateStatusCode(int statusCodeEsperado) {
        Assertions.assertEquals(statusCodeEsperado, response.getStatusCode());
    }

    @E("deve ser retornado um token valido")
    public void validateToken() {
        response.then().body("authorization", notNullValue());
        response.then().body("authorization", not(emptyString()));
    }


    // =========================
    // LOGIN COMO PRÉ-CONDIÇÃO (outros cenários)
    // =========================

    @E("que eu esteja autenticado")
    public void userIsAuthenticated() {
        authenticateUser();
    }

    private void authenticateUser() {
        loginRequest = new ModelLogin();

    // Reutiliza os dados do usuário criado no cenário de cadastro
        loginRequest.setEmail(UsuariosSteps.userRequest.getEmail());
        loginRequest.setPassword(UsuariosSteps.userRequest.getPassword());

        response = loginService.login(loginRequest);

        token = response.then().extract().path("authorization");
    }

}
