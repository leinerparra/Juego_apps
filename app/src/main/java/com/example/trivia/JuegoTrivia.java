package com.example.trivia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.graphics.Color;
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

    private List<ListaPreguntas> questionLists;

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

        final String getSelectedName = getIntent().getStringExtra("Tema Seleccionado");

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

                if(SeleccionUsuario.isEmpty())
                {
                    SeleccionUsuario = opcion1.getText().toString();

                    opcion1.setBackgroundResource(R.drawable.layout_error);
                    opcion1.setTextColor(Color.WHITE);

                    RevelarRespuesta();

                    questionLists.get(PosicionPreguntas).setSeleccionUsuario(SeleccionUsuario);

                }



            }
        });

        opcion2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(SeleccionUsuario.isEmpty())
                {
                    SeleccionUsuario = opcion2.getText().toString();

                    opcion2.setBackgroundResource(R.drawable.layout_error);
                    opcion2.setTextColor(Color.WHITE);

                    RevelarRespuesta();

                    questionLists.get(PosicionPreguntas).setSeleccionUsuario(SeleccionUsuario);

                }

            }
        });

        opcion3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(SeleccionUsuario.isEmpty())
                {
                    SeleccionUsuario = opcion3.getText().toString();

                    opcion3.setBackgroundResource(R.drawable.layout_error);
                    opcion3.setTextColor(Color.WHITE);

                    RevelarRespuesta();

                    questionLists.get(PosicionPreguntas).setSeleccionUsuario(SeleccionUsuario);

                }

            }
        });

        opcion4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(SeleccionUsuario.isEmpty())
                {
                    SeleccionUsuario = opcion4.getText().toString();

                    opcion4.setBackgroundResource(R.drawable.layout_error);
                    opcion4.setTextColor(Color.WHITE);

                    RevelarRespuesta();

                    questionLists.get(PosicionPreguntas).setSeleccionUsuario(SeleccionUsuario);

                }

            }
        });

        siguienteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(SeleccionUsuario.isEmpty())
                {
                    Toast.makeText(JuegoTrivia.this,"Seleccione una Respuesta",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    CambiarPregunta();

                }

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

    private void CambiarPregunta()
    {
        PosicionPreguntas++;
        if((PosicionPreguntas+1)== questionLists.size())
        {
            siguienteBtn.setText("Acabar");
        }

        if(PosicionPreguntas < questionLists.size())
        {
            SeleccionUsuario ="";

            opcion1.setBackgroundResource(R.drawable.layout_futbol);
            opcion1.setTextColor(Color.parseColor("#1f6bb8"));

            opcion2.setBackgroundResource(R.drawable.layout_futbol);
            opcion2.setTextColor(Color.parseColor("#1f6bb8"));

            opcion3.setBackgroundResource(R.drawable.layout_futbol);
            opcion3.setTextColor(Color.parseColor("#1f6bb8"));

            opcion4.setBackgroundResource(R.drawable.layout_futbol);
            opcion4.setTextColor(Color.parseColor("#1f6bb8"));

            questions.setText((PosicionPreguntas+1)+"/" + questionLists.size());
            question.setText(questionLists.get(PosicionPreguntas).getPregunta());
            opcion1.setText(questionLists.get(PosicionPreguntas).getOpcion1());
            opcion2.setText(questionLists.get(PosicionPreguntas).getOpcion2());
            opcion3.setText(questionLists.get(PosicionPreguntas).getOpcion3());
            opcion4.setText(questionLists.get(PosicionPreguntas).getOpcion4());


        }

        else
        {
            Intent intento = new Intent(JuegoTrivia.this,Resultados.class);
            intento.putExtra("Correcto",getRespuestasCorrectas());
            intento.putExtra("Incorrecto",getRespuestasInCorrectas());
            startActivity(intento);

            finish();
        }
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

    private void RevelarRespuesta()
    {
        final String getAnswer = questionLists.get(PosicionPreguntas).getRespuesta();

        if(opcion1.getText().toString().equals(getAnswer))
        {
            opcion1.setBackgroundResource(R.drawable.layout_background_button);
            opcion1.setTextColor(Color.WHITE);
        }

        else if(opcion2.getText().toString().equals(getAnswer))
        {
            opcion2.setBackgroundResource(R.drawable.layout_background_button);
            opcion2.setTextColor(Color.WHITE);
        }

        else if(opcion3.getText().toString().equals(getAnswer))
        {
            opcion3.setBackgroundResource(R.drawable.layout_background_button);
            opcion3.setTextColor(Color.WHITE);
        }

        else if(opcion4.getText().toString().equals(getAnswer))
        {
            opcion4.setBackgroundResource(R.drawable.layout_background_button);
            opcion4.setTextColor(Color.WHITE);
        }
    }
}