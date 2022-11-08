package com.example.trivia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.security.cert.PKIXRevocationChecker;
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

    private List<ListaPreguntas> questionLists = new ArrayList<>();

    private int PosicionPreguntas =0;

    private String SeleccionUsuario ="";

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

        questionLists = BancoPreguntas.getQuestions(getSelectedName);

        startTimer(timer);

        questions.setText((PosicionPreguntas+1)+"/" + questionLists.size());

        question.setText(questionLists.get(0).getPregunta());

        opcion1.setText(questionLists.get(0).getOpcion1());
        opcion2.setText(questionLists.get(0).getOpcion2());
        opcion3.setText(questionLists.get(0).getOpcion3());
        opcion4.setText(questionLists.get(0).getOpcion4());

        opcion1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



            }
        });

        opcion2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        opcion3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        siguienteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        opcion4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        backBTn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TiempoTrivia.purge();
                TiempoTrivia.cancel();

                startActivity(new Intent(JuegoTrivia.this, MainActivity.class));
                finish();
            }
        });



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
                    intento.putExtra("Correcto", getRespuestasCorrectas() );
                    intento.putExtra("Incorrecto",getRespuestasInCorrectas());

                    startActivity(intento);

                    finish();


                }

                else
                {
                    seconds--;
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        String finalMinutos = String.valueOf(TiempoTotal);
                        String FinalSegundos = String.valueOf(seconds);

                        if(finalMinutos.length() ==1)
                        {
                            finalMinutos = "0" + finalMinutos;
                        }

                        if(FinalSegundos.length() ==1)
                        {
                            FinalSegundos = "0" + FinalSegundos;
                        }

                        timerTextView.setText(finalMinutos + ":" + FinalSegundos);
                    }
                });
            }
        }, 1000,1000);
    }

    //Respuestas Correctas
    private int getRespuestasCorrectas()
    {
        int respuestasCorrectas =0;

        for(int i = 0 ; i < questionLists.size();i++)
        {
            final String getSeleccionUsuario = questionLists.get(i).getSeleccionUsuario();
            final String getRespuesta = questionLists.get(i).getRespuesta();

            if(getSeleccionUsuario.equals(getRespuesta))
            {
                respuestasCorrectas++;
            }

        }
        return respuestasCorrectas;

    }
    //Respuestas Incorrectas

    private int getRespuestasInCorrectas()
    {

        int respuestasInCorrectas =0;

        for(int i = 0 ; i < questionLists.size();i++)
        {
            final String getSeleccionUsuario = questionLists.get(i).getSeleccionUsuario();
            final String getRespuesta = questionLists.get(i).getRespuesta();

            if(!getSeleccionUsuario.equals(getRespuesta))
            {
                respuestasInCorrectas++;
            }

        }
        return respuestasInCorrectas;

    }

    @Override
    public void onBackPressed() {

        TiempoTrivia.purge();
        TiempoTrivia.cancel();

        startActivity(new Intent(JuegoTrivia.this, MainActivity.class));
        finish();
    }
}