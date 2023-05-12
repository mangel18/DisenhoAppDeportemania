package edu.iest.registrodeusuario;

import androidx.appcompat.app.AppCompatActivity;

import static edu.iest.registrodeusuario.TextoGradiente.GradienteAMR;
import static edu.iest.registrodeusuario.TextoGradiente.GradienteMorado;
import static edu.iest.registrodeusuario.TextoGradiente.GradienteRosa;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class InfoCarrera extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_carrera);

        //SE LLAMA A LA FUNCIÓN PARA DARLE EL COLOR DE GRADIENTE AL TEXTO Y SE LE ESTABLECE EL TEXTO DESEADO
        TextView tvTextoFecha = findViewById(R.id.tvTextoFecha);
        GradienteMorado(tvTextoFecha, "FECHA");

        TextView tvTextoHora = findViewById(R.id.tvTextoHora);
        GradienteMorado(tvTextoHora, "FECHA");

        TextView tvTextoUbicacion = findViewById(R.id.tvTextoUbicacion);
        GradienteMorado(tvTextoUbicacion, "UBICACIÓN");

        TextView tvConvocatoria = findViewById(R.id.tvConvocatoria);
        GradienteRosa(tvConvocatoria, "CONVOCATORIA");

        TextView tvProtocolo = findViewById(R.id.tvProtocolo);
        GradienteMorado(tvProtocolo, "PROTOCOLO");

        TextView tvInscripciones = findViewById(R.id.tvInscripciones);
        GradienteRosa(tvInscripciones, "INSCRIPCIONES");

        TextView tvInfoGeneral = findViewById(R.id.tvInfoGeneral);
        GradienteRosa(tvInfoGeneral, "INFORMACIÓN GENERAL");

        TextView tvEntregaDeKits = findViewById(R.id.tvEntregaDeKits);
        GradienteMorado(tvEntregaDeKits, "ENTREGA DE KITS");

        TextView tvFAQ = findViewById(R.id.tvFAQ);
        GradienteRosa(tvFAQ, "PREGUNTAS FRECUENTES");
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