package com.gess.example.service;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityManager;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;

import com.gess.example.R;

import java.util.List;

public class ServiceActivity extends AppCompatActivity {

    private Intent startIntent;
    private Intent bindIntent;
    private ServiceConnection connection;
    private BindService.ServiceBinder binder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_service);

        findViewById(R.id.btn_start_service).setOnClickListener(v ->{
            startIntent = new Intent(ServiceActivity.this, StartService.class);
            startService(startIntent);
        });
        findViewById(R.id.btn_stop_service).setOnClickListener(v ->{
            stopService(startIntent);
        });


        findViewById(R.id.btn_bind_service).setOnClickListener(v ->{
            bindIntent = new Intent(ServiceActivity.this, BindService.class);
            connection = new ServiceConnection() {
                @Override
                public void onServiceConnected(ComponentName name, IBinder service) {
                    binder = ((BindService.ServiceBinder) service);
                }

                @Override
                public void onServiceDisconnected(ComponentName name) {

                }
            };
            bindService(bindIntent,connection, Service.BIND_AUTO_CREATE);
        });
        findViewById(R.id.btn_bind_start).setOnClickListener(v ->{
            binder.callStart();
        });
        findViewById(R.id.btn_bind_stop).setOnClickListener(v ->{
            binder.callStop();
        });
        findViewById(R.id.btn_unbind_service).setOnClickListener(v ->{
            if (connection != null){
                unbindService(connection);
            }
        });

        findViewById(R.id.btn_intent_service).setOnClickListener(v ->{
            MyIntentService.startActionBaz(ServiceActivity.this,"111","222");
        });
    }

    @Override
    protected void onDestroy() {
        if (connection != null){
            unbindService(connection);
        }

        ActivityManager manager = ((ActivityManager) getBaseContext().getSystemService(ACTIVITY_SERVICE));
        List<ActivityManager.RunningServiceInfo> list = manager.getRunningServices(20);
        if (list.size() > 0){
            for (int i = 0; i < list.size(); i++) {
                if(list.get(i).service.getClassName().contains("StartService") == true){
                    stopService(startIntent);
                    break;
                }
            }
        }
        super.onDestroy();
    }


}