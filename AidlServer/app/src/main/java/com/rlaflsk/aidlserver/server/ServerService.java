package com.rlaflsk.aidlserver.server;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class ServerService extends Service {
    @Override
    public IBinder onBind(Intent intent) {
        return new BinderPoolServer();
    }
}
