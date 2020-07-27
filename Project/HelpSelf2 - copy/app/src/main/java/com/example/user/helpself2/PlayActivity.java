package com.example.user.helpself2;

import android.annotation.TargetApi;
import android.content.Intent;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.VideoView;
import android.view.View;

public class PlayActivity extends AppCompatActivity {
    VideoView myVideo;
    int pos=0;//紀錄上次的撥放位置

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        //設定隱藏標題
        getSupportActionBar().hide();
        //設定隱藏狀態
        //getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);

    }

    public void onClick(View view){
            VideoView videoview = (VideoView) findViewById(R.id.myVideo);
            Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.concept_mv);
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
