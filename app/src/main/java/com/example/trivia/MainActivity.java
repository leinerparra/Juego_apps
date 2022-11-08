package com.example.trivia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String selectedTopicName = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final LinearLayout futbol = findViewById( R.id.futbollayout);
        final LinearLayout basket = findViewById(R.id.basketlayout);
        final LinearLayout ciclismo = findViewById(R.id.Ciclismolayout);
        final LinearLayout volley = findViewById(R.id.volleylayout);

        final Button startButton = findViewById(R.id.start);


        futbol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectedTopicName = "futbol";

                futbol.setBackgroundResource(R.drawable.layout_error);

                basket.setBackgroundResource(R.drawable.layout_futbol);
                ciclismo.setBackgroundResource(R.drawable.layout_futbol);
                volley.setBackgroundResource(R.drawable.layout_futbol);



            }
        });


        basket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectedTopicName = "basket";

                basket.setBackgroundResource(R.drawable.layout_error);

                futbol.setBackgroundResource(R.drawable.layout_futbol);
                ciclismo.setBackgroundResource(R.drawable.layout_futbol);
                volley.setBackgroundResource(R.drawable.layout_futbol);

            }
        });

        ciclismo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectedTopicName = "ciclismo";

                ciclismo.setBackgroundResource(R.drawable.layout_error);

                basket.setBackgroundResource(R.drawable.layout_futbol);
                futbol.setBackgroundResource(R.drawable.layout_futbol);
                volley.setBackgroundResource(R.drawable.layout_futbol);
            }
        });

        volley.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectedTopicName = "volley";

                volley.setBackgroundResource(R.drawable.layout_error);

                basket.setBackgroundResource(R.drawable.layout_futbol);
                ciclismo.setBackgroundResource(R.drawable.layout_futbol);
                futbol.setBackgroundResource(R.drawable.layout_futbol);
            }
        });


        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(selectedTopicName.isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Seleccione un Tema", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent intento = new Intent(MainActivity.this,JuegoTrivia.class);
                    intento.putExtra("Tema Seleccionado",selectedTopicName);
                    startActivity(intento);
                }
            }
        });

    }
}
