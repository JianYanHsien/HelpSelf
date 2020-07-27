package com.example.user.helpself2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class CprPdf extends AppCompatActivity {

    PDFView cpr_pdf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cpr_pdf);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.helpself);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        cpr_pdf=(PDFView) findViewById(R.id.cpr_pdf);
        cpr_pdf.fromAsset("cpr.pdf").load();
    }
}
