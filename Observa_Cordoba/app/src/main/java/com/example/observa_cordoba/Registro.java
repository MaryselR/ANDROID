package com.example.observa_cordoba;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.provider.ContactsContract;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;

public class Registro extends AppCompatActivity {

    Button confirmar;
    EditText usuario,correo,contrasenia;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        miObservadorDB dbHelper = new miObservadorDB(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        confirmar = (Button) findViewById(R.id.btnConfirmar);
        usuario = (EditText) findViewById(R.id.ingresoUsuario);
        correo = (EditText) findViewById(R.id.ingresoEmail);
        contrasenia = (EditText) findViewById(R.id.ingresoPassword);

        confirmar.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                String usuarioNuevo = usuario.getText().toString();
                String correoNuevo = correo.getText().toString();
                String contraseniaNueva = contrasenia.getText().toString();

                if (db != null) {

                    // Insert con ContentValues
                    ContentValues cv = new ContentValues();
                    cv.put("usuario", usuarioNuevo);
                    cv.put("correo", correoNuevo);
                    cv.put("contrasenia", contraseniaNueva);
                    db.insert("usuarios", null, cv);

                    }
                    if (usuarioNuevo.isEmpty() || correoNuevo.isEmpty() || contraseniaNueva.isEmpty()) {
                        Toast.makeText(Registro.this, "Ingresar datos requeridos", Toast.LENGTH_LONG).show();
                        return;
                    }else{
                        Toast.makeText(getApplicationContext(), "Registro exitoso", Toast.LENGTH_LONG).show();
                        }

                    String message = usuario.getText().toString();

                    Intent i = new Intent(getApplicationContext(), Inicio.class);
                    startActivity(i);

                    Intent inicioIntent = new Intent(getApplicationContext(), Inicio.class);
                    inicioIntent.putExtra(EXTRA_MESSAGE, message);
                    startActivity(inicioIntent);
                }
        });
    }

    private void regUser(String emailUser, String passwordUser) {
        mAuth.signInWithEmailAndPassword(emailUser, passwordUser).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    finish();
                    startActivity(new Intent(Registro.this, MainActivity.class));
                    Toast.makeText(Registro.this, "¡Bienvenido!", Toast.LENGTH_LONG).show();
                } else {
                    FirebaseAuthException e = (FirebaseAuthException) task.getException();
                    Toast.makeText(Registro.this, "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
                }
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