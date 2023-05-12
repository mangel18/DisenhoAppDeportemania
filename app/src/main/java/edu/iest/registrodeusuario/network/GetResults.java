package edu.iest.registrodeusuario.network;

import android.util.Log;

import java.util.List;

import edu.iest.registrodeusuario.models.Carrera;
import edu.iest.registrodeusuario.models.CarreraBrief;
import edu.iest.registrodeusuario.models.Login;
import edu.iest.registrodeusuario.models.Signup;
import edu.iest.registrodeusuario.models.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class GetResults {
    public static void index(){
        APIInterface api = Api.getClient();

        Call<List<CarreraBrief>> call = api.getIndex();

        call.enqueue(new Callback<List<CarreraBrief>>() {
            @Override
            public void onResponse(Call<List<CarreraBrief>> call, Response<List<CarreraBrief>> response) {
                List<CarreraBrief> carreras = response.body();
                CarreraBrief el = carreras.get(4);
                Log.e("checker", "Carrera 1: " + el.getName());
            }

            @Override
            public void onFailure(Call<List<CarreraBrief>> call, Throwable t) {
                if (t != null && t.getMessage() != null) {
                    Log.e("checker", t.getMessage().toString());
                } else {
                    Log.e("checker", "Error desconocido");
                }
            }
        });
    }

    public static void signin(){
        APIInterface api = Api.getClient();


        Signup user = new Signup("Michiel Horstman", "m.horstman@gmail.com", "14/08/1999", "Male", "Tampico", "12345", "8333121802");
        Call<Signup> call = api.createUser(user);

        call.enqueue(new Callback<Signup>() {
            @Override
            public void onResponse(Call<Signup> call, Response<Signup> response) {
                Signup info= response.body();
                if (info != null) {
                    Log.e("checker", info.getToken());
                }
            }

            @Override
            public void onFailure(Call<Signup> call, Throwable t) {
                if (t != null && t.getMessage() != null) {
                    Log.e("checker", t.getMessage().toString());
                } else {
                    Log.e("checker", "Error desconocido");
                }

            }
        });
    }

    public static void getUser() {

        APIInterface api = Api.getClient();

        Call <User> call = api.getUser("645e73f6a66804e03c553a0b", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjY0NWU3M2Y2YTY2ODA0ZTAzYzU1M2EwYiIsInR5cGUiOiJ1c2VyIn0.ozQINjGtLYCJClEnmRXkhquSMV4Faq91b64jl9jNkPY");

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user = response.body();
                if (user != null) {
                    Log.e("checker", user.getEmail());
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                if (t != null && t.getMessage() != null) {
                    Log.e("checker", t.getMessage().toString());
                } else {
                    Log.e("checker", "Error desconocido");
                }
            }
        });
    }
    
    public static void getEvent(){
        APIInterface api = Api.getClient();
        
        Call<Carrera> call= api.getCaerrera("645d2ae954bb000f20476aa6");
        
        call.enqueue(new Callback<Carrera>() {
            @Override
            public void onResponse(Call<Carrera> call, Response<Carrera> response) {
                Carrera carerera = response.body();
                if (carerera != null ) {
                    Log.e("checker", carerera.getName());
                }
            }

            @Override
            public void onFailure(Call<Carrera> call, Throwable t) {
                if (t != null && t.getMessage() != null) {
                    Log.e("checker", t.getMessage().toString());
                } else {
                    Log.e("checker", "Error desconocido");
                }
            }
        });
    }
    public static void login(){
        APIInterface api = Api.getClient();

        Login logininfo = new Login("m.horstman@gmail.com", "12345");
        Call<Login> call = api.logUser(logininfo);

        call.enqueue(new Callback<Login>() {
            @Override
            public void onResponse(Call<Login> call, Response<Login> response) {
                Login loginfo = response.body();
                if (loginfo != null){
                    Log.e("checker", loginfo.getToken());
                }
            }

            @Override
            public void onFailure(Call<Login> call, Throwable t) {
                if (t != null && t.getMessage() != null) {
                    Log.e("checker", t.getMessage().toString());
                } else {
                    Log.e("checker", "Error desconocido");
                }
            }
        });
    }
}



