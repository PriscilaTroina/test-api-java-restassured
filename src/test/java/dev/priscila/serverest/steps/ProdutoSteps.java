package dev.priscila.serverest.steps;

import dev.priscila.serverest.service.produtos.ProdutosService;
import dev.priscila.serverest.model.ModelProduct;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import java.util.Map;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.emptyString;

public class ProdutoSteps {

    private final ProdutosService produtosService = new ProdutosService();
    private ModelProduct productRequest;
    private String token;
    private Response response;

    // =========================
    // AÇÕES - POST CADASTRO DE PRODUTO
    // =========================

    @Quando("eu cadastrar um novo produto com os dados:")
    public void createNewProduct(DataTable dataTable) {
        Map<String, String> data = dataTable.asMaps().get(0);
        String dynamicName = "Produto_" + System.currentTimeMillis();

        productRequest = new ModelProduct();
        productRequest.setNome(dynamicName);
        productRequest.setDescricao(data.get("descricao"));
        productRequest.setPreco(Integer.parseInt(data.get("preco")));
        productRequest.setQuantidade(Integer.parseInt(data.get("quantidade")));


        response = produtosService.createProduct(productRequest, LoginSteps.token);
    }

    // =========================
    // VALIDAÇÕES CADASTRO DE PRODUTO
    // =========================

    @Entao("o status code sera {int}")
    public void validateStatusCode(int statusCodeEsperado) {
        Assertions.assertEquals(statusCodeEsperado, response.getStatusCode());
    }

    @E("no response deverá conter a mensagem {string}")
    public void validateSuccessMessage(String mensagemEsperada) {
        response.then().body("message", equalTo(mensagemEsperada));
    }

    @E("deverá conter um id de produto valido")
    public void validateIDProduct() {
        response.then().body("_id", notNullValue());
        response.then().body("_id", not(emptyString()));
    }

}
