package edu.iest.registrodeusuario.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api {
    public static final String BASE_URL = "http://192.168.100.21:8081";
    private static Retrofit retrofit = null;

    public static APIInterface getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        APIInterface servicio = retrofit.create(APIInterface.class);
        return servicio;
    }
}
