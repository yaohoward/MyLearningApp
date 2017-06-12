package com.bochk.howard.mylearningapplication.chap05;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.BoolRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.bochk.howard.mylearningapplication.R;

public class MainActivity extends AppCompatActivity {

    /* P172 动态注册方式 begin
    private IntentFilter intentFilter;
    private NetworkChangeReceiver networkChangeReceiver;
    /*P172 end*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_chap05);

        /* P172 动态注册方式 begin
        intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        networkChangeReceiver = new NetworkChangeReceiver();
        registerReceiver(networkChangeReceiver,intentFilter);
        /*P172 end*/

        /*P179 发送自定义广播，使用的接收器是静态设置的*/
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.bochk.howard.mylearningapplication.chap05.MY_BROADCAST");
                sendBroadcast(intent);
            }
        });

         /*P179 end*/
    }

    /*P172 动态注册方式 begin
    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(networkChangeReceiver);
    }

    class NetworkChangeReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context, "network change",Toast.LENGTH_SHORT ).show();
        }
    }
    */
}
