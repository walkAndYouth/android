package com.example.zhang.app2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private IntentFilter intentFilter;
    private NetworkChanger networkChanger;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intentFilter = new IntentFilter();
        networkChanger = new NetworkChanger();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(networkChanger,intentFilter);


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        unregisterReceiver(networkChanger);
    }

    class NetworkChanger extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
  //          Toast.makeText(context,"net changed",Toast.LENGTH_SHORT).show();
            ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if(networkInfo != null && networkInfo.isAvailable()){
                Toast.makeText(context,"net work is active",Toast.LENGTH_SHORT).show();
            }
            else
                Toast.makeText(context,"net work is not active ",Toast.LENGTH_SHORT).show();
        }
    }
}
