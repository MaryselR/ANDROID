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
    EditText usuario,correo,contrasenia, txtUsuario;

    SQLite_OpenHelper helper=new SQLite_OpenHelper(this,"MiObservador",null,1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        confirmar = (Button) findViewById(R.id.btnConfirmar);
        usuario = (EditText) findViewById(R.id.ingresoUsuario);
        correo = (EditText) findViewById(R.id.ingresoEmail);
        contrasenia = (EditText) findViewById(R.id.ingresoPassword);

        confirmar.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                helper.abrir();
                helper.insertarRegistro(String.valueOf(usuario.getText()),String.valueOf(correo.getText()),String.valueOf(contrasenia.getText()));
                helper.cerrar();

                Toast.makeText(getApplicationContext(),"Registro exitoso",Toast.LENGTH_LONG).show();
                String message = usuario.getText().toString();

                Intent i = new Intent(getApplicationContext(), Inicio.class);
               startActivity(i);
                Intent inicioIntent = new Intent(getApplicationContext(), Inicio.class);
               inicioIntent.putExtra(EXTRA_MESSAGE, message);
                startActivity(inicioIntent);

            }

        });

    }
    public static final String EXTRA_MESSAGE =
            "com.example.android.Observa_Cordoba.Registro.extra.MESSAGE";
    public void MainActivity(View vista) {
        Intent mainIntent = new Intent(this, MainActivity.class);
        startActivity(mainIntent);
    }

}