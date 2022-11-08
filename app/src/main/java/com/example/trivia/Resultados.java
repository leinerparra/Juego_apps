package com.example.trivia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Resultados extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);

        final AppCompatButton EmpezarNuevo = findViewById(R.id.EmpezarIdNuevo);
        final TextView Correctas = findViewById(R.id.PreguntasCorrectas);
        final TextView Incorrectas = findViewById(R.id.PreguntasIncorrectas);

        final int getRespuestasCorrectas = getIntent().getIntExtra("Correcto",0);
        final int getRespuestasIncorrectas = getIntent().getIntExtra("Incorrecto",0);

        Correctas.setText(String.valueOf(getRespuestasCorrectas));
        Incorrectas.setText(String.valueOf(getRespuestasIncorrectas));

        EmpezarNuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Resultados.this,MainActivity.class));
                finish();
            }
        });

    }

    @Override
    public void onBackPressed() {

        startActivity(new Intent(Resultados.this,MainActivity.class));
        finish();
    }
}