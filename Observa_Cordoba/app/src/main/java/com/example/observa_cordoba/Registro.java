package com.example.observa_cordoba;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.provider.ContactsContract;
import android.view.View;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class Registro extends AppCompatActivity {

    private EditText txtUsuario;
    EditText registroUsuario, registroEmail, registroPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        txtUsuario = findViewById(R.id.ingresoUsuario);

        registroUsuario = findViewById(R.id.ingresoUsuario);
        registroEmail = findViewById(R.id.ingresoEmail);
        registroPassword = findViewById(R.id.ingresoPassword);
    }
    public void MainActivity(View vista) {
        Intent mainIntent = new Intent(this, MainActivity.class);
        startActivity(mainIntent);
    }

    public void Inicio(View vista) {
        Intent inicioIntent = new Intent(this, Inicio.class);
        String message = txtUsuario.getText().toString();
        inicioIntent.putExtra(EXTRA_MESSAGE, message);
        startActivity(inicioIntent);

        String userName = registroUsuario.getText().toString().trim();
        String userPassword = registroPassword.getText().toString().trim();
        String userEmail = registroEmail.getText().toString().trim();

        if (userName.isEmpty() || userPassword.isEmpty() || userEmail.isEmpty()) {
            Toast.makeText(Registro.this, "Ingresar datos requeridos", Toast.LENGTH_LONG).show();
        } else {
            nuevoUsuario(userName, userEmail, userPassword);
        }
    }

    public static final String EXTRA_MESSAGE =
            "com.example.android.Observa_Cordoba.Registro.extra.MESSAGE";
           /* "com.example.android.registroUsuario.extra.MESSAGE";*/
    private void nuevoUsuario(String userName, String userEmail, String userPassword){

    }
}