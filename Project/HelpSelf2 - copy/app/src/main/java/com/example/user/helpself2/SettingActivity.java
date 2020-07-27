package com.example.user.helpself2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SettingActivity extends AppCompatActivity {
    EditText edtphone;
    TextView msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.helpself);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        edtphone = (EditText) findViewById(R.id.edtphone);
        Button btnupdate = (Button) findViewById(R.id.btnupdate);
        msg=(TextView)findViewById(R.id.msg);
        btnupdate.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (!("".equals(edtphone.getText().toString()))) {
                    SharedPreferences sharedPreferences = getSharedPreferences("data", MODE_PRIVATE);
                    sharedPreferences.edit().putString("phone", edtphone.getText().toString()).apply();
                    msg.setText("您設定的緊急連絡電話  "+"\n"+sharedPreferences.getString("phone" , "")+"\n"+"已儲存/修改成功");
                }


            }
        });

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
