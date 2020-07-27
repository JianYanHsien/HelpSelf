package com.example.user.helpself2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
public class HelpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.helpself);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
    }
    public void onClick(View view){
        Intent it=new Intent(Intent.ACTION_VIEW);
        switch (view.getId()){
            case R.id.btn112:
                it.setData(Uri.parse("tel:112"));
                break;
            case R.id.btn110:
                it.setData(Uri.parse("tel:110"));
                break;
            case R.id.btn119:
                it.setData(Uri.parse("tel:119"));
                break;
            case R.id.btn118:
                it.setData(Uri.parse("tel:118"));
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
