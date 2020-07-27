package com.example.user.helpself2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.helpself);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        //設定隱藏標題
        //getSupportActionBar().hide();
        //設定隱藏狀態
        //getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
    }

    public void onClick(View view){
        Intent it=new Intent(Intent.ACTION_VIEW);

        switch (view.getId()){
                case R.id.btnCall://撥打給緊急聯絡人
                    SharedPreferences sharedPreferences = getSharedPreferences("data" , MODE_PRIVATE);
                    String phone = sharedPreferences.getString("phone" , "0");
                it.setData(Uri.parse("tel:"+sharedPreferences.getString("phone" , "")));
                break;
        }
        startActivity(it);
    }
    public void golight(View view){     //開啟指南針頁面
        Intent it = new Intent(this,CompassActivity.class);
        startActivity(it);
    }

    public void gosms(View view){   //開啟位址傳送頁面
        Intent it = new Intent(this,SmsActivity.class);
        startActivity(it);
    }

    public void gosos(View view){    //開啟SOS系統頁面
        Intent it = new Intent(this,SosActivity.class);
        startActivity(it);
    }

    public void goplay(View view){     //開啟緊急影片頁面
        Intent it = new Intent(this,PlayActivity.class);
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
        Intent it = new Intent(this,SettingActivity.class);
        startActivity(it);
    }
}
