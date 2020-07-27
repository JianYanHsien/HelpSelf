package com.example.user.helpself2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class WildSnake extends AppCompatActivity {

    PDFView wild_snake;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wild_snake);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.helpself);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        wild_snake=(PDFView) findViewById(R.id.wild_snake);
        wild_snake.fromAsset("wild_snake.pdf").load();
    }
}
