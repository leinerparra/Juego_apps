package com.example.trivia;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private String selectedTopicName ="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final LinearLayout futbol = findViewById(R.id.futbol);
        final LinearLayout basket = findViewById(R.id.basket);
        final LinearLayout ciclismo = findViewById(R.id.ciclismo);
        final LinearLayout volley = findViewById(R.id.Volley);

        final Button StartButton = findViewById(R.id.start);

        futbol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                selectedTopicName ="futbol";

                futbol.setBackgroundResource(R.drawable.layout_futbol);

                basket.setBackgroundResource(R.drawable.layout_futbol);
                ciclismo.setBackgroundResource(R.drawable.layout_futbol);
                volley.setBackgroundResource(R.drawable.layout_futbol);
            }
        });

        basket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                selectedTopicName ="basket";

                basket.setBackgroundResource(R.drawable.layout_futbol);

                futbol.setBackgroundResource(R.drawable.layout_futbol);
                ciclismo.setBackgroundResource(R.drawable.layout_futbol);
                volley.setBackgroundResource(R.drawable.layout_futbol);

            }
        });

        ciclismo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                selectedTopicName ="ciclismo";

                ciclismo.setBackgroundResource(R.drawable.layout_futbol);

                basket.setBackgroundResource(R.drawable.layout_futbol);
                futbol.setBackgroundResource(R.drawable.layout_futbol);
                volley.setBackgroundResource(R.drawable.layout_futbol);
            }
        });

        volley.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                selectedTopicName ="volley";

                volley.setBackgroundResource(R.drawable.layout_futbol);

                basket.setBackgroundResource(R.drawable.layout_futbol);
                ciclismo.setBackgroundResource(R.drawable.layout_futbol);
                futbol.setBackgroundResource(R.drawable.layout_futbol);
            }
        });

    }
}
