package com.example.user.helpself2;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

public class CompassActivity extends AppCompatActivity implements SensorEventListener {
    private ImageView image;
    // 初始角度
    private float currentDegree = 0f;
    // 感應器管理
    private SensorManager mSensorManager;

    private TextView tvHeading;

    float[] mGravity;
    float[] mGeomagnetic;
    float Rotation[] = new float[9];
    float[] degree = new float[3];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compass);
        //設定隱藏標題
        getSupportActionBar().hide();
        //設定隱藏狀態
       // getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);

        image = (ImageView) findViewById(R.id.imageViewCompass);
        tvHeading = (TextView) findViewById(R.id.tvHeading);
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // 註冊感應監聽器

        Sensor accelerometer = mSensorManager
                .getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        Sensor magnetometer = mSensorManager
                .getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);

        mSensorManager.registerListener(this, accelerometer,
                SensorManager.SENSOR_DELAY_GAME);
        mSensorManager.registerListener(this, magnetometer,
                SensorManager.SENSOR_DELAY_GAME);
    }

    protected void onPause() {
        super.onPause();

        // 停止感應監聽器
        mSensorManager.unregisterListener(this);
    }


    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            mGravity = event.values;
        }
        if (event.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD) {
            mGeomagnetic = event.values;
        }
        if (mGravity != null && mGeomagnetic != null) {

            SensorManager.getRotationMatrix(Rotation, null, mGravity,
                    mGeomagnetic);
            SensorManager.getOrientation(Rotation, degree);

            degree[0] = (float) Math.toDegrees(degree[0]);


            tvHeading.setText("Heading: " + (int) degree[0] + " degrees");

            // currentDegree-初始角度,-degree逆時針旋轉結束角度
            RotateAnimation ra = new RotateAnimation(currentDegree, -degree[0],
                    Animation.RELATIVE_TO_SELF, 0.5f, // x座標
                    Animation.RELATIVE_TO_SELF, 0.5f); // y座標

            // 轉動時間
            ra.setDuration(210);

            // 預設狀態結束後的動作設定
            ra.setFillAfter(true);

            // 將動作放入圖片
            image.startAnimation(ra);
            currentDegree = -degree[0];
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

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
