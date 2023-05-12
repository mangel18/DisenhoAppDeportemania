package edu.iest.registrodeusuario.network;

import android.util.Log;

import java.util.List;

import edu.iest.registrodeusuario.models.Carrera;
import edu.iest.registrodeusuario.models.CarreraBrief;
import edu.iest.registrodeusuario.models.Login;
import edu.iest.registrodeusuario.models.Signup;
import edu.iest.registrodeusuario.models.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface APIInterface {
    @GET("/")
    Call<List<CarreraBrief>> getIndex();

    @GET("/user/{id}")
    Call<User> getUser(@Path("id") String id, @Header("Token") String token);

    @GET("/event/{id}")
    Call<Carrera> getCaerrera(@Path("id") String id);

    @POST("/signup")
    Call<Signup> createUser(@Body Signup signupInfo);

    @POST("/login")
    Call<Login> logUser(@Body Login loginInfo);
    /*
    @POST("/event/{id}/register")
    Call<> registerUserInRace(@Body registerInRaceInfo)
    */

}