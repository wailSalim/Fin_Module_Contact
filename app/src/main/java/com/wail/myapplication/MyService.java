package com.wail.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyService extends Service {
    public int cn=0;
//    public base_donne db=new base_donne(MyService.this,"login",null,1);
    public MyService() {

    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "start ", Toast.LENGTH_LONG).show();
        return super.onStartCommand(intent, flags, startId);
       
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "end", Toast.LENGTH_LONG).show();
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;

    }


}