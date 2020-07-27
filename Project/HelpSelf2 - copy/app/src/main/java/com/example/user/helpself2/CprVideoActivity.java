package com.example.user.helpself2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class CprVideoActivity extends AppCompatActivity {
    Button btn_cpr_pdf;
    VideoView myVideo_cpr;
    int pos=0;//紀錄上次的撥放位置

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cpr_video);

        //設定隱藏標題
        getSupportActionBar().hide();

       /* logo
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.helpself);
        getSupportActionBar().setDisplayUseLogoEnabled(true);  */

        /*pdfview wild mountain*/
        btn_cpr_pdf=(Button) findViewById(R.id.cpr_pdf);
        btn_cpr_pdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(CprVideoActivity.this,CprPdf.class);
                startActivity(i);
            }
        });
    }

    public void onClick(View view){
        VideoView videoview = (VideoView) findViewById(R.id.myVideo_cpr);
        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.cpr_mv);
        videoview.setVideoURI(uri);
        videoview.start();

    }

    public void gohelp(View view){    //開啟求救電話頁面
        Intent it = new Intent(this,HelpActivity.class);
        startActivity(it);
    }

    public void gohp(View view){     //開啟醫院警局頁面
        Intent it = new Intent(this,HPActivity.class);
        startActivity(it);
    }

    public void gosafe(View view){     //開啟安全求生資訊頁面
        Intent it = new Intent(this,SafeActivity.class);
        startActivity(it);
    }

    public void gohome(View view){     //開啟主頁面
        Intent it = new Intent(this,MainActivity.class);
        startActivity(it);
    }

}
