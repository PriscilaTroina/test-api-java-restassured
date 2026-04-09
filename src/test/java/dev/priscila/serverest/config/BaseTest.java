package dev.priscila.serverest.config;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public abstract class BaseTest {

    protected RequestSpecification requestSpec = new RequestSpecBuilder()
            .setBaseUri("https://serverest.dev")   // <-- CORRETO
            .setRelaxedHTTPSValidation()
            .setContentType(ContentType.JSON)
            .build();
}