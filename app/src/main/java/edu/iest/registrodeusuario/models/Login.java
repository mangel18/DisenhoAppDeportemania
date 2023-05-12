package edu.iest.registrodeusuario.models;

import com.google.gson.annotations.SerializedName;

public class Login {
    // Dtaos de envio
    @SerializedName("email")
    private String email;
    @SerializedName("password")
    private String password;

    // Datos recibidos
    @SerializedName("status")
    private int status;

    @SerializedName("id")
    private String id;
    @SerializedName("token")
    private String token;

    public Login(String email, String password) {
        this.email = email;
        this.password = password;
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

    public int getStatus() {
        return status;
    }

    public String getId() {
        return id;
    }

    public String getToken() {
        return token;

    }
}