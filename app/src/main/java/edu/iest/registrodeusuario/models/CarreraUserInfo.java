package edu.iest.registrodeusuario.models;

import com.google.gson.annotations.SerializedName;

public class CarreraUserInfo {
    @SerializedName("carrera_id")
    private String id;
    @SerializedName("carrera_name")
    private String name;
    @SerializedName("date")
    private String date;
    @SerializedName("distance")
    private float distance;
    @SerializedName("team")
    private String team;

    public String getID() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.name = date;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }
}
