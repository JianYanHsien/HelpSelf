package com.example.user.helpself2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class EatFungus extends AppCompatActivity {

    PDFView eat_fungus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eat_fungus);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.helpself);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        eat_fungus=(PDFView) findViewById(R.id.eat_fungus);
        eat_fungus.fromAsset("eat_fungus.pdf").load();
    }
}
