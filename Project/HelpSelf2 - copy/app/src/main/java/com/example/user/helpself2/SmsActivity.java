package com.example.user.helpself2;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Locale;

public class SmsActivity extends AppCompatActivity implements LocationListener {
    static final int MIN_TIME = 5000;// 位置更新條件：5000 毫秒
    static final float MIN_DIST = 0; // 位置更新條件：5 公尺
    LocationManager mgr;        // 定位總管
    TextView txvLoc;
    TextView txvSetting;

    Location myLocation;    //儲存最近的定位資料
    Geocoder geocoder;       //用來查詢地址的 Geocoder 物件
    EditText edtLat,edtLon;  //經緯度輸入欄位

    boolean isGPSEnabled;      //GPS定位是否可用
    boolean isNetworkEnabled;  //網路定位是否可用
    boolean permissionRequested = false;  //是否已經向使用者要求過權限

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.helpself);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        txvLoc = (TextView) findViewById(R.id.txvLoc);
        txvSetting = (TextView) findViewById(R.id.txvSetting);

        // 取得系統服務的LocationManager物件
        mgr = (LocationManager) getSystemService(LOCATION_SERVICE);

        edtLat = (EditText) findViewById(R.id.edtLan);
        edtLon = (EditText) findViewById(R.id.edtLon);
        geocoder = new Geocoder(this,     //建立 Geocoder 物件
                Locale.getDefault());

        // 檢查若尚未授權, 則向使用者要求定位權限
        checkPermission();
    }
    private void checkPermission() {
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, 200);
        }
    }
    protected void onResume() {
        super.onResume();

        enableLocationUpdates(true);    //開啟定位更新功能

        String str="GPS定位:"+ (isGPSEnabled?"開啟":"關閉");
        str += "\n網路定位:"+ (isNetworkEnabled?"開啟":"關閉");
        txvSetting.setText(str);    //顯示 GPS 與網路定位是否可用
    } protected  void onPause() {
        super.onPause();
        enableLocationUpdates(false);    //關閉定位更新功能
    }
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == 200){
            if (grantResults.length >= 1 &&
                    grantResults[0] != PackageManager.PERMISSION_GRANTED) {  // 使用者不允許權限
                Toast.makeText(this, "程式需要定位權限才能運作", Toast.LENGTH_LONG).show();
            }
        }
    }
    private void enableLocationUpdates(boolean isTurnOn) {
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED)
        {  // 使用者已經允許定位權限
            if (isTurnOn) {
                //檢查 GPS 與網路定位是否可用
                isGPSEnabled = mgr.isProviderEnabled(LocationManager.GPS_PROVIDER);
                isNetworkEnabled = mgr.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

                if (!isGPSEnabled && !isNetworkEnabled) {
                    // 無提供者, 顯示提示訊息
                    Toast.makeText(this, "請確認已開啟定位功能!", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(this, "取得定位資訊中...", Toast.LENGTH_LONG).show();
                    if (isGPSEnabled)
                        mgr.requestLocationUpdates(   //向 GPS 定位提供者註冊位置事件監聽器
                                LocationManager.GPS_PROVIDER, MIN_TIME, MIN_DIST, this);
                    if (isNetworkEnabled)
                        mgr.requestLocationUpdates(   //向網路定位提供者註冊位置事件監聽器
                                LocationManager.NETWORK_PROVIDER, MIN_TIME, MIN_DIST, this);
                }
            }
            else {
                mgr.removeUpdates(this);    //停止監聽位置事件
            }
        }
    }public void getLocation(View v) {

    }
    public void onClick(View view){
        Intent it=new Intent(Intent.ACTION_VIEW);

        switch (view.getId()){
            case R.id.btnHelp:
            Intent help=new Intent(this,HelpActivity.class);
            startActivity(help);
            break;

            case R.id.btnHP:
                Intent hp=new Intent(this,HPActivity.class);
                startActivity(hp);
                break;

            case R.id.btnKnow://開啟救急知識頁

                break;
        }
        startActivity(it);
    }






    public void setup(View v) {
        Intent it =	// 使用Intent物件啟動"定位"設定程式
                new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
        startActivity(it);

    }
    public void sms(View view){


// "以手機位置當輸入"鈕的On Click 事件
        if(myLocation!=null){	// 若位置物件非null
            edtLat.setText(Double.toString(myLocation.getLatitude()));// 將經度轉成字串
            edtLon.setText(Double.toString(myLocation.getLongitude()));// 將緯度值轉成字串
        }
        else
            txvLoc.setText("無法取得定位資料！");

        // "用經緯度查地址"鈕的On Click 事件
        String strLat = edtLat.getText().toString();	// 取輸入的緯度字串
        String strLon = edtLon.getText().toString();	// 取輸入的經度字串

        if(strLat.length() == 0 || strLon.length() == 0) // 當字串為空白時
            return;										 // 結束處理

        txvLoc.setText("讀取中...");
        double latitude = Double.parseDouble(strLat);  // 取得緯度值
        double longitude = Double.parseDouble(strLon); // 取得經度值

        String strAddr = "";	// 用來建立所要顯示的訊息字串 (地址字串)
        try {
            List<Address> listAddr = geocoder.
                    getFromLocation(latitude, longitude,// 用經緯度查地址
                            1);	// 只需傳回1筆地址資料

            if (listAddr == null || listAddr.size() == 0) 	//檢查是否有取得地址
                strAddr += "無法取得地址資料!";
            else {
                Address addr = listAddr.get(0);	// 取 List 中的第一筆(也是唯一的一筆)
                for (int i = 0; i <= addr.getMaxAddressLineIndex(); i++)
                    strAddr += addr.getAddressLine(i) + "\n";
            }
        } catch (Exception ex) {
            strAddr += "取得地址發生錯誤:" + ex.toString();
        }
        txvLoc.setText(strAddr);


        Intent it=new Intent(Intent.ACTION_VIEW);
        SharedPreferences sharedPreferences = getSharedPreferences("data" , MODE_PRIVATE);
        String phone = sharedPreferences.getString("phone" , "0");

        it.setData(Uri.parse("sms:"+sharedPreferences.getString("phone" , "")+"?body=https://www.google.com.tw/maps/place/"+txvLoc.getText()));
        startActivity(it);
    }

    @Override
    public void onLocationChanged(Location location) {
        myLocation=location;
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }public void gohelp(View view){    //開啟求救電話頁面
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
