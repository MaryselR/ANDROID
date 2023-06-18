package com.example.observa_cordoba;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void activity_registro(View vista) {
        setup();
        Intent registroIntent = new Intent(this, Registro.class);
        startActivity(registroIntent);
    }

    /*Enlace entre bienvenida y loguin*/
    public void activity_loguin(View vista){
        Intent loguinIntent = new Intent(this, Loguin.class);
        startActivity(loguinIntent);
        finish();
    }

    private void setup()
    {
        setTitle("Autenticación");
    }
}