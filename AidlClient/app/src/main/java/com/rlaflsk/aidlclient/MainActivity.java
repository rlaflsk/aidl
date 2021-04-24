package com.rlaflsk.aidlclient;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.rlaflsk.aidlserver.IListener;
import com.rlaflsk.aidlserver.client.ConnectApi;
import com.rlaflsk.aidlserver.client.Data;
import com.rlaflsk.aidlserver.client.SubApi1;
import com.rlaflsk.aidlserver.client.SubApi2;
import com.rlaflsk.aidlserver.client.ConnectListener;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "AidlClient";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void connect(View view) {
        Log.i(TAG, "connect");
        ConnectApi.getInstance().connect(this, new ConnectListener() {
            @Override
            public void handleApiConnected() {
                Log.i(TAG, "api connected");
                Log.i(TAG, SubApi1.getInstance().getName());
                Log.i(TAG, SubApi2.getInstance().getName());
            }

            @Override
            public void handleApiDisconnected() {
                Log.i(TAG, "api disconnected");
            }
        });
    }

    public void disconnect(View view) {
        Log.i(TAG, "disconnect");
        ConnectApi.getInstance().disconnect();
    }

    public void set(View view) {
        Data data = new Data();
        data.setData("data");
        SubApi1.getInstance().setData(data, new IListener.Stub() {
            @Override
            public void onSucess() {
                Log.i(TAG, "onSuccess");
            }
        });
    }

    public void get(View view) {
        Log.i(TAG, SubApi1.getInstance().getData().getData());
    }
}