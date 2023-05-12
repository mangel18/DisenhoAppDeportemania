package edu.iest.registrodeusuario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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