package com.example.user.helpself2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class WildMountain extends AppCompatActivity {
   // PDFView wild_mountain;
   PDFView wild_mountain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wild_mountain);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.helpself);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        wild_mountain=(PDFView) findViewById(R.id.wild_moumtain);
        wild_mountain.fromAsset("wild_mountain.pdf").load();
    }
}
