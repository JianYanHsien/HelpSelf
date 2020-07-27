package com.example.user.helpself2;

import android.annotation.TargetApi;
import android.content.Intent;
import android.media.SoundPool;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SosActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnWarnVoice;
    private SoundPool soundPool;
    private int soundID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sos);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.helpself);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        //設定隱藏btnWarnVoiceActionBar().hide();
        //設定隱藏狀態
        //getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);

        btnWarnVoice = (Button) findViewById(R.id.btnWarnVoice);
        btnWarnVoice.setOnClickListener(this);
        initSound();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void initSound() {
        soundPool = new SoundPool.Builder().build();
        soundID = soundPool.load(this, R.raw.sossound, 1);
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.btnWarnVoice:
                playSound();
                break;
        }
    }

    private void playSound() {
        soundPool.play(
                soundID,
                1f, //右耳聲道(0~1)
                1f, //左耳 (0~1)
                0, //撥放優先級(0表示最低優先級)
                0, //循環模式(0表示循環一次，-1表示一直循環，其表示數字 +1表示當前數字對應的循環次數 )
                1 // 播放速度(1是正常，範圍0~2)
        );
    }

    public void gorblight(View view){
        Intent it = new Intent(this,RBlightActivity.class);
        startActivity(it);
    }

    public void gososlight(View view){
        Intent it = new Intent(this,CompassActivity.class);
        startActivity(it);
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
