package com.example.trivia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class JuegoTrivia extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego_trivia);

        final String getSelectedName = getIntent().getStringExtra("SelectedTopic");
    }
}