package com.example.trivia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class JuegoTrivia extends AppCompatActivity {

    private TextView questions;
    private TextView question;
    private AppCompatButton opcion1,opcion2,opcion3,opcion4;
    private Timer TiempoTrivia;
    private AppCompatButton siguienteBtn;

    private int TiempoTotal =1;
    private int seconds =0;

    private final List<ListaPreguntas> questionLists = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego_trivia);

        final ImageView backBTn = findViewById(R.id.backBtn);
        final TextView timer = findViewById(R.id.timer);
        final TextView selectedTopicName = findViewById(R.id.TopicName);

        questions = findViewById(R.id.Preguntas);
        question = findViewById(R.id.Pregunta);

        opcion1 = findViewById(R.id.Opcion1);
        opcion2 = findViewById(R.id.Opcion2);
        opcion3 = findViewById(R.id.Opcion3);
        opcion4 = findViewById(R.id.Opcion4);

        siguienteBtn = findViewById(R.id.SiguienteBTN);

        final String getSelectedName = getIntent().getStringExtra("SelectedTopic");

        selectedTopicName.setText(getSelectedName);



    }

    private void startTimer(TextView timerTextView)
    {
        TiempoTrivia = new Timer();

        TiempoTrivia.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                if(seconds == 0)
                {
                    TiempoTotal--;
                    seconds = 50;
                }
                else if(seconds == 0 && TiempoTotal ==0)
                {
                    TiempoTrivia.purge();
                    TiempoTrivia.cancel();

                    Toast.makeText(JuegoTrivia.this,"Tiempo FInal", Toast.LENGTH_SHORT).show();

                    Intent intento = new Intent(JuegoTrivia.this, Resultados.class);
                    intento.putExtra("Correcto", );

                }
            }
        }, 1000,1000);
    }

    private int getRespuestasCorrectas()
    {

    }
}