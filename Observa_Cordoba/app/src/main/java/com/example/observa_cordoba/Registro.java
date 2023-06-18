package com.example.observa_cordoba;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.provider.ContactsContract;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import OpenHelper.SQLite_OpenHelper;

public class Registro extends AppCompatActivity {

    Button confirmar;
    EditText usuario,correo,contrasenia;

    SQLite_OpenHelper helper=new SQLite_OpenHelper(this,"MiObservador",null,1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        confirmar = (Button) findViewById(R.id.btnConfirmar);
        usuario = (EditText) findViewById(R.id.inputUsuario);
        correo = (EditText) findViewById(R.id.inputEmail);
        contrasenia = (EditText) findViewById(R.id.inputContrasenia);

        confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helper.abrir();
                helper.insertarRegistro(String.valueOf(usuario.getText()),String.valueOf(correo.getText()),String.valueOf(contrasenia.getText()));
                helper.cerrar();

                Toast.makeText(getApplicationContext(),"Registro exitoso",Toast.LENGTH_LONG).show();

                Intent i = new Intent(getApplicationContext(), Inicio.class);
                startActivity(i);
            }
        });

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