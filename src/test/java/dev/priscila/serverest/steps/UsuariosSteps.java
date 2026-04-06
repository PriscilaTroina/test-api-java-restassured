package dev.priscila.serverest.steps;

import dev.priscila.serverest.service.usuarios.UsuarioService;
import dev.priscila.serverest.model.ModelUser;
import dev.priscila.serverest.model.ModelLogin;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Entao;
import io.restassured.response.Response;
import org.hamcrest.*;
import org.junit.jupiter.api.Assertions;
import java.util.Map;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.emptyString;
import static org.hamcrest.Matchers.greaterThan;


public class UsuariosSteps {
    private final UsuarioService usuarioService = new UsuarioService();
    private Response response;
    protected static ModelUser userRequest;
    private ModelLogin loginRequest;
    private String token;
    private String userID;


    // =========================
    // SETUP / CONTEXTO
    // =========================
    @Dado("que a API esteja disponivel")
    public void apiDisponivel() {
        // healthcheck futuro, se precisar
    }

    @Dado("que exista um usuario cadastrado")
    public void createUserPreCondition() {
        String dynamicEmail = "priscila_" + System.currentTimeMillis() + "@gmail.com";

        userRequest = new ModelUser();
        userRequest.setNome("Priscila");
        userRequest.setEmail(dynamicEmail);
        userRequest.setPassword("teste123");
        userRequest.setAdministrador("true");

        response = usuarioService.createUser(userRequest);

        userID = response.then().extract().path("_id");

    }

    // =========================
    // AÇÕES - GET USUÁRIOS
    // ========================

    @Quando("eu fizer uma requisicao GET no endpoint de usuarios")
    public void getUsers() {
       response = usuarioService.getAllUsers();
    }

    @Quando("eu buscar o usuario pelo ID")
    public void getUserByID() {
        response = usuarioService.getUserByID(userID);
    }

    // =========================
    // AÇÕES - POST USUÁRIO
    // =========================

    @Quando("eu preencher as informacoes de cadastro com os dados:")
    public void preencherDadosDeCadastro(DataTable dataTable) {
        String dynamicEmail = "priscila_" + System.currentTimeMillis() + "@gmail.com";

        Map<String, String> data = dataTable.asMaps().get(0);

        userRequest = new ModelUser();
        userRequest.setNome(data.get("nome"));
        userRequest.setEmail(dynamicEmail);
        userRequest.setPassword(data.get("password"));
        userRequest.setAdministrador(data.get("administrador"));
    }

    @E("enviar a requisicao POST")
    public void requestCreateUser() {
        response = usuarioService.createUser(userRequest);
    }

    // =========================
    // AÇÕES - DELETE USUÁRIO
    // =========================

    @Quando("eu remover o usuario pelo ID")
    public void deleteUserByID() {
        response = usuarioService.deleteUserByID(userID);

    }

    // =========================
    // VALIDAÇÕES GENÉRICAS DE CADASTRO DE USUARIO
    // =========================

    @Entao("o status code deve ser {int}")
    public void validateStatusCode(int statusCodeEsperado) {
        Assertions.assertEquals(statusCodeEsperado, response.getStatusCode());
    }

    // =========================
    // VALIDAÇÕES - LISTAGEM DE USUÁRIOS
    // =========================

    @E("a quantidade de usuarios deve ser maior que zero")
    public void validateUserListHasUsers() {
        response.then()
                .body("quantidade", greaterThan(0));
    }


    @E("cada usuario deve conter os campos obrigatorios")
    public void validateUserFields() {
        response.then()
                .body("usuarios[0].nome", notNullValue())
                .body("usuarios[0].email", notNullValue())
                .body("usuarios[0].password", notNullValue())
                .body("usuarios[0].administrador", notNullValue())
                .body("usuarios[0]._id", notNullValue());
    }


    // =========================
    // VALIDAÇÕES - CADASTRO DE USUÁRIO
    // =========================

    @E("a resposta deve conter a mensagem {string}")
    public void validateSuccessMessage(String mensagemEsperada) {
        response.then().body("message", equalTo(mensagemEsperada));
    }

    @E("a resposta deve conter um id de usuario valido")
    public void validateUserId() {
        response.then().body("_id", notNullValue());
        response.then().body("_id", Matchers.not(emptyString()));
    }

    // =========================
    // VALIDAÇÕES - BUSCA USUARIO POR ID
    // =========================

    @E("os dados do usuario devem ser retornados corretamente")
    public void validateUserDetails() {
        response.then()
                .body("nome", equalTo(userRequest.getNome()))
                .body("email", equalTo(userRequest.getEmail()))
                .body("password", equalTo(userRequest.getPassword()))
                .body("administrador", equalTo(userRequest.getAdministrador()))
                .body("_id", Matchers.equalTo(userID));

    }
}
