package edu.iest.registrodeusuario;



import androidx.appcompat.app.AppCompatActivity;
import static edu.iest.registrodeusuario.TextoGradiente.GradienteAMR;

import edu.iest.registrodeusuario.models.Login;
import edu.iest.registrodeusuario.network.APIInterface;
import edu.iest.registrodeusuario.network.Api;
import edu.iest.registrodeusuario.network.GetResults;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LogIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        // Llamada al método index() de la clase GetResults
        EditText etCorreo = findViewById(R.id.etCorreoElectronico);
        EditText etPassword = findViewById(R.id.etContrasena);
        Button bnLogin = findViewById(R.id.bnLogIn);
        
        bnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                APIInterface api = Api.getClient();
                String email = etCorreo.getText().toString();
                String password = etPassword.getText().toString(); 
                Login logininfo = new Login(email, password);
                Call<Login> call = api.logUser(logininfo);

                call.enqueue(new Callback<Login>() {
                    @Override
                    public void onResponse(Call<Login> call, Response<Login> response) {
                        Login loginfo = response.body();
                        if (loginfo != null){
                            Log.e("checker", loginfo.getToken());
                        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);
                        SharedPreferences.Editor myedit = sharedPreferences.edit();
                        myedit.putString("id", loginfo.getId());
                        myedit.putString("token", loginfo.getToken());
                        myedit.putBoolean("isLogged", true);
                        myedit.commit();
                        Intent intent = new Intent(LogIn.this, Perfil.class);
                        startActivity(intent);
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
        });
        

        //SE LLAMA A LA FUNCIÓN PARA DARLE EL COLOR DE GRADIENTE AL TEXTO Y SE LE ESTABLECE EL TEXTO DESEADO
        TextView tvNoTienesCuenta = findViewById(R.id.tvNoTienesCuenta);
        GradienteAMR(tvNoTienesCuenta, "¿Aún no tienes cuenta?");

        Button bnRegistrarse = findViewById(R.id.bnRegistrarse);
        bnRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LogIn.this, Registro.class);
                startActivity(intent);
            }
        });
    }

    // Inflar el menú de opciones
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
