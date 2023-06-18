package com.example.observa_cordoba;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.provider.ContactsContract;
import android.view.View;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class Registro extends AppCompatActivity {

    EditText registroUsuario, registroEmail, registroPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

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
        startActivity(inicioIntent);

        String userName = registroUsuario.getText().toString().trim();
        String userPassword = registroPassword.getText().toString().trim();
        String userEmail = registroEmail.getText().toString().trim();

        if (userName.isEmpty() || userPassword.isEmpty() || userEmail.isEmpty()) {
            Toast.makeText(Registro.this, "Ingresar datos requeridos", Toast.LENGTH_SHORT).show();
        } else {
            nuevoUsuario(userName, userEmail, userPassword);
        }

    }

    private void nuevoUsuario(String userName, String userEmail, String userPassword){

    }
}