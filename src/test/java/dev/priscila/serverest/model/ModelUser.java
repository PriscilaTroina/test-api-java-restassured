package dev.priscila.serverest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ModelUser {
    private String nome;
    private String email;
    private String password;
    private String administrador;
    @JsonIgnore
    private String id;


    public ModelUser() {

    }

    public ModelUser(String nome, String email, String password, String administrador, String id) {
        this.nome = nome;
        this.email = email;
        this.password = password;
        this.administrador = administrador;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAdministrador() {
        return administrador;
    }

    public void setAdministrador(String administrador) {
        this.administrador = administrador;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
