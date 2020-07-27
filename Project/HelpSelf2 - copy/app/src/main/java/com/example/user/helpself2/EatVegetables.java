package com.example.user.helpself2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class EatVegetables extends AppCompatActivity {

    PDFView eat_vegetables;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eat_vegetables);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.helpself);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        eat_vegetables=(PDFView) findViewById(R.id.eat_vegetables);
        eat_vegetables.fromAsset("eat_vegetables.pdf").load();
    }
}
