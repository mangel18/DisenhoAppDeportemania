package edu.iest.registrodeusuario;

import static edu.iest.registrodeusuario.TextoGradiente.GradienteMorado;
import static edu.iest.registrodeusuario.TextoGradiente.GradienteRosa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import edu.iest.registrodeusuario.models.User;
import edu.iest.registrodeusuario.network.APIInterface;
import edu.iest.registrodeusuario.network.Api;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Perfil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        //SE LLAMA A LA FUNCIÓN PARA DARLE EL COLOR DE GRADIENTE AL TEXTO Y SE LE ESTABLECE EL TEXTO DESEADO
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);
        boolean isLogged = sharedPreferences.getBoolean("isLogged", false);
        String id = sharedPreferences.getString("id", "");
        String token = sharedPreferences.getString("token", "");
        Log.e("checker", id);
        Log.e("checker", token);
        if (!isLogged) {
            Intent intent = new Intent(Perfil.this, LogIn.class);
            startActivity(intent);
        }

        TextView tvInfoAdicional = findViewById(R.id.tvInfoAdicional);
        GradienteMorado(tvInfoAdicional, "INFORMACIÓN ADICIONAL");

        TextView tvUsuario = findViewById(R.id.tvUsuario);
        TextView tvFecha =  findViewById(R.id.tvFechaNacimiento);
        TextView tvCorreo = findViewById(R.id.tvCorreo);
        TextView tvCiudad = findViewById(R.id.tvCuidadResidencia);
        TextView tvTelefono = findViewById(R.id.tvTelefono);


        TextView tvCarrerasPasadas = findViewById(R.id.tvCarrerasPasadas);
        GradienteRosa(tvCarrerasPasadas, "CARRERAS PASADAS");

        APIInterface api = Api.getClient();

        Call<User> call = api.getUser(id, token);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user = response.body();
                if (user != null) {
                    Log.e("checker", user.getEmail());

                    String name = "" + tvUsuario.getText() + "\n" + user.getName();
                    tvUsuario.setText(name);
                    tvFecha.setText(tvFecha.getText() + "\n" + user.getBirthdate());
                    tvCorreo.setText(tvCorreo.getText() + "\n" + user.getEmail());
                    tvCiudad.setText(tvCiudad.getText() + "\n" + user.getCity_of_residence());
                    tvTelefono.setText(tvTelefono.getText() + "\n" + user.getPhonenumber());
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    // Manejar las selecciones del menú
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_eventos:
                startActivity(new Intent(this, MainActivity.class));
                return true;
            case R.id.menu_perfil:
                startActivity(new Intent(this, Perfil.class));
                return true;
            case R.id.menu_contacto:
                startActivity(new Intent(this, ContactoActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}