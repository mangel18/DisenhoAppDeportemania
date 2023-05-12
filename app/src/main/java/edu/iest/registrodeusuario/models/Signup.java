package edu.iest.registrodeusuario.models;

import com.google.gson.annotations.SerializedName;

public class Signup {
    //Datos de envio
    @SerializedName("name")
    private String name;
    @SerializedName("email")
    private String email;
    @SerializedName("birthdate")
    private String birthdate;
    @SerializedName("sex")
    private String sex;
    @SerializedName("city_of_residence")
    private String city_of_residence;
    @SerializedName("password")
    private String password;
    @SerializedName("phonenumber")
    private String phonenumber;

    // Datos recibidos
    private int status;
    private String id;
    private String token;


    // Constructor
    public Signup(String name, String email, String birthdate, String sex, String city, String password, String phone){
        this.name = name;
        this.email = email;
        this.birthdate = birthdate;
        this.sex = sex;
        this.city_of_residence = city;
        this.password = password;
        this.phonenumber = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCity_of_residence() {
        return city_of_residence;
    }

    public void setCity_of_residence(String city_of_residence) {
        this.city_of_residence = city_of_residence;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getId() {
        return id;
    }

    public int getStatus() {
        return status;
    }

    public String getToken() {
        return token;
    }
}
