package edu.iest.registrodeusuario;

import static edu.iest.registrodeusuario.TextoGradiente.GradienteMorado;
import static edu.iest.registrodeusuario.TextoGradiente.GradienteRosa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Perfil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        //SE LLAMA A LA FUNCIÓN PARA DARLE EL COLOR DE GRADIENTE AL TEXTO Y SE LE ESTABLECE EL TEXTO DESEADO
        TextView tvNombreUsuario = findViewById(R.id.tvUsuario);
        GradienteRosa(tvNombreUsuario, "NOMBRE DE USUARIO");

        TextView tvInfoAdicional = findViewById(R.id.tvInfoAdicional);
        GradienteMorado(tvInfoAdicional, "INFORMACIÓN ADICIONAL");

        TextView tvCarrerasPasadas = findViewById(R.id.tvCarrerasPasadas);
        GradienteMorado(tvCarrerasPasadas, "CARRERAS PASADAS");

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
                startActivity(new Intent(this, LogIn.class));
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