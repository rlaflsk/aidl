package com.rlaflsk.aidlserver.server;

import android.os.IBinder;
import android.util.Log;

import com.rlaflsk.aidlserver.IBinderPool;
import com.rlaflsk.aidlserver.client.Definition;

public class BinderPoolServer extends IBinderPool.Stub {
    @Override
    public IBinder queryBinder(int binderCode) {
        Log.i("AidlServer", "queryBinder" + binderCode);
        switch (binderCode) {
            case Definition.BINDER1:
                return new Binder1Server();
            case Definition.BINDER2:
                return new Binder2Server();
            default:
                return null;
        }
    }
}
