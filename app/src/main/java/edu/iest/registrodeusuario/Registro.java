package edu.iest.registrodeusuario;

import static edu.iest.registrodeusuario.TextoGradiente.GradienteAMR;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Registro extends AppCompatActivity {
    private EditText etNombreApellido;
    private EditText etFechaNacimiento;
    private EditText etCorreoElectronico;
    private RadioGroup rgSexo;
    private EditText etCiudadResidencia;
    private EditText etContrasena;
    private Button bnRegistrarse;
    private Spinner spinnerItems;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        // Inicializar vistas
        etNombreApellido = findViewById(R.id.etNombreApellido);
        etFechaNacimiento = findViewById(R.id.etFechaNacimiento);
        etCorreoElectronico = findViewById(R.id.etCorreoElectronico);
        rgSexo = findViewById(R.id.rgSexo);
        etCiudadResidencia = findViewById(R.id.etCiudadResidencia);
        etContrasena = findViewById(R.id.etContrasena);
        bnRegistrarse = findViewById(R.id.bnRegistrarse);
        spinnerItems = findViewById(R.id.spinner_items);

        //SE LLAMA A LA FUNCIÓN PARA DARLE EL COLOR DE GRADIENTE AL TEXTO Y SE LE ESTABLECE EL TEXTO DESEADO
        TextView tvGenero = findViewById(R.id.tvGenero);
        GradienteAMR(tvGenero, "Género");

        TextView rbMasculino = findViewById(R.id.rbMasculino);
        GradienteAMR(rbMasculino, "Masculino");

        TextView rbFemenino = findViewById(R.id.rbFemenino);
        GradienteAMR(rbFemenino, "Femenino");

// y así sucesivamente para cada TextView que quieras actualizar


        // Crear un adapter para el spinner usando el array definido en el archivo de strings
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_items, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerItems.setAdapter(adapter);

        // Agregar listener al spinner
        spinnerItems.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Obtener el elemento seleccionado del spinner
                String selectedItem = parent.getItemAtPosition(position).toString();

                // Abrir una nueva actividad según el elemento seleccionado
                switch(selectedItem) {
                    case "Elige una vista":
                        // No hacer nada
                        break;
                    case "Log in":
                        Intent intent = new Intent(Registro.this, LogIn.class);
                        startActivity(intent);
                        break;
                    case "Contacto":
                        Intent intent1 = new Intent(Registro.this, ContactoActivity.class);
                        startActivity(intent1);
                        break;
                    case "InfoCarrera":
                        Intent intent2= new Intent(Registro.this, InfoCarrera.class);
                        startActivity(intent2);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // No hacer nada
            }
        });

        // Agregar listener al botón de guardar
        bnRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crea un objeto AlertDialog.Builder
                AlertDialog.Builder builder = new AlertDialog.Builder(Registro.this);

                // Establece el mensaje de la alerta
                builder.setMessage("¿Estás seguro de guardar los datos?");

                // Establece los botones de la alerta
                builder.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        guardarDatos();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

                // Crea y muestra el objeto AlertDialog
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
    }

    private void guardarDatos() {
        // Obtener los datos de los campos de texto
        String nombreApellido = etNombreApellido.getText().toString();
        String fechaNacimiento = etFechaNacimiento.getText().toString();
        String correoElectronico = etCorreoElectronico.getText().toString();
        String ciudadResidencia = etCiudadResidencia.getText().toString();
        String contrasena = etContrasena.getText().toString();
        int radioButtonId = rgSexo.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(radioButtonId);
        String sexo = radioButton.getText().toString();

        // Aquí puedes implementar la lógica para guardar los datos en tu base de datos o en otro lugar
        // Puedes usar las variables creadas arriba (nombreApellido, fechaNacimiento, correoElectronico, ciudadResidencia, contrasena, sexo)
        // por ejemplo, puedes hacer uso de

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
