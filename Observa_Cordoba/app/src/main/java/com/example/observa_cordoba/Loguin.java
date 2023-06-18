package com.example.observa_cordoba;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;

public class Loguin extends AppCompatActivity {

    Button login;
    EditText correo, contrasenia;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loguin);
        mAuth = FirebaseAuth.getInstance();

        correo = findViewById(R.id.correo);
        contrasenia = findViewById(R.id.contrasenia);
        login = findViewById(R.id.entrar);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailUser = correo.getText().toString().trim();
                String passwordUser = contrasenia.getText().toString().trim();

                if (emailUser.isEmpty() || passwordUser.isEmpty()) {
                    Toast.makeText(Loguin.this, "Ingresar datos requeridos", Toast.LENGTH_SHORT).show();
                } else {
                    loginUser(emailUser, passwordUser);
                }
            }
        });
    }

    private void loginUser(String emailUser, String passwordUser) {
        mAuth.signInWithEmailAndPassword(emailUser, passwordUser).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    finish();
                    startActivity(new Intent(Loguin.this, MainActivity.class));
                    Toast.makeText(Loguin.this, "¡Bienvenido!", Toast.LENGTH_SHORT).show();
                } else {
                    FirebaseAuthException e = (FirebaseAuthException) task.getException();
                    Toast.makeText(Loguin.this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    /*Enlace entre login y bienvenida*/
    public void activity_bienvenida(View vista) {
        Intent bienvenidaIntent = new Intent(this, MainActivity.class);
        startActivity(bienvenidaIntent);
        finish();
    }

    /*Enlace entre login y registro*/
    public void activity_registro(View vista) {
        Intent registroIntent = new Intent(this, Inicio.class);
        startActivity(registroIntent);
        finish();
    }
}