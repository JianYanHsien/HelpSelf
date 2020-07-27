package com.example.user.helpself2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SafeActivity extends AppCompatActivity {

    Button btn_wild_mountain,btn_wild_snake,btn_eat_fungus,btn_eat_vegetables;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safe);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.helpself);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        /*pdfview wild mountain*/
        btn_wild_mountain=(Button) findViewById(R.id.wild_moumtain);
        btn_wild_mountain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(SafeActivity.this,WildMountain.class);
                startActivity(i);
            }
        });

        /*pdfview wild snake*/
        btn_wild_snake=(Button) findViewById(R.id.wild_snake);
        btn_wild_snake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2=new Intent(SafeActivity.this,WildSnake.class);
                startActivity(i2);
            }
        });

        /*pdfview eat fungus*/
        btn_eat_fungus=(Button) findViewById(R.id.eat_fungus);
        btn_eat_fungus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i3=new Intent(SafeActivity.this,EatFungus.class);
                startActivity(i3);
            }
        });

        /*pdfview eat  vegetables*/
        btn_eat_vegetables=(Button) findViewById(R.id.eat_vegetables);
        btn_eat_vegetables.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i4=new Intent(SafeActivity.this,EatVegetables.class);
                startActivity(i4);
            }
        });


    }

    public void gocpr(View view){ //前往CPR+影片畫面
        Intent it = new Intent(this,CprVideoActivity.class);
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
