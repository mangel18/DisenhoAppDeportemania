package edu.iest.registrodeusuario;

import androidx.appcompat.app.AppCompatActivity;
import static edu.iest.registrodeusuario.TextoGradiente.GradienteAMR;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LogIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_home:
                Intent intent = new Intent(this, Registro.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}