package com.example.user.helpself2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HPActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hp);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.helpself);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
    }
    public void onClick(View view){
        Intent it=new Intent(Intent.ACTION_VIEW);
        switch (view.getId()){
            case R.id.btnPolice:
                it.setData(Uri.parse("geo:?q=police"));
                break;
            case R.id.btnHospital:
                it.setData(Uri.parse("geo:?q=hospital"));
                break;
            case R.id.btnClinic:
                it.setData(Uri.parse("geo:?q=clinic"));
                break;
            case R.id.btnGasstation:
                it.setData(Uri.parse("geo:?q=gas station"));
                break;
        }
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
