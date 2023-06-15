package com.example.observa_cordoba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Loguin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loguin);
    }

    /*Enlace entre loguin y bienvenida*/
    public void activity_bienvenida(View vista){
        Intent bienvenidaIntent = new Intent(this, MainActivity.class);
        startActivity(bienvenidaIntent);
        finish();
    }

    /*Enlace entre loguin y registro*/
    public void activity_registro(View vista){
        Intent registroIntent = new Intent(this, Registro.class);
        startActivity(registroIntent);
        finish();
    }

}