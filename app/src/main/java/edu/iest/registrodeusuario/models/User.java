package edu.iest.registrodeusuario.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class User {
    // Datos a recivir
    @SerializedName("id")
    private String id;
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

    @SerializedName("carreras")
    private List<CarreraUserInfo> carreras;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public List<CarreraUserInfo> getCarreras() {
        return carreras;
    }

    public void setCarreras(List<CarreraUserInfo> carreras) {
        this.carreras = carreras;
    }
}
